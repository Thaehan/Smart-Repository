package saleManagement.Model;

import java.sql.Date;

public class ExportModel {
    String productCode;
    int quantity;
    Date date;
    String destination;
    String note;

    public ExportModel () {
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDestination (String destination) {
        this.destination = destination;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate () {
        return date;
    }

    public String getDestination () {
        return destination;
    }

    public String getNote () {
        return note;
    }
}
