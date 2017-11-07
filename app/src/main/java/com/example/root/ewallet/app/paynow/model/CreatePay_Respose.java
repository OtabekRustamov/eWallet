package com.example.root.ewallet.app.paynow.model;

import com.example.root.ewallet.app.login.model.LoginModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 11/3/17.
 */

public class CreatePay_Respose implements Serializable {
    @SerializedName("Error")
    @Expose
    private Error error;
    @Expose
    private Boolean success;

    public Error getError() {
        return error;
    }

    public Boolean getSuccess() {
        return success;
    }


    public class Error implements Serializable {
        @SerializedName("Code")
        private Integer code;
        @SerializedName("UserMessage")
        private String userMessage;
        @SerializedName("DeveloperMessage")
        private String developerMessage;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }

        public void setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
        }
    }


}
