package de.telran.onlineshop.model;

import java.util.Objects;

public class Favorite {
    private long  favoriteID;
    private long userID;
    private long productID;

    public Favorite(long favoriteID, long userID, long productID) {
        this.favoriteID = favoriteID;
        this.userID = userID;
        this.productID = productID;
    }

    public long getFavoriteID() {
        return favoriteID;
    }

    public long getUserID() {
        return userID;
    }

    public long getProductID() {
        return productID;
    }

    public void setFavoriteID(long favoriteID) {
        this.favoriteID = favoriteID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return favoriteID == favorite.favoriteID && userID == favorite.userID && productID == favorite.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteID, userID, productID);
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "favoriteID=" + favoriteID +
                ", userID=" + userID +
                ", productID=" + productID +
                '}';
    }
}
