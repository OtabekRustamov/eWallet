package com.example.root.ewallet.app.paynow.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 11/1/17.
 */

public class ModelPost implements Serializable {
    @SerializedName("FromCustomer")
    String FromCustomer;
    @SerializedName("ToCustomer")
    String ToCustomer;
    @SerializedName("Amount")
    Integer Amount;
    @SerializedName("CurrencyCode")
    String CurrencyCode;
    @SerializedName("Memo")
    String  Memo;
    @SerializedName("InstantPay")
    String InstantPay;
    public String getFromCustomer() {
        return FromCustomer;
    }

    public void setFromCustomer(String fromCustomer) {
        FromCustomer = fromCustomer;
    }

    public String getToCustomer() {
        return ToCustomer;
    }

    public void setToCustomer(String toCustomer) {
        ToCustomer = toCustomer;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public String getInstantPay() {
        return InstantPay;
    }

    public void setInstantPay(String instantPay) {
        InstantPay = instantPay;
    }


}
