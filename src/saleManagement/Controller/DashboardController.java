package saleManagement.Controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import saleManagement.Launcher;

import java.util.Optional;

public class DashboardController extends BigController {
    @FXML
    protected BorderPane borderPane;
    @FXML
    protected Button homeButton;
    @FXML
    protected Button stockButton;
    @FXML
    protected Button logoutButton;

    public void changeLoginScene(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Login.fxml"));
            Scene loginScene = new Scene(parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
            new FadeIn (parent).play();
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
    }

    public void homButtonPressed(ActionEvent event) {
        loadUI("Overview.fxml");
    }

    public void stockButtonPressed(ActionEvent event) {
        loadUI("Repository.fxml");
    }

    protected void loadUI(String fxmlFile) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + fxmlFile));
        } catch(Exception e) {
            e.printStackTrace();
        }
        borderPane.setCenter(parent);
        new animatefx.animation.FadeIn(parent).play();
    }

}
