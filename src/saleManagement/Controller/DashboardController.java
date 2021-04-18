package saleManagement.Controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import saleManagement.Launcher;

import java.util.Optional;

public abstract class DashboardController extends BigController {
    @FXML
    protected Button homeButton;
    @FXML
    protected Button stockButton;
    @FXML
    protected Button historyButton;
    @FXML
    protected Button helpButton;
    @FXML
    protected Button logoutButton;

    public void changeLoginScene(ActionEvent event) {
        try{
            Launcher.parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Login.fxml"));
            Scene loginScene = new Scene(Launcher.parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
            new FadeIn (Launcher.parent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void stockButtonPressed(ActionEvent event) {
        System.out.println("stock");
    }

    public void historyButtonPressed(ActionEvent event) {
        System.out.println("history");
    }

    public void helpButtonPressed(ActionEvent event) {
        System.out.println("help");
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
}
