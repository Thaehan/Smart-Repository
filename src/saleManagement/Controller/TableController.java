package saleManagement.Controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import saleManagement.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import saleManagement.Model.TableModel;
import saleManagement.Resource;

import java.util.Optional;

public class TableController {
    TableModel tableModel = new TableModel();
    @FXML
    Button logoutButton;

    public void logout(ActionEvent event) {
        try{
            Launcher.parent = FXMLLoader.load(getClass().getResource(Resource.viewFolder + "Login.fxml"));
            Launcher.scnene = new Scene(Launcher.parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(Launcher.scnene);
            window.show();
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
            logout(event);
        }
        else {
            return;
        }
    }

}
