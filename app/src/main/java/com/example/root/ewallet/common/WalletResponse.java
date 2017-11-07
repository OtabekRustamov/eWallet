package com.example.root.ewallet.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 11/3/17.
 */

public class WalletResponse<T> implements Serializable{
    @SerializedName("Data")
    private T data;
    @SerializedName("Success")
    private boolean success;
    @SerializedName("Error")
    private WalletError error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public WalletError getError() {
        return error;
    }

    public void setError(WalletError error) {
        this.error = error;
    }

   public class WalletError implements Serializable{
        @SerializedName("Code")
         int code;
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
