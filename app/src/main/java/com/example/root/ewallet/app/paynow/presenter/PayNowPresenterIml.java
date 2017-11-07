package com.example.root.ewallet.app.paynow.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.root.ewallet.app.paynow.PayNowFragment;
import com.example.root.ewallet.app.paynow.model.CreatePay_Respose;
import com.example.root.ewallet.app.paynow.model.ModelGet;
import com.example.root.ewallet.app.paynow.model.ModelPost;
import com.example.root.ewallet.common.WalletResponse;
import com.example.root.ewallet.util.ApiManager;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by root on 10/30/17.
 */

public class PayNowPresenterIml implements PayNowPresenter {
    private PayNowFragment payNowFragment;
    private ApiManager apiManager;
    private Context context;


    @Inject
    public PayNowPresenterIml(PayNowFragment payNowFragment, ApiManager apiManager, Context context) {
        this.payNowFragment = payNowFragment;
        this.apiManager = apiManager;
        this.context = context;
    }

    @Override
    public void fillCreate(ModelPost post) {
        apiManager.createPay(post)
                .subscribe(new Observer<CreatePay_Respose>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CreatePay_Respose respose) {
                        if (respose.getError().getCode() == 200) {
                            Toast.makeText(context, respose.getError().getUserMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, respose.getError().getUserMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ooo", e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void fillPaynow() {
        payNowFragment.show();
        apiManager.payNowModel()
                .subscribe(new Observer<WalletResponse<ModelGet>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(WalletResponse<ModelGet> response) {
                        payNowFragment.dismiss();
                        if (response.isSuccess()) {
                    //        Toast.makeText(context, response.getError().getUserMessage().toString(), Toast.LENGTH_SHORT).show();
                            payNowFragment.setSpFrom(response.getData().getFromAlias());
                            payNowFragment.setEtTo(response.getData().getToAlias());
                            payNowFragment.setEtCurrency(response.getData().getCurList());
                        } else {
                            Toast.makeText(context, response.getError().getUserMessage().toString(), Toast.LENGTH_SHORT).show();
                            payNowFragment.dismiss();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        payNowFragment.dismiss();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
