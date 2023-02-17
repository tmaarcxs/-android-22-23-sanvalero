package com.example.skill6.networking;

import com.google.gson.annotations.SerializedName;

public class ProductResult {
    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("Image")
    String productImage;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getProductImage() {
        return productImage;
    }
}
