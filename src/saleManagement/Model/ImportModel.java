package saleManagement.Model;

import java.sql.Date;

public class ImportModel {
    String productCode;
    int quantity;
    Date date;
    String source;
    String note;

    public ImportModel() {
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

    public void setSource(String source) {
        this.source = source;
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

    public Date getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getNote() {
        return note;
    }
}
