package saleManagement.Model;

import java.sql.DriverManager;

public class TableModel extends DatabaseConnection{
    TableModel() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `product`");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
