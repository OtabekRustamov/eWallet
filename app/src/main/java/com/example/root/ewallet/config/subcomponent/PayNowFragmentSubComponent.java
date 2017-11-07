package com.example.root.ewallet.config.subcomponent;

import com.example.root.ewallet.app.paynow.PayNowFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by root on 10/22/17.
 */

@Subcomponent
public interface PayNowFragmentSubComponent extends AndroidInjector<PayNowFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<PayNowFragment> {}
}

