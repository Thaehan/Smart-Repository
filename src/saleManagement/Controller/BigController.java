package saleManagement.Controller;

import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import saleManagement.Launcher;

import java.sql.*;

public abstract class BigController {
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/saleManagement";
    protected static final String USER_NAME = "root";
    protected static final String PASSWORD = "";
    protected Connection connection = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    public BigController() {
        try {
            //Connection to database
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            //Create statement
            statement = connection.createStatement();
            //Get data
            resultSet = null;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changeHomeScene(ActionEvent event) {
        try {
            Parent homeParent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + "Dashboard.fxml"));
            homeParent.getStylesheets().add(getClass().getResource(Launcher.resouceFolder + "stylesheet.css").toString());
            Scene homeScene = new Scene(homeParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
            new BounceInUp(homeParent).play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
