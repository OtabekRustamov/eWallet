package com.example.root.ewallet.app.main.model;

/**
 * Created by root on 10/24/17.
 */

public class ItemDataSnipper {
    String text;
    Integer imageId;

    public ItemDataSnipper(String text, Integer imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public Integer getImageId() {
        return imageId;
    }
}
