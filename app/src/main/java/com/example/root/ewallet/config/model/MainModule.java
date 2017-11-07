package com.example.root.ewallet.config.model;

import com.example.root.ewallet.app.login.LoginActivity;
import com.example.root.ewallet.app.main.DashboardFragment;
import com.example.root.ewallet.app.main.MainActivity;
import com.example.root.ewallet.app.paynow.PayNowFragment;
import com.example.root.ewallet.config.subcomponent.DashboardFragmentSubComponent;
import com.example.root.ewallet.config.subcomponent.LoginActivitySubComponent;
import com.example.root.ewallet.config.subcomponent.MainActivitySubComponent;
import com.example.root.ewallet.config.subcomponent.PayNowFragmentSubComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by root on 10/22/17.
 */

@Module(subcomponents = {
        LoginActivitySubComponent.class,
        PayNowFragmentSubComponent.class,
        MainActivitySubComponent.class,
        DashboardFragmentSubComponent.class
})
public abstract class MainModule {
    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
    @ContributesAndroidInjector
    abstract PayNowFragment contributePayNowFragment();
    @ContributesAndroidInjector
    abstract DashboardFragment contributedashboardFragment();
}
