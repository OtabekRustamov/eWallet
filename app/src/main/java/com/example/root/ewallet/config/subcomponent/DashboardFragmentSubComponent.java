package com.example.root.ewallet.config.subcomponent;

import com.example.root.ewallet.app.main.DashboardFragment;
import com.example.root.ewallet.app.paynow.PayNowFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by root on 10/22/17.
 */

@Subcomponent
public interface DashboardFragmentSubComponent extends AndroidInjector<DashboardFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DashboardFragment> {}
}

