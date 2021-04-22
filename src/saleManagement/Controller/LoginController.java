package saleManagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import saleManagement.Model.LoginModel;
import saleManagement.View.AdditionalView;

public class LoginController extends BigController {
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button recoveryButton;

    private LoginModel loginModel;

    public void loginPressed(ActionEvent event){
        loginModel = new LoginModel(account.getText(), password.getText());
        if (checkLogin(loginModel.getAccount(), loginModel.getPassword())) {
            changeHomeScene(event);
        }
        else {
            AdditionalView.wrongPass();
        }
    }

    public void recoveryPressed(ActionEvent event) {
        System.out.println("recovery");
    }

    public boolean checkLogin(String account, String password) {
        loadData();
        try {
            while(resultSet.next()) {
                if (account.equals(resultSet.getString("Account")) && password.equals(resultSet.getString("Password"))) {
                    return true;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void loadData() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM `adminuser`");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
