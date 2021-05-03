package saleManagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import saleManagement.Model.ExportModel;
import saleManagement.View.AdditionalView;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ExportController extends BigController implements Initializable {
    @FXML
    Button confirmButton;

    @FXML
    Button cancelButton;

    @FXML
    ComboBox<String> productCodeBox;

    @FXML
    TextField quantityBox;

    @FXML
    TextField destinationBox;

    @FXML
    DatePicker dateBox;

    @FXML
    TextArea noteBox;

    @FXML
    Label maxQuantityLabel;

    private ExportModel exportModel = new ExportModel ();
    private int max;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboData();
    }

    public void confirmButtonPressed(ActionEvent event) {
        String destination = destinationBox.getText();
        String note = noteBox.getText();

        try {
            //get all data to models
            Date date = java.sql.Date.valueOf(dateBox.getValue());
            String productCode = productCodeBox.getValue();
            int quantity = Integer.parseInt(quantityBox.getText());

            exportModel.setDate(date);
            exportModel.setProductCode(productCode);
            exportModel.setQuantity(quantity);
            exportModel.setDestination(destination);
            exportModel.setNote(note);
        } catch (Exception e) {
            AdditionalView.invalid();
        }

        //execute query
        if (checkDate(exportModel.getDate()) && checkQuantity(exportModel.getQuantity())) {
            executeExport(exportModel.getProductCode(), exportModel.getQuantity());
            exportReport();
            resetInfo();
        }
        else {
            AdditionalView.invalid();
        }

    }


    public void loadComboData() {
        try {
            ObservableList<String> list = FXCollections.observableArrayList();
            String query = "SELECT `productCode` FROM `products`";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            productCodeBox.setItems(list);
        } catch (Exception e) {
//            System.out.println("can't load product lines data");
            e.printStackTrace();
        }
    }

    public boolean checkDate(Date date) {
        try {
            String query = "SELECT DATE(NOW())";
            resultSet = statement.executeQuery(query);
            resultSet.next();

            if (resultSet.getDate(1).compareTo(date) >= 0) {
                return true;
            }
        } catch (Exception e) {
//            System.out.println("checkDate error!");
        }
        return false;
    }

    public boolean checkQuantity(Integer quantity) {
        if (quantity <= max) {
            return true;
        }
        return false;
    }

    public void executeExport(String productCode, Integer quantity) {
        try {
            int remain = max - quantity;
            String query = "UPDATE `salemanagement`.`products`"
                    + " SET `quantity` = ?"
                    + " WHERE `productCode` = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, remain);
            preparedStatement.setString(2, productCode);
            preparedStatement.executeUpdate();
            updateMaxQuantity(null);

            AdditionalView.done();
        } catch(Exception e) {
//            System.out.println("Can't execute export SQL");
            AdditionalView.invalid();
        }
    }

    public void exportReport() {
        try {
            String query = "INSERT INTO `salemanagement`.`export` (`productCode`, `quantity`, `exportDate`, `destination`, `note`) " +
                    "VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exportModel.getProductCode());
            preparedStatement.setInt(2, exportModel.getQuantity());
            preparedStatement.setDate(3, exportModel.getDate());
            preparedStatement.setString(4, exportModel.getDestination());
            preparedStatement.setString(5, exportModel.getNote());
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println("Can't report export");
        }
    }

    public void updateMaxQuantity(ActionEvent event) {
        try {
            String currentProduct = productCodeBox.getSelectionModel().getSelectedItem();
            String query = "SELECT quantity FROM products WHERE productCode = '"
                    + currentProduct + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            max = resultSet.getInt(1);
            maxQuantityLabel.setText("< " + max);
        } catch(Exception e) {
            AdditionalView.invalid();
//            System.out.println("Failed update max quantity");
        }
    }

    public void cancelButtonPressed(ActionEvent event) {
        // update

        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void resetInfo() {
        quantityBox.setText("");

        destinationBox.setText("");

        dateBox.setValue(null);

        noteBox.setText("");
    }
}
