package com.example.root.ewallet;

import android.app.Activity;
import android.app.Fragment;

import com.example.root.ewallet.config.component.AppComponent;
import com.example.root.ewallet.config.component.DaggerAppComponent;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by root on 10/22/17.
 */

public class WalletApplication extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
