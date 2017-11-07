package com.example.root.ewallet.config.subcomponent;

import com.example.root.ewallet.app.login.LoginActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by root on 10/22/17.
 */

@Subcomponent
public interface LoginActivitySubComponent extends AndroidInjector<LoginActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LoginActivity> {}
}

