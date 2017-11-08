package com.example.root.ewallet.app.balance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.balance.model.holder.BalanceHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 10/26/17.
 */

public class BalanceFragment extends Fragment {
    private LinearLayoutManager layoutManager;
    private RecyclerArrayAdapter adapter;
    @BindView(R.id.ervBalance)
    EasyRecyclerView ervBalance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.balance_fragment, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {
        layoutManager = new LinearLayoutManager(getContext());
        ervBalance.setLayoutManager(layoutManager);
        ervBalance.setAdapter(adapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new BalanceHolder(parent, R.layout.item_balance);
            }

        });
    }
}
