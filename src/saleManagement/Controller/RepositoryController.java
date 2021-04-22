package saleManagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    }

    public ObservableList<RepositoryModel> getDataList() {
        ObservableList<RepositoryModel> tempList = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM products";
            resultSet = connection.createStatement().executeQuery(query);
            while (this.resultSet.next()) {
                tempList.add(new RepositoryModel(resultSet.getString("productName"), resultSet.getString("productCode"),
                        resultSet.getString("productLine"),resultSet.getString("measure"), resultSet.getNString("details"), resultSet.getInt("quantity"), resultSet.getInt("unitPrice")));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tempList;
    }
}
