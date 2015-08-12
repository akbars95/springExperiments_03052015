package com.mtsmda.web.domain;

import java.math.BigDecimal;

/**
 * Created by MTSMDA on 01.08.2015.
 */
public class Product {
    private String productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    public Product() {
    }

    public	Product(String	productId,	String	name,	BigDecimal	unitPrice)	{
        this.productId	=	productId;
        this.name	=	name;
        this.unitPrice	=	unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (unitsInStock != product.unitsInStock) return false;
        if (unitsInOrder != product.unitsInOrder) return false;
        if (discontinued != product.discontinued) return false;
        if (!productId.equals(product.productId)) return false;
        if (!name.equals(product.name)) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (manufacturer != null ? !manufacturer.equals(product.manufacturer) : product.manufacturer != null)
            return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        return !(condition != null ? !condition.equals(product.condition) : product.condition != null);

    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (int) (unitsInStock ^ (unitsInStock >>> 32));
        result = 31 * result + (int) (unitsInOrder ^ (unitsInOrder >>> 32));
        result = 31 * result + (discontinued ? 1 : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", unitsInStock=" + unitsInStock +
                ", unitsInOrder=" + unitsInOrder +
                ", discontinued=" + discontinued +
                ", condition='" + condition + '\'' +
                '}';
    }
}