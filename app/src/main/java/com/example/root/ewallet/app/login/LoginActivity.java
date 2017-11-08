package com.example.root.ewallet.app.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.Window;
import android.view.WindowManager;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.login.presenter.LoginPresenter;
import com.example.root.ewallet.app.login.presenter.LoginPresenterIml;
import com.example.root.ewallet.app.main.MainActivity;
import com.example.root.ewallet.common.LoadingDilalog;
import com.example.root.ewallet.core.BaseActivity;
import com.example.root.ewallet.util.Constants;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by root on 10/22/17.
 */

public class LoginActivity extends BaseActivity implements LoginPresenter {
    @Inject
    LoginPresenterIml presenterIml;
    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.etLogin)
    TextInputEditText etLogin;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    private LoadingDilalog loadingDilalog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        loadingDilalog = new LoadingDilalog(this);
    }
//
//    public void hasToken() {
//        if (!(sharedPreferences.getString(Constants.X_User_Token, "")).isEmpty()) {
//            startMain();
//            return;
//        } else {
//            clickLogin();
//        }
//    }

    public void show() {
        loadingDilalog.show();
    }

    public void dismiss() {
        loadingDilalog.dismiss();
    }

    @OnClick(R.id.singin)
    public void clickLogin() {
        if (etLogin.getText().toString().isEmpty()) {
            return;
        } else if (etPassword.getText().toString().isEmpty()) {
            return;
        } else {
            makeMessage(etLogin, null);
            makeMessage(etPassword, null);
            fillLogin(etLogin.getText().toString(), etPassword.getText().toString());
        }
    }

    @Override
    public void fillLogin(String login, String password) {
        presenterIml.fillLogin(login, password);

    }

    public void startMain() {
        MainActivity.start(this);
    }
}
