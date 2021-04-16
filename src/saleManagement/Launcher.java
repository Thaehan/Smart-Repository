package saleManagement;
import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Launcher extends Application{
    public static Parent parent;
    public static String viewFolder = "/saleManagement/View/";
    public static String resouceFolder = "/resource/";

    public void start(Stage primaryStage) throws Exception {
        try{
            parent = FXMLLoader.load(getClass().getResource(viewFolder + "Login.fxml"));
            Scene loginScene = new Scene(parent);
            parent.getStylesheets().add(getClass().getResource(resouceFolder + "stylesheet.css").toString());
            primaryStage.setTitle("Sales Management");
            primaryStage.setIconified(false);
            primaryStage.setResizable(false);
            primaryStage.setScene(loginScene);
            primaryStage.show();
            new FadeIn(parent).play();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
