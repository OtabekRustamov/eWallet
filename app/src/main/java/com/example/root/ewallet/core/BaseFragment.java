package com.example.root.ewallet.core;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;

/**
 * Created by root on 10/26/17.
 */

public abstract class BaseFragment extends Fragment {
    protected void makeMessage(TextInputEditText editText, String message) {
        editText.setError(message);
        editText.requestFocus();
    }
}
