package com.example.root.ewallet.app.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.login.presenter.LoginPresenterIml;
import com.example.root.ewallet.app.main.model.ItemDataSnipper;
import com.example.root.ewallet.app.main.presenter.adapters.SpinnerAdapter;
import com.example.root.ewallet.app.paynow.PayNowFragment;
import com.example.root.ewallet.core.BaseActivity;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbarmain)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @BindView(R.id.llinstanpay)
    LinearLayout llinstanpay;
    @BindView(R.id.llinstantpaysub)
    LinearLayout llinstantpaysub;
    @BindView(R.id.llaccounts)
    LinearLayout llaccounts;

    @BindView(R.id.llaccountsub)
    LinearLayout llaccountssub;
    @BindView(R.id.lladdfunds)
    LinearLayout lladdfunds;
    @BindView(R.id.lladdfundssub)
    LinearLayout lladdfundssub;
    @BindView(R.id.llexchange)
    LinearLayout llexchange;
    @BindView(R.id.lluserprofile)
    LinearLayout lluserprofile;
    @BindView(R.id.lluserprifilessub)
    LinearLayout lluserprifilessub;
    @BindView(R.id.llinvitation)
    LinearLayout llinvitation;
    @BindView(R.id.llcontactus)
    LinearLayout llcontactus;
    @BindView(R.id.tvpaynow)
    TextView tvpaynow;
    @BindView(R.id.tvhistory)
    TextView tvhistory;
    @BindView(R.id.tvcurrencies)
    TextView tvcurrencies;
    @BindView(R.id.tvbalance)
    TextView tvbalance;
    @BindView(R.id.tvstatements)
    TextView tvstatements;
    @BindView(R.id.depositinstruction)
    TextView depositinstruction;
    @BindView(R.id.tvdeposithistory)
    TextView tvdeposithistory;
    @BindView(R.id.tvuploadproof)
    TextView tvuploadproof;
    @BindView(R.id.tvviewprofile)
    TextView tvviewprofile;
    @BindView(R.id.tvchangepassword)
    TextView tvchangepassword;
    @BindView(R.id.resetpassword)
    TextView resetpassword;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.profile_name)
    TextView profile_name;
    @BindView(R.id.profile_lasttime)
    TextView profile_lasttime;


    private ActionBarDrawerToggle toggle;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        initSnipper();
        toggle = new ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        // open default dashboard fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new DashboardFragment())
                .addToBackStack(null)
                .commit();
    }

    @OnClick(value = {R.id.llinstanpay,R.id.llaccounts,R.id.lladdfunds,
            R.id.llexchange,R.id.lluserprofile,R.id.llinvitation,R.id.llcontactus})
    public void clickRootMenues(View v) {
        switch (v.getId()) {
            case R.id.llinstanpay: {
                llinstantpaysub.setVisibility(llinstantpaysub.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            }
            case R.id.llaccounts: {
                llaccountssub.setVisibility(llaccountssub.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            }
            case R.id.lladdfunds: {
                lladdfundssub.setVisibility(lladdfundssub.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            }
            case R.id.llexchange: {
                Toast.makeText(this, "llexchange", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.lluserprofile: {
                lluserprifilessub.setVisibility(lluserprifilessub.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            }
            case R.id.llinvitation: {
                Toast.makeText(this, "llinvitation", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.llcontactus: {
                Toast.makeText(this, "llcontactus", Toast.LENGTH_SHORT).show();
                break;
            }case R.id.llcurrency_setting: {
                Toast.makeText(this, "llcurrency_setting", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @OnClick(value = {R.id.tvpaynow,R.id.tvhistory,R.id.tvcurrencies,R.id.tvbalance,R.id.tvstatements,R.id.depositinstruction
     ,R.id.tvdeposithistory,R.id.tvuploadproof,R.id.tvviewprofile,R.id.tvchangepassword,R.id.resetpassword})
    public void clickSubMenues(View v) {
        switch (v.getId()) {
            case R.id.tvpaynow:
                if (getSupportFragmentManager().findFragmentById(R.id.container) instanceof PayNowFragment) {
                    drawer_layout.closeDrawer(Gravity.START);
                    return;
                }
                drawer_layout.closeDrawers();
                llinstantpaysub.setVisibility(View.GONE);
                replaceFragment(new PayNowFragment());
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void initSnipper() {
        ArrayList<ItemDataSnipper> list = new ArrayList<>();
        list.add(new ItemDataSnipper("France", R.drawable.icons8_france));
        list.add(new ItemDataSnipper("English", R.drawable.icons8_usa_48));
        list.add(new ItemDataSnipper("Philippines", R.drawable.icons8_philippines_48));
        list.add(new ItemDataSnipper("Russia", R.drawable.icons8_russian_federation_48));
        SpinnerAdapter adapter = new SpinnerAdapter(this,
                R.layout.item_snipper_main, R.id.txt, list);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.container) instanceof DashboardFragment)
            finish();
        super.onBackPressed();
    }

//    @SuppressLint("MissingPermission")
//    public void attemptLogin(){
//        final TelephonyManager tm = (TelephonyManager) getBaseContext().
//                getSystemService(this.TELEPHONY_SERVICE);
//
//        final String tmDevice, tmSerial, androidId;
//        tmDevice = "" + tm.getDeviceId();
//        tmSerial = "" + tm.getSimSerialNumber();
//        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(),
//                android.provider.Settings.Secure.ANDROID_ID);
//
//
//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(this.TELEPHONY_SERVICE);
//        telephonyManager.getDeviceId();
//        //Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
//        //myIntent.putExtra("key", deviceId); //Optional parameters
//       // LoginActivity.this.startActivity(myIntent);
//
//    }
}