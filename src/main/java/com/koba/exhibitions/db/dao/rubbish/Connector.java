package com.koba.exhibitions.db.dao.rubbish;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This class establishes connection to database.
 */
public class Connector {
    private static final Logger logger = LogManager.getLogger(Connector.class);

    private static Connector instance;

    public static synchronized Connector getInstance() {
        if (instance == null)
            instance = new Connector();
        return instance;
    }


}
