package com.example.root.ewallet.app.paynow.presenter.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.ewallet.R;
import com.example.root.ewallet.app.paynow.model.adapter.ItemDataSnipperCurrency;

import java.util.ArrayList;

/**
 * Created by root on 10/24/17.
 */

public class SpinnerAdapterCurrency extends ArrayAdapter<ItemDataSnipperCurrency> {
    int groupid;
    Activity context;
    ArrayList<ItemDataSnipperCurrency> list;
    LayoutInflater inflater;
    public SpinnerAdapterCurrency(Context context, int groupid, int id, ArrayList<ItemDataSnipperCurrency>
            list){
        super(context,id,list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.imgcurren);
        imageView.setImageResource(list.get(position).getImageId());
        TextView textView=(TextView)itemView.findViewById(R.id.txtcurren);
        textView.setText(list.get(position).getText());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent){
        return getView(position,convertView,parent);

    }
}
