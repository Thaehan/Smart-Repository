package saleManagement.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import saleManagement.Resource;
import java.io.IOException;

public class LoginView {
    private Parent parentRoot = null;
    private Scene scene = null;

    public static void wrongPass() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login warning!");
        alert.setHeaderText("You have entered wrong account or password!");
        alert.show();
    }

    public Scene loginScene() throws IOException {
        parentRoot = FXMLLoader.load(getClass().getResource(Resource.viewFolder + "Login.fxml"));
        scene = new Scene(parentRoot);
        parentRoot.getStylesheets().add(getClass().getResource(Resource.resouceFolder + "stylesheet.css").toString());
        return scene;
    }


}
