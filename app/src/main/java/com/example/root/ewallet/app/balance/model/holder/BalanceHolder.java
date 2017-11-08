package com.example.root.ewallet.app.balance.model.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.ewallet.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by root on 11/8/17.
 */

public class BalanceHolder extends BaseViewHolder {
    @BindView(R.id.tvAccountNumberItem)
    TextView tvAccountNumberItem;
    @BindView(R.id.tvAmountItem)
    TextView tvAmountItem;
    @BindView(R.id.tvCcyItem)
    TextView tvCcyItem;
    @BindView(R.id.tvCurrencyItem)
    TextView tvCurrencyItem;
    @BindView(R.id.imvCurrencyItem)
    ImageView imvCurrencyItem;
    @BindView(R.id.tvCurBalanceItem)
    TextView tvCurBalanceItem;
    @BindView(R.id.tvCurBalanceAmountItem)
    TextView tvCurBalanceAmountItem;
    @BindView(R.id.tvAvialBalanceItem)
    TextView tvAvialBalanceItem;
    @BindView(R.id.tvAvialBalanceAmountItem)
    TextView tvAvialBalanceAmountItem;

    public BalanceHolder(View itemView) {
        super(itemView);
    }

    public BalanceHolder(ViewGroup parent, int res) {
        super(parent, res);
    }

    @Override
    public void setData(Object data) {
        super.setData(data);

    }
}
