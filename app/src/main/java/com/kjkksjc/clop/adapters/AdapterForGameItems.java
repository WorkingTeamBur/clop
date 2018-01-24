package com.kjkksjc.clop.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.kjkksjc.clop.R;

import java.util.ArrayList;

public class AdapterForGameItems extends AbstractWheelAdapter {
    int MaxNum;
    LayoutInflater lInflater;
    ArrayList<Integer> list;
    Context mContext;

    @SuppressLint("WrongConstant")
    public AdapterForGameItems(Context mContext, ArrayList<Integer> list) {
        this.mContext = mContext;
        this.list = list;
        this.lInflater = (LayoutInflater) mContext.getSystemService("layout_inflater");
        this.MaxNum = list.size();
    }

    public int getItemsCount() {
        return this.MaxNum;
    }

    public View getItem(int index, View convertView, ViewGroup parent) {
        View view = this.lInflater.inflate(R.layout.item_list, parent, false);
        ((ImageView) view.findViewById(R.id.image)).setImageDrawable(ContextCompat.getDrawable(this.mContext, ((Integer) this.list.get(index)).intValue()));
        return view;
    }
}
