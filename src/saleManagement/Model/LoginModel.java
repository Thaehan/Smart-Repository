package saleManagement.Model;

import java.sql.*;

public class LoginModel extends ModelResource {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

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



    public static void main(String[] args) throws Exception {
        LoginModel db = new LoginModel();
    }
}
