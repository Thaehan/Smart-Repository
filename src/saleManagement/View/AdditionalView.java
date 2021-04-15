package saleManagement.View;

import javafx.scene.control.Alert;

public class AdditionalView {
    public static void wrongPass() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login warning!");
        alert.setContentText("You have entered wrong username or password!");
        alert.setHeaderText(null);
        alert.show();
    }



}
