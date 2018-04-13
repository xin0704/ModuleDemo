package com.demo.module_girls.Cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.library.Base.adapter.IBaseCell;
import com.demo.library.Base.adapter.IBaseViewHolder;
import com.demo.library.view.CustomImageView;
import com.demo.module_girls.R;

/**
 * Created by admin on 2018/4/4.
 */

public class GirlsCell extends IBaseCell<String> {

    public static final int IMAGE_TYPE = 1;

    public GirlsCell(String s) {
        super(s);
    }

    @Override
    public int getItemType() {
        return IMAGE_TYPE;
    }

    @Override
    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_girls,parent,false);

        IBaseViewHolder holder = new IBaseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(IBaseViewHolder holder, int position) {

        if (holder.getItemView().getContext() == null){
            holder.getImageView(R.id.item_girls_img).setImageResource(R.mipmap.ic_launcher);
        }else {
            Glide.with(holder.getItemView().getContext()).load(mData).into(holder.getImageView(R.id.item_girls_img));
        }
    }
}
