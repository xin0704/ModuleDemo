package com.demo.library.Base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.library.R;

/**
 * Created by admin on 2018/4/3.
 */

public class EmptyCell extends IBaseCell {

    public static final int EMPTY_TYPE = Integer.MAX_VALUE - 2;

    public EmptyCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return EMPTY_TYPE;
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_empty,parent,false);

        IBaseViewHolder holder = new IBaseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(IBaseViewHolder holder, int position) {

    }
}
