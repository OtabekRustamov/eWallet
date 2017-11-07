package com.example.root.ewallet.app.paynow.model.adapter;

/**
 * Created by root on 10/24/17.
 */

public class ItemDataSnipperCurrency {
    String text;
    Integer imageId;

    public ItemDataSnipperCurrency(String text, Integer imageId) {
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
