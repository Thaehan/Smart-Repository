package saleManagement;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import saleManagement.View.LoginView;

public class Launcher extends Application{

    public void start(Stage primaryStage) throws Exception {
        try{
            Scene scene = new LoginView().loginScene();
            primaryStage.setTitle("Sales Management");
            primaryStage.setIconified(false);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
