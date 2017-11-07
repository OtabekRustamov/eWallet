package com.example.root.ewallet.app.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 10/20/17.
 */

public class LoginModel implements Serializable {
    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("Error")
    @Expose
    private Error error;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
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

    public class Data implements Serializable {
        @SerializedName("TokenData")
        @Expose
        private TokenData tokenData;
        @SerializedName("Role")
        @Expose
        private String Role;
        @SerializedName("LastLogInDate")
        @Expose
        private String LastLogInDate;
        @SerializedName("FullName")
        @Expose
        private String FullName;

        public TokenData getTokenData() {
            return tokenData;
        }

        public void setTokenData(TokenData tokenData) {
            this.tokenData = tokenData;
        }

        public String getRole() {
            return Role;
        }

        public void setRole(String role) {
            Role = role;
        }

        public String getLastLogInDate() {
            return LastLogInDate;
        }

        public void setLastLogInDate(String lastLogInDate) {
            LastLogInDate = lastLogInDate;
        }

        public String getFullName() {
            return FullName;
        }

        public void setFullName(String fullName) {
            FullName = fullName;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        @SerializedName("UserName")
        @Expose
        private String UserName;

        public class TokenData implements Serializable {
            @SerializedName("Token")
            @Expose
            private String Token;
            @SerializedName("ExpiredDate")
            @Expose
            private String ExpiredDate;


            public String getToken() {
                return Token;
            }

            public void setToken(String token) {
                Token = token;
            }

            public String getExpiredDate() {
                return ExpiredDate;
            }

            public void setExpiredDate(String expiredDate) {
                ExpiredDate = expiredDate;
            }


        }

    }
}
