package com.example.root.ewallet.config.component;

import com.example.root.ewallet.WalletApplication;
import com.example.root.ewallet.config.model.AppModule;
import com.example.root.ewallet.config.model.MainModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by root on 10/22/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, MainModule.class})

public interface AppComponent extends AndroidInjector<WalletApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(WalletApplication application);

        AppComponent build();
    }

    void inject(WalletApplication walletApplication);
}