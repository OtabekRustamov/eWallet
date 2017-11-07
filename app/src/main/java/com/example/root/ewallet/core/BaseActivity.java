package com.example.root.ewallet.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.main.model.ItemDataSnipper;
import com.example.root.ewallet.app.main.presenter.adapters.SpinnerAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by root on 10/22/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected void makeMessage(TextInputEditText editText, String message) {
        editText.setError(message);
        editText.requestFocus();
    }
}
