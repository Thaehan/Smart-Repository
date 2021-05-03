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

    public static void invalid() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setContentText("Please check information again! Something could be invalid!");
        alert.setHeaderText(null);
        alert.show();
    }

    public static void done() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congrat!");
        alert.setContentText("Update has been done!");
        alert.setHeaderText(null);
        alert.show();
    }

}
