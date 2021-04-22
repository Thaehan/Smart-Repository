package saleManagement.Model;

public class RepositoryModel {
    String productName, productCode, category, measure, details;
    Integer quantity, unitPrice;

    public RepositoryModel(String productName, String productCode, String category, String measure, String details, Integer quantity, Integer unitPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.category = category;
        this.measure = measure;
        this.details = details;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getDetails() {
        return this.details;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getMeasure() {
        return measure;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public String getCategory() {
        return category;
    }
}
