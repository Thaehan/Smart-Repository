package saleManagement.Login;
import saleManagement.ResourceDestination.Resource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Login extends Application{

    public void start(Stage primaryStage) throws Exception {
        try{
            Parent parentRoot = FXMLLoader.load(getClass().getResource(Resource.fxmlFolder + "Login.fxml"));
            Scene scene = new Scene(parentRoot);
            parentRoot.getStylesheets().add(getClass().getResource(Resource.resouceFolder + "stylesheet.css").toString());
            primaryStage.setTitle("Login Sales Management");
            primaryStage.setIconified(false);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
