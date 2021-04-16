package saleManagement.Controller;

import animatefx.animation.FadeInUpBig;
import saleManagement.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import saleManagement.Model.LoginModel;
import saleManagement.View.AdditionalView;

public class LoginController {
    LoginModel loginModel = new LoginModel();
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

    public void changeHomeScene(ActionEvent event) {
        try {
            Launcher.parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Home.fxml"));
            Scene homeScene = new Scene(Launcher.parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
            new FadeInUpBig(Launcher.parent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

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
