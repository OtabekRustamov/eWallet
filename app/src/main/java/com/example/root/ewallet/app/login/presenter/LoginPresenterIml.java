package com.example.root.ewallet.app.login.presenter;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.root.ewallet.app.login.LoginActivity;
import com.example.root.ewallet.app.login.model.LoginModel;
import com.example.root.ewallet.util.ApiManager;
import com.example.root.ewallet.util.Constants;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by root on 10/22/17.
 */

public class LoginPresenterIml implements LoginPresenter {


    private LoginActivity loginActivity;
    private ApiManager apiManager;
    private SharedPreferences sharedPreferences;


    @Inject
    public LoginPresenterIml(LoginActivity loginActivity, ApiManager apiManager, SharedPreferences sharedPreferences) {
        this.apiManager = apiManager;
        this.loginActivity = loginActivity;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void fillLogin(String login, String password) {
        loginActivity.show();
            apiManager.login(login, password)
                    .subscribe(new Observer<LoginModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(LoginModel result) {
                            if (result.isSuccess()) {
                                loginActivity.dismiss();
                                loginActivity.startMain();
                                sharedPreferences.edit().putString(Constants.X_User_Token, result.getData().getTokenData().getToken()).commit();
                                sharedPreferences.edit().putString("userName", result.getData().getUserName().toString()).commit();
                                sharedPreferences.edit().putString("FullName", result.getData().getFullName().toString()).commit();
                                sharedPreferences.edit().putString("lastime", result.getData().getLastLogInDate()).commit();

                                Log.d("sss", "Ok");
                            } else {
                                Toast.makeText(loginActivity, result.getError().getUserMessage(), Toast.LENGTH_SHORT).show();
                                loginActivity.dismiss();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("sss", e.getMessage().toString());
                            loginActivity.dismiss();
                        }

                        @Override
                        public void onComplete() {
                        }
                    });
        }
    }
