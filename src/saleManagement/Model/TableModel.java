package saleManagement.Model;

import java.sql.DriverManager;

public class TableModel extends DatabaseConnection{
    public TableModel() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `adminuser`");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
