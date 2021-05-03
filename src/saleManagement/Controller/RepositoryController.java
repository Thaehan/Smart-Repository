package saleManagement.Controller;

import animatefx.animation.BounceInDown;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import saleManagement.Launcher;
import saleManagement.Model.RepositoryModel;

import java.net.URL;
import java.util.ResourceBundle;

public class RepositoryController extends BigController implements Initializable {
    @FXML
    private TableView<RepositoryModel> productsTable;

    @FXML
    private TableColumn<RepositoryModel, String> productName;

    @FXML
    private TableColumn<RepositoryModel, String> productCode;

    @FXML
    private TableColumn<RepositoryModel, String> category;

    @FXML
    private TableColumn<RepositoryModel, Integer> quantity;

    @FXML
    private TableColumn<RepositoryModel, String> measure;

    @FXML
    private TableColumn<RepositoryModel, String> details;

    @FXML
    private TableColumn<RepositoryModel, Integer> unitPrice;

    @FXML
    private Button importButton;

    @FXML
    private Button exportButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button recentsButton;

    @FXML
    private Label totalProductLabel;

    @FXML
    private Label totalQuantityLabel;

    private ObservableList<RepositoryModel> list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        measure.setCellValueFactory(new PropertyValueFactory<>("measure"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        list = getDataList();
        productsTable.setItems(list);
        loadLabel();
    }

    public ObservableList<RepositoryModel> getDataList() {
        ObservableList<RepositoryModel> tempList = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM products";
            resultSet = statement.executeQuery(query);
            while (this.resultSet.next()) {
                tempList.add(new RepositoryModel(resultSet.getString("productName"), resultSet.getString("productCode"),
                        resultSet.getString("productLine"),resultSet.getString("measure"), resultSet.getNString("details"), resultSet.getInt("quantity"), resultSet.getInt("unitPrice")));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tempList;
    }

    public void loadLabel() {
        try {
            String query = "SELECT COUNT(productCode) AS totalProduct, SUM(quantity) AS totalQuantity FROM products";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            totalProductLabel.setText("Total Products: " + resultSet.getString(1));
            totalQuantityLabel.setText("Total Quantity: " + resultSet.getString(2));
        } catch(Exception e) {
            System.out.println("Can't get total data for label");
        }
    }

    public void importButtonPressed(ActionEvent event) {
        System.out.println("import");
    }

    public void exportButtonPressed(ActionEvent event) {
        loadFunction("Export.fxml");

    }

    public void searchButtonPressed(ActionEvent event) {
        System.out.println("search");
    }

    public void recentsButtonPressed(ActionEvent event) {
        System.out.println("recents");
    }

    public void loadFunction(String fxmlFile) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(Launcher.viewFolder + fxmlFile));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            new BounceInDown(parent).play();
        } catch(Exception e) {
            System.out.println("Can't load function File");
        }
    }
}
