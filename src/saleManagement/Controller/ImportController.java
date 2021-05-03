package saleManagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import saleManagement.Model.ImportModel;
import saleManagement.View.AdditionalView;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ImportController extends BigController implements Initializable {
    @FXML
    Button confirmButton;

    @FXML
    Button cancelButton;

    @FXML
    ComboBox<String> productCodeBox;

    @FXML
    TextField quantityBox;

    @FXML
    TextField sourceBox;

    @FXML
    DatePicker dateBox;

    @FXML
    TextArea noteBox;

    @FXML
    Label maxQuantityLabel;

    @FXML
    Button addProductCodeButton;

    private ImportModel importModel = new ImportModel();
    private int currentQuantity;

    @Override
    public void initialize (URL url , ResourceBundle resourceBundle) {
        loadComboData();
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

    public void cancelButtonPressed(ActionEvent event) {
        // update

        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void confirmButtonPressed(ActionEvent event) {
        String source = sourceBox.getText();
        String note = noteBox.getText();

        try {
            //get all data to models
            Date date = Date.valueOf(dateBox.getValue());
            String productCode = productCodeBox.getValue();
            int quantity = Integer.parseInt(quantityBox.getText());

            importModel.setDate(date);
            importModel.setProductCode(productCode);
            importModel.setQuantity(quantity);
            importModel.setSource(source);
            importModel.setNote(note);
        } catch (Exception e) {
            AdditionalView.invalid();
        }

        //execute query
        if (checkDate(importModel.getDate()) && !source.isEmpty()) {
            executeImport(importModel.getProductCode(), importModel.getQuantity());
            importReport();
            resetInfo();
        }
        else {
            AdditionalView.invalid();
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

    public void executeImport(String productCode, Integer quantity) {
        try {
            int newQuantity = currentQuantity + quantity;
            String query = "UPDATE `salemanagement`.`products`"
                    + " SET `quantity` = ?"
                    + " WHERE `productCode` = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setString(2, productCode);
            preparedStatement.executeUpdate();
            updateCurrentQuantity(null);

            AdditionalView.done();
        } catch(Exception e) {
//            System.out.println("Can't execute export SQL");
            AdditionalView.invalid();
        }
    }

    public void importReport() {
        try {
            String query = "INSERT INTO `salemanagement`.`import` (`productCode`, `quantity`, `date`, `source`, `note`) " +
                    "VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, importModel.getProductCode());
            preparedStatement.setInt(2, importModel.getQuantity());
            preparedStatement.setDate(3, importModel.getDate());
            preparedStatement.setString(4, importModel.getSource ());
            preparedStatement.setString(5, importModel.getNote());
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println("Can't report import");
        }
    }

    public void updateCurrentQuantity(ActionEvent event) {
        try {
            String currentProduct = productCodeBox.getSelectionModel().getSelectedItem();
            String query = "SELECT quantity FROM products WHERE productCode = '"
                    + currentProduct + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            currentQuantity = resultSet.getInt(1);
            maxQuantityLabel.setText("St: " + currentQuantity);
        } catch(Exception e) {
            AdditionalView.invalid();
//            System.out.println("Failed update max quantity");
        }
    }

    public void resetInfo() {
        quantityBox.setText("");

        sourceBox.setText("");

        dateBox.setValue(null);

        noteBox.setText("");
    }

    public void addProductCodeButtonPressed(ActionEvent event) {
        System.out.println("add");
    }
}
