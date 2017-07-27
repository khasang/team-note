package io.khasang.teamnote.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for communication with the database
 *
 * @author gothmog on 28.07.2017.
 */
public interface DaoFactory {
    Connection getConnection() throws SQLException, IOException;
}
