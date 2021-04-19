package saleManagement.Controller;

import animatefx.animation.BounceInDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import saleManagement.Launcher;

public abstract class BigController {
    public void changeHomeScene(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Dashboard.fxml"));
            parent.getStylesheets().add(getClass().getResource(Launcher.resouceFolder + "stylesheet.css").toString());
            Scene homeScene = new Scene(parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
            new BounceInDown(parent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
