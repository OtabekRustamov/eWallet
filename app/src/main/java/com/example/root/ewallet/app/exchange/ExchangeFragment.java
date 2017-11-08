package com.example.root.ewallet.app.exchange;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.ewallet.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by root on 11/8/17.
 */

public class ExchangeFragment extends Fragment {
    @BindView(R.id.spFromExchange)
    Spinner spFromExchange;
    @BindView(R.id.spToExchange)
    Spinner spToExchange;
    @BindView(R.id.spAmountExchange)
    Spinner spAmountExchange;
    @BindView(R.id.etAmount)
    EditText etAmount;
    @BindView(R.id.btcontinue)
    Button btcontinue;
    @BindView(R.id.btcancel)
    Button btcancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exchange_fragment, container, false);
        return view;
    }

    public void spFromExchange(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        spFromExchange.setAdapter(arrayAdapter);
    }

    public void spToExchange(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        spToExchange.setAdapter(arrayAdapter);
    }

    public void spAmountExchange(List<String> list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        spAmountExchange.setAdapter(arrayAdapter);
    }
}
