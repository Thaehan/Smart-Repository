package saleManagement.Model;

public class RecentsModel {
    String transactionCode;
    String productCode;
    int quantity;
    String date;

    public RecentsModel (String transactionCode , String productCode , int quantity , String date) {
        this.transactionCode = transactionCode;
        this.productCode = productCode;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionCode () {

        return transactionCode;
    }

    public void setTransactionCode (String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getProductCode () {
        return productCode;
    }

    public void setProductCode (String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }
}
