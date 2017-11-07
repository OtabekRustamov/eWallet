package com.example.root.ewallet.app.paynow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/30/17.
 */

public class ModelGet implements Serializable {
    @SerializedName("ToAlias")
    private List<String> toAlias = new ArrayList<>();
    @SerializedName("CurrencyList")
    private List<String> curList=new ArrayList<>();
    @SerializedName("FromAlias")
    private List<String> fromAlias= new ArrayList<>();

    public List<String> getToAlias() {
        return toAlias;
    }

    public void setToAlias(List<String> toAlias) {
        this.toAlias = toAlias;
    }

    public List<String> getCurList() {
        return curList;
    }

    public void setCurList(List<String> curList) {
        this.curList = curList;
    }

    public List<String> getFromAlias() {
        return fromAlias;
    }

    public void setFromAlias(List<String> fromAlias) {
        this.fromAlias = fromAlias;
    }
}
