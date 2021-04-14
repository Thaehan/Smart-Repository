package saleManagement.Model;

import java.sql.DriverManager;

public class LoginModel extends DatabaseConnection {
    public LoginModel(){
        try {
            //Connection to database
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            //Create statement
            statement = connection.createStatement();
            //Get data
            resultSet = statement.executeQuery("SELECT * FROM `adminuser`");
            //Show data
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void loadResultSet() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM `adminuser`");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String account, String password) {
        try{
            while(resultSet.next()) {
                if (account.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {
                    loadResultSet();
                    return true;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        loadResultSet();
        return false;
    }

}
