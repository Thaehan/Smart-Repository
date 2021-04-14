package saleManagement.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button recoveryButton;
    @FXML
    private ImageView bgimage;

    public void loginPressed(ActionEvent event) {
        String acc = getAccount();
        String pas = getPassword();
        System.out.println("login");
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
