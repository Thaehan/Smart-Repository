package saleManagement.Model;

import java.sql.DriverManager;

public class HomeModel extends DatabaseConnection{
    public HomeModel() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `adminuser`");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
