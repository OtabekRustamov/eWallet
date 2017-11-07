package com.example.root.ewallet.app.paynow;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.paynow.model.ModelPost;
import com.example.root.ewallet.app.paynow.presenter.PayNowPresenter;
import com.example.root.ewallet.app.paynow.presenter.PayNowPresenterIml;
import com.example.root.ewallet.common.LoadingDilalog;
import com.example.root.ewallet.core.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by root on 10/26/17.
 */

public class PayNowFragment extends BaseFragment implements PayNowPresenter {
    @Inject
    PayNowPresenterIml payNowPresenterIml;
    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.etTo)
    AutoCompleteTextView etTo;
    @BindView(R.id.etCurrency)
    AutoCompleteTextView etCurrency;
    @BindView(R.id.etamount)
    EditText etamount;
    @BindView(R.id.spFrom)
    Spinner spFrom;
    @BindView(R.id.etinvoice)
    EditText etinvoice;
    @BindView(R.id.etmemo)
    EditText etmemo;
//    @BindView(R.id.btnCreate)
//    Button btnCreate;
    @BindView(R.id.btpaynow)
    Button btpaynow;
    @BindView(R.id.btreset)
    Button btreset;
    private LoadingDilalog loadingDilalog;

    public static Fragment newInstancePayNow(String strings) {
        PayNowFragment fragment = new PayNowFragment();
        Bundle bundle = new Bundle();
        bundle.putString("paynow", strings);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paynow_fragment, container, false);
        ButterKnife.bind(this, view);
        initView();
        fillPaynow();
        etinvoice.setText("");
        return view;
    }

    private void initView() {
        loadingDilalog = new LoadingDilalog(getContext());
    }

    public void show() {
        loadingDilalog.show();
    }

    public void dismiss() {
        loadingDilalog.dismiss();
    }

    @OnClick(R.id.btpaynow)
    public void clickCreate() {
        if (etamount.getText().toString().isEmpty() || etTo.getText().toString().isEmpty() || etinvoice.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Please fill the forms", Toast.LENGTH_SHORT).show();
        } else {
            ModelPost modelPost = new ModelPost();
            modelPost.setToCustomer(etTo.getText().toString());
            modelPost.setFromCustomer(spFrom.getSelectedItem().toString());
            modelPost.setAmount(Integer.valueOf(etamount.getText().toString()));
            modelPost.setCurrencyCode(etCurrency.getText().toString());
            modelPost.setMemo(etmemo.getText().toString());
            modelPost.setInstantPay(etinvoice.getText().toString());
            fillCreate(modelPost);
            etTo.setText("");
            etamount.setText("");
            etinvoice.setText("");
            etmemo.setText("");
            etCurrency.setText("");
        }
    }

    @Override
    public void fillCreate(ModelPost post) {
        payNowPresenterIml.fillCreate(post);
    }

    @Override
    public void fillPaynow() {
        payNowPresenterIml.fillPaynow();
    }

    public void setSpFrom(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        spFrom.setAdapter(arrayAdapter);
    }

    public void setEtTo(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        etTo.setAdapter(arrayAdapter);
        etTo.setThreshold(1);
        etTo.setAdapter(arrayAdapter);
        etTo.setOnTouchListener((view, motionEvent) -> {
            etTo.showDropDown();
            etTo.requestFocus();
            return false;
        });
    }

    public void setEtCurrency(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        etCurrency.setAdapter(arrayAdapter);
        etCurrency.setThreshold(1);
        etCurrency.setAdapter(arrayAdapter);
        etCurrency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                etCurrency.showDropDown();
                etCurrency.requestFocus();
                return false;
            }
        });
    }

}