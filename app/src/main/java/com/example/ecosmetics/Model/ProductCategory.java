package com.example.ecosmetics.Model;

public class ProductCategory {

    private int image;
    private String category;

    public ProductCategory(int image, String category) {
        this.image = image;
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
