package de.telran.onlineshop.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Product {
    private long productID;
    private String name;
    private String description;
    private double price;
    private long categoryID;
    private String imageURL;
    private double discountPrice;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Product() {
    }

    public Product(long productID, String name, String description, double price, long categoryID, String imageURL, double discountPrice, LocalDate createdAt, LocalDate updatedAt) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.imageURL = imageURL;
        this.discountPrice = discountPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Double.compare(price, product.price) == 0 && categoryID == product.categoryID && Double.compare(discountPrice, product.discountPrice) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(imageURL, product.imageURL) && Objects.equals(createdAt, product.createdAt) && Objects.equals(updatedAt, product.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, description, price, categoryID, imageURL, discountPrice, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryID=" + categoryID +
                ", imageURL='" + imageURL + '\'' +
                ", discountPrice=" + discountPrice +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}