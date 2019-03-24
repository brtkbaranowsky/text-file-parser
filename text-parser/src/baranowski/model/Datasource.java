package baranowski.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {


    public static final String DB_DRIVER = "jdbc:sqlite:";
    public static final String DB_PATH = "C:\\Users\\bbar\\Desktop\\Spring\\Music\\";
    public static final String DB_NAME = "BN.db";

    public static final String CONNECTION_STRING = DB_DRIVER + DB_PATH + DB_NAME;

    public static final String CUSTOMERS_TABLE = "customers";
    public static final String CUSTOMER_COLUMN_ID = "_id";
    public static final String CUSTOMER_COLUMN_NAME = "name";
    public static final String CUSTOMER_COLUMN_SURNAME = "surname";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final int CUSTOMER_INDEX_ID = 1;
    public static final int CUSTOMER_INDEX_NAME = 2;
    public static final int CUSTOMER_INDEX_SURNAME = 3;
    public static final int CUSTOMER_INDEX_AGE = 4;

    public static final String CONTACTS_TABLE = "contacts";
    public static final String CONTACT_COULUMN_ID = "_id";
    public static final String CONTACT_COULUMN_CUSTOMER_ID = "customer_id";
    public static final String CONTACT_COULUMN_TYPE = "type";
    public static final String CONTACT_COULUMN_VALUE = "value";
    public static final int CONTACT_INDEX_ID = 1;
    public static final int CONTACT_INDEX_CUSTOMER_ID = 2;
    public static final int CONTACT_INDEX_TYPE = 3;
    public static final int CONTACT_INDEX_VALUE = 4;

    public boolean open() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
