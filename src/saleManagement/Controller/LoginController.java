package saleManagement.Controller;

import saleManagement.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import saleManagement.Model.LoginModel;
import saleManagement.View.AdditionalView;

public class LoginController {
    LoginModel loginModel = new LoginModel();
    @FXML
    private BorderPane mainPane;

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

    @FXML
    public void goToTable(ActionEvent event) {
        try {
            Parent tableParent = FXMLLoader.load(getClass().getResource(Resource.viewFolder + "Table.fxml"));
            Scene tableScene = new Scene(tableParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableScene);
            window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void loginPressed(ActionEvent event)  {
        String acc = account.getText();
        String pas = password.getText();
        if (loginModel.checkLogin(acc, pas)) {
            //To do
            goToTable(event);
            System.out.println("true");
        }
        else {
            AdditionalView.wrongPass();
            System.out.println("false");
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
