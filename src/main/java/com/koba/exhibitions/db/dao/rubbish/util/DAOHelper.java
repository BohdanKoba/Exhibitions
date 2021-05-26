package com.koba.exhibitions.db.dao.rubbish.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOHelper {
    private static final Logger logger = LogManager.getLogger(DAOHelper.class);

    /**
     * Closes a resource.
     *
     * @param ac AutoClosable resource
     */
    public static void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                logger.error("Failed to close the resource", ex);
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
    public static void rollback(java.sql.Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex) {
            logger.error("Failed to rollback the operation", ex);
        }
    }

}
