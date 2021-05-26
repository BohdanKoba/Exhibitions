package com.koba.exhibitions.db.dao.connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class that provides connection to the database.
 * Contains utility methods for working with connection.
 */
public class Connector {
    private static final Logger logger = LogManager.getLogger(Connector.class);

    private static Connector instance;

    public static synchronized Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    private Connector() {
    }

    /**
     * Returns a DB connection from the Pool Connections.
     *
     * @return a DB connection
     */
    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/exhibitions");
            con = ds.getConnection();
        } catch (NamingException ex) {
            logger.error("Cannot obtain a connection from the pool", ex);
        }
        return con;
    }

    /**
     * Closes resources.
     *
     * @param con Connection object to be closed
     * @param st  Statement object to be closed
     * @param rs  ResultSet object to be closed
     */
    public static void close(Connection con, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                st.close();
            } catch (Exception ex) {
                logger.error("Failed to close ResultSet", ex);
            }
        }
        close(con, st);
    }

    /**
     * Closes resources.
     *
     * @param con Connection object to be closed
     * @param st  Statement object to be closed
     */
    public static void close(Connection con, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Exception ex) {
                logger.error("Failed to close Statement", ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception ex) {
                logger.error("Failed to close Connection", ex);
            }
        }
    }

    /**
     * Commits the operation.
     *
     * @param con connection to be commited
     */
    public static void commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException ex) {
            logger.error("Failed to commit the operation", ex);
        }
    }

    /**
     * Rollbacks the operation.
     *
     * @param con connection to be rollbacked
     */
    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex) {
            logger.error("Failed to rollback the operation", ex);
        }
    }

}
