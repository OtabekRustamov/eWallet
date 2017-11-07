package com.example.root.ewallet.app.paynow.model.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 11/2/17.
 */

public class ToAlias implements Serializable {
    @SerializedName("FromAlisa")
    @Expose
    private String Inah;
    @SerializedName("AndyWCI")
    @Expose
    private String AndyWCI;
    @SerializedName("herve")
    @Expose
    private String herve;
    @SerializedName("Robert88")
    @Expose
    private String Robert88;
    @SerializedName("HERVE")
    @Expose
    private String HERVE;

    public String getInah() {
        return Inah;
    }

    public void setInah(String inah) {
        Inah = inah;
    }

    public String getAndyWCI() {
        return AndyWCI;
    }

    public void setAndyWCI(String andyWCI) {
        AndyWCI = andyWCI;
    }

    public String getHerve() {
        return herve;
    }

    public void setHerve(String herve) {
        this.herve = herve;
    }

    public String getRobert88() {
        return Robert88;
    }

    public void setRobert88(String robert88) {
        Robert88 = robert88;
    }

    public String getHERVE() {
        return HERVE;
    }

    public void setHERVE(String HERVE) {
        this.HERVE = HERVE;
    }


}
