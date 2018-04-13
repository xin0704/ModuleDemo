package com.demo.module_news.Cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.demo.library.Base.adapter.IBaseCell;
import com.demo.library.Base.adapter.IBaseViewHolder;
import com.demo.module_news.R;
import com.demo.module_news.entity.News;

/**
 * Created by admin on 2018/4/3.
 */

public class NewsCell extends IBaseCell<News>{

    public static final int NEWS_TYPE = 0;

    public NewsCell(News news) {
        super(news);
    }

    @Override
    public int getItemType() {
        return NEWS_TYPE;
    }

    @Override
    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);

        IBaseViewHolder holder = new IBaseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(IBaseViewHolder holder, int position) {

        holder.setText(R.id.item_news_title, mData.getTitle() + "");

        holder.setText(R.id.item_news_author, mData.getAuthor_name() + "");

        holder.setText(R.id.item_news_date, mData.getDate() + "");

        if (holder.getItemView().getContext() == null){
            holder.getImageView(R.id.item_news_img).setImageResource(R.mipmap.img2);
        }else {
            Glide.with(holder.getItemView().getContext()).load(mData.getThumbnail_pic_s()).into(holder.getImageView(R.id.item_news_img));
        }

    }
}
