package com.koba.exhibitions.db.dao.util;

/**
 * Class that contains database fields names.
 */
public class Fields {
    public static final String COLUMN_ID = "id";

    public static final String ACCOUNT_COLUMN_LOGIN = "login";
    public static final String ACCOUNT_COLUMN_PASSWORD = "password";
    public static final String ACCOUNT_COLUMN_FIRST_NAME = "first_name";
    public static final String ACCOUNT_COLUMN_LAST_NAME = "last_name";
    public static final String ACCOUNT_COLUMN_EMAIL = "email";
    public static final String ACCOUNT_COLUMN_ROLE = "role";

    public static final String EXHIBITION_COLUMN_TITLE = "title";
    public static final String EXHIBITION_COLUMN_DESCRIPTION = "description";
    public static final String EXHIBITION_COLUMN_PRICE = "price";
    public static final String EXHIBITION_COLUMN_START_DATE = "start_date";
    public static final String EXHIBITION_COLUMN_END_DATE = "end_date";
    public static final String EXHIBITION_COLUMN_OPENING_TIME = "opening_time";
    public static final String EXHIBITION_COLUMN_CLOSING_TIME = "closing_time";
    public static final String EXHIBITION_COLUMN_STATUS = "status";

    public static final String EXHIBITION_HALL_COLUMN_EXHIBITION_ID = "exhibition_id";
    public static final String EXHIBITION_HALL_COLUMN_HALL_ID = "hall_id";

    public static final String HALL_COLUMN_HALL_NAME = "hall_name";

    public static final String ORDER_COLUMN_BILL = "bill";
    public static final String ORDER_COLUMN_ACCOUNT_ID = "account_id";

    public static final String ORDER_EXHIBITION_COLUMN_ACCOUNT_ORDER_ID = "account_order_id";
    public static final String ORDER_EXHIBITION_COLUMN_EXHIBITION_ID = "exhibition_id";
    public static final String ORDER_EXHIBITION_COLUMN_COUNT = "count";

}
