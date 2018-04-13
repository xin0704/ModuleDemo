package com.demo.library.Base.adapter;

import android.view.ViewGroup;

/**
 * Created by admin on 2018/4/3.
 */

public interface Cell {

    public int getItemType();

    public void releaseResource();

    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    public void onBindViewHolder(IBaseViewHolder holder, int position);

}
