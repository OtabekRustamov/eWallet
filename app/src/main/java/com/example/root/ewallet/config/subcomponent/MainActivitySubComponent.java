package com.example.root.ewallet.config.subcomponent;

import com.example.root.ewallet.app.login.LoginActivity;
import com.example.root.ewallet.app.main.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by root on 10/22/17.
 */

@Subcomponent
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}

