package saleManagement.View;

import javafx.scene.control.Alert;

public class AdditionalView {
    public static void wrongPass() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login warning!");
        alert.setHeaderText("You have entered wrong account or password!");
        alert.show();
    }

}
