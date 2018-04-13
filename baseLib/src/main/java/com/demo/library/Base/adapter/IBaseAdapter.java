package com.demo.library.Base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/3.
 */

public abstract class IBaseAdapter<C extends IBaseCell> extends RecyclerView.Adapter<IBaseViewHolder> {

    protected List<C> mData;

    public IBaseAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public IBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        for (int i = 0; i < getItemCount(); i++) {
            if (viewType == mData.get(i).getItemType()){
                return mData.get(i).onCreateViewHolder(parent,viewType);
            }
        }
        throw new RuntimeException("错误的 view type");
    }

    @Override
    public void onBindViewHolder(IBaseViewHolder holder, int position) {

        mData.get(position).onBindViewHolder(holder,position);

    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public void onViewDetachedFromWindow(IBaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        int position = holder.getAdapterPosition();

        if (position < 0 || position >= mData.size()){
            return;
        }

        mData.get(position).releaseResource();

    }

    public void setData(List<C> data) {
        addAll(data);
        notifyDataSetChanged();
    }

    public List<C> getData() {
        return mData;
    }

    public void add(C cell) {

        mData.add(cell);
        int index = mData.indexOf(cell);
        notifyItemChanged(index);

    }

    public void add(int index, C cell) {

        mData.add(index, cell);
        notifyItemChanged(index);

    }

    public void remove(C cell) {
        int index = mData.indexOf(cell);
        remove(index);
    }

    public void remove(int index) {
        mData.remove(index);
        notifyItemRemoved(index);
    }


    public void remove(int start,int count){

        if ((start + count) > mData.size()){
            return;
        }

        int size = getItemCount();

        for (int i = start; i < size; i++) {
            mData.remove(i);
        }

        notifyItemRangeRemoved(start,count);

    }


    public void addAll(List<C> cells) {

        if (cells == null || cells.size() == 0) {
            return;
        }
        mData.addAll(cells);
        notifyItemRangeChanged(mData.size() - cells.size(), mData.size());

    }

    public void addAll(int index, List<C> cells) {

        if (cells == null || cells.size() == 0) {
            return;
        }
        mData.addAll(index, cells);
        notifyItemRangeChanged(index, mData.size());

    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    /**
     * 如果子类需要在onBindViewHolder 回调的时候做的操作可以在这个方法里做 *
     *
     * @param holder * @param position
     */
    protected abstract void onViewHolderBound(IBaseViewHolder holder, int position);


}

