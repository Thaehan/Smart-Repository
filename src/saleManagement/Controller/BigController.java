package saleManagement.Controller;

import animatefx.animation.BounceInDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import saleManagement.Launcher;

public abstract class BigController {
    public void changeHomeScene(ActionEvent event) {
        try {
            Launcher.parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Home.fxml"));
            Scene homeScene = new Scene(Launcher.parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
            new BounceInDown (Launcher.parent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
