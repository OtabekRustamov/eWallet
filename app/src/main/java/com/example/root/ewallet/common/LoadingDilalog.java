package com.example.root.ewallet.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.paynow.PayNowFragment;

/**
 * Created by root on 11/2/17.
 */
public class LoadingDilalog extends Dialog {

    public LoadingDilalog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.loading_view);
        getWindow().setBackgroundDrawable
                (new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }

    public void setOnCancelListener(PayNowFragment payNowFragment) {
    }
}
