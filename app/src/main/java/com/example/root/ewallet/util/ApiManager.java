package com.example.root.ewallet.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

import com.example.root.ewallet.app.login.model.LoginModel;
import com.example.root.ewallet.app.paynow.model.CreatePay_Respose;
import com.example.root.ewallet.app.paynow.model.ModelGet;
import com.example.root.ewallet.app.paynow.model.ModelPost;
import com.example.root.ewallet.common.WalletResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by root on 10/22/17.
 */

public class ApiManager {
    private Context context;
    private ApiService apiService;
    private SharedPreferences sharedPreferences;


    public ApiManager(Context context, Retrofit retrofit) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        apiService = retrofit.create(ApiService.class);
        this.context = context;
    }

    public void clearToken() {
        sharedPreferences.edit().remove(Constants.X_User_Token).apply();
    }

    public Observable<LoginModel> login(String login, String password) {
        return apiService.login(Constants.CONTENT_TYPE,
                "FA6EC979-2B16-4103-BE65-FF986E4C9425",
                login, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<WalletResponse<ModelGet>> payNowModel() {
        return apiService.fillpay(sharedPreferences.getString(Constants.X_User_Token, ""),
                "FA6EC979-2B16-4103-BE65-FF986E4C9425")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Observable<CreatePay_Respose> createPay(ModelPost post){
        return apiService.createpay(sharedPreferences.getString(Constants.X_User_Token, ""),
                "FA6EC979-2B16-4103-BE65-FF986E4C9425","application/json",
                post).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public boolean hasConnection() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return activeNetwork.isConnected();
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return activeNetwork.isConnected();
        }
        return false;
    }

}