package saleManagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import saleManagement.Model.RecentsModel;

import java.net.URL;
import java.util.ResourceBundle;

public class RecentsController extends BigController implements Initializable {
    @FXML
    TableView<RecentsModel> importTable;

    @FXML
    TableView<RecentsModel> exportTable;

    @FXML
    TableColumn<RecentsModel, String> importCode;

    @FXML
    TableColumn<RecentsModel, String> importProductCode;

    @FXML
    TableColumn<RecentsModel, Integer> importQuantity;

    @FXML
    TableColumn<RecentsModel, String> importDate;

    @FXML
    TableColumn<RecentsModel, String> exportCode;

    @FXML
    TableColumn<RecentsModel, String> exportProductCode;

    @FXML
    TableColumn<RecentsModel, Integer> exportQuantity;

    @FXML
    TableColumn<RecentsModel, String> exportDate;

    private static ObservableList<RecentsModel> importModel;
    private static ObservableList<RecentsModel> exportModel;
    @Override
    public void initialize (URL url , ResourceBundle resourceBundle) {
        getDataList();
        importTable.setItems(importModel);
        exportTable.setItems(exportModel);
    }

    public void getDataList() {
        ObservableList<RecentsModel> tempList1 = FXCollections.observableArrayList();
        ObservableList<RecentsModel> tempList2 = FXCollections.observableArrayList();
        try {
            String query2 = "SELECT `importCode`, `productCode`, `quantity`, `date` FROM `import` ORDER BY `date` DESC";
            resultSet = statement.executeQuery(query2);
            while (resultSet.next()) {
//                RecentsModel newModel = new RecentsModel(resultSet.getInt("importCode"),
//                        resultSet.getString("productCode"),
//                        resultSet.getInt("quantity"),
//                        resultSet.getDate("date").toString());
                tempList2.add(new RecentsModel(resultSet.getString("importCode"),
                        resultSet.getString("productCode"),
                        resultSet.getInt("quantity"),
                        resultSet.getDate("date").toString()));

            }
            importModel = tempList2;

            String query1 = "SELECT `exportCode`, `productCode`, `quantity`, `date` FROM `export` ORDER BY `date` DESC";
            resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
//                RecentsModel newModel = new RecentsModel(resultSet.getInt("exportCode"),
//                        resultSet.getString("productCode"),
//                        resultSet.getInt("quantity"),
//                        resultSet.getDate("date").toString());
                tempList1.add(new RecentsModel(resultSet.getString("exportCode"),
                        resultSet.getString("productCode"),
                        resultSet.getInt("quantity"),
                        resultSet.getDate("date").toString()));

            }

            exportModel = tempList1;

            exportCode.setCellValueFactory(new PropertyValueFactory<> ("transactionCode"));
            exportProductCode.setCellValueFactory(new PropertyValueFactory<> ("productCode"));
            exportQuantity.setCellValueFactory(new PropertyValueFactory<> ("quantity"));
            exportDate.setCellValueFactory(new PropertyValueFactory<> ("date"));

            importCode.setCellValueFactory(new PropertyValueFactory<>("transactionCode"));
            importProductCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
            importQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            importDate.setCellValueFactory(new PropertyValueFactory<>("date"));


        } catch(Exception e) {
            System.out.println("Can't load recent Database");
        }
    }

}
