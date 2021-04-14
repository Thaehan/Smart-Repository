package saleManagement.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class DatabaseConnection {
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/saleManagement";
    protected static final String USER_NAME = "root";
    protected static final String PASSWORD = "";
    protected Connection connection = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
}
