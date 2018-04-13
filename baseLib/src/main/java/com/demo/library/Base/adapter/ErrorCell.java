package com.demo.library.Base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.library.R;

/**
 * Created by admin on 2018/4/3.
 */

public class ErrorCell extends IBaseCell {

    public static final int ERROR_TYPE = Integer.MAX_VALUE - 1;

    public ErrorCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return ERROR_TYPE;
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_error,parent,false);

        IBaseViewHolder holder = new IBaseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(IBaseViewHolder holder, int position) {

    }
}
