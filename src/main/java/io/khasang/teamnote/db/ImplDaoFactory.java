package io.khasang.teamnote.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * implementation DaoFactory *
 * @author gothmog on 28.07.2017.
 */
public class ImplDaoFactory implements DaoFactory {
    private static final Logger log = LoggerFactory.getLogger(ImplDaoFactory.class);

    private final static String DRIVER = "org.postgresql.Driver";
    private final static String URL = "jdbc:postgresql://localhost:5432/teamnote";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public ImplDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            log.error("Error when registering PostgreSQL driver", ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException, IOException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
