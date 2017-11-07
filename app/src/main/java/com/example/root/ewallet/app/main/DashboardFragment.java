package com.example.root.ewallet.app.main;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.paynow.PayNowFragment;
import com.example.root.ewallet.core.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by root on 10/30/17.
 */

public class DashboardFragment extends BaseFragment {
    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.tvdashboard)
    TextView tvdashboard;
    @BindView(R.id.llpaynow)
    LinearLayout llpaynow;
    @BindView(R.id.llhistory)
    LinearLayout llhistory;
    @BindView(R.id.llbalance)
    LinearLayout llbalance;

    public static Fragment newInstance(String strings) {
        DashboardFragment fragment = new DashboardFragment();
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
        View rootView = inflater.inflate(R.layout.dashboard, container, false);
        ButterKnife.bind(this, rootView);
        // sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        init();
        return rootView;
    }

    private void init() {
        tvdashboard.setText(sharedPreferences.getString("lastime", ""));
        llpaynow.setClickable(true);
    }

    @OnClick(value = {R.id.llbalance, R.id.llhistory, R.id.llpaynow})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.llpaynow: {
                if (getActivity() instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.replaceFragment(new PayNowFragment());
                }
                break;
            }
        }
    }
}