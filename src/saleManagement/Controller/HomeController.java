package saleManagement.Controller;

import animatefx.animation.FadeIn;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import saleManagement.Launcher;
import saleManagement.Model.HomeModel;
import saleManagement.Resource;

import java.util.Optional;

public class HomeController {
    HomeModel homeModel = new HomeModel();
    @FXML
    Button logoutButton;

    public void changeLoginScene(ActionEvent event) {
        try{
            Launcher.parent = FXMLLoader.load(getClass().getResource(Resource.viewFolder + "Login.fxml"));
            Scene scnene = new Scene(Launcher.parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scnene);
            window.show();
            new FadeIn(Launcher.parent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void logoutButtonPressed(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Logout");
        confirm.setContentText("Are you sure you want to logout?");
        confirm.setHeaderText(null);
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.get() == ButtonType.OK) {
            changeLoginScene(event);
        }
        else {
            return;
        }
    }

}
