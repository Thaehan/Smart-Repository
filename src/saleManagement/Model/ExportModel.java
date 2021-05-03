package saleManagement.Model;

public class ExportModel {
    String productCode;
    int quantity;
    String date;
    String source;
    String note;

    public ExportModel () {

    }
    public ExportModel (String productCode, int quantity, String date, String source, String note) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.date = date;
        this.source = source;
        this.note = note;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
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

    public String getDate () {
        return date;
    }

    public String getSource () {
        return source;
    }

    public String getNote () {
        return note;
    }
}
