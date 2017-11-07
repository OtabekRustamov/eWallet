package com.example.root.ewallet.app.paynow.presenter;

import android.widget.Spinner;

import com.example.root.ewallet.app.paynow.model.ModelPost;

/**
 * Created by root on 10/29/17.
 */

public interface PayNowPresenter {
    void fillCreate(ModelPost post);

    void fillPaynow();
}
