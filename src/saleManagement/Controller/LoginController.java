package saleManagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import saleManagement.Model.LoginModel;
import saleManagement.View.AdditionalView;

public class LoginController extends BigController {
    LoginModel loginModel = new LoginModel();
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button recoveryButton;

    public void loginPressed(ActionEvent event)  {
        String acc = account.getText();
        String pas = password.getText();
        if (loginModel.checkLogin(acc, pas)) {
            changeHomeScene(event);
        }
        else {
            AdditionalView.wrongPass();
        }
    }

    public void recoveryPressed(ActionEvent event) {
        System.out.println("recovery");
    }

    public String getAccount() {
        return account.getText();
    }

    public String getPassword() {
        return password.getText();
    }
}
