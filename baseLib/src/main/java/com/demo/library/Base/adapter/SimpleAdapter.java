package com.demo.library.Base.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;


/**
 * Created by admin on 2018/4/3.
 */

public class SimpleAdapter extends IBaseAdapter {

    private EmptyCell mEmptyCell;

    private ErrorCell mErrorCell;


    public SimpleAdapter() {
        mEmptyCell = new EmptyCell(null);
        mErrorCell = new ErrorCell(null);
    }

    @Override
    protected void onViewHolderBound(IBaseViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        //处理GridView 布局
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    return (viewType == ErrorCell.ERROR_TYPE || viewType == EmptyCell.EMPTY_TYPE) ? gridLayoutManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        // 处理StaggeredGridLayoutManager 显示这个Span
        int position = holder.getAdapterPosition();
        int viewType = getItemViewType(position);
        if (isStaggeredGridLayout(holder)) {
            if (viewType == ErrorCell.ERROR_TYPE || viewType == EmptyCell.EMPTY_TYPE) {
                StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                //设置显示整个span
                params.setFullSpan(true);
            }
        }
    }

    private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return true;
        }
        return false;
    }


    /**
     * 显示错误提示 * <p>当网络请求发生错误，需要在界面给出错误提示时，调用{@link #showError}</p> * @see #showErrorKeepCount(int)
     */
    public void showError() {
        clear();
        add(mErrorCell);
    }

    /**
     * 显示错误提示 * <p>当网络请求发生错误，需要在界面给出错误提示时，调用{@link #showErrorKeepCount(int)},并保留keepCount 条Item</p> * @param keepCount 保留Item数量
     */
    public void showErrorKeepCount(int keepCount) {
        if (keepCount < 0 || keepCount > mData.size()) {
            return;
        }
        remove(keepCount, mData.size() - keepCount);
        if (mData.contains(mErrorCell)) {
            mData.remove(mErrorCell);
        }
        add(mErrorCell);
    }

    /**
     * 隐藏错误提示
     */
    public void hideErorr() {
        if (mData.contains(mErrorCell)) {
            remove(mErrorCell);
        }
    }


    /**
     * * @param keepCount
     */
    public void showEmptyKeepCount(int keepCount) {
        if (keepCount < 0 || keepCount > mData.size()) {
            return;
        }
        remove(keepCount, mData.size() - keepCount);
        if (mData.contains(mEmptyCell)) {
            mData.remove(mEmptyCell);
        }
        add(mEmptyCell);
    }

    /**
     * 显示空view * <p>当页面没有数据的时候，调用{@link #showEmpty()}显示空View，给用户提示</p>
     */
    public void showEmpty() {
        clear();
        add(mEmptyCell);
    }

    /**
     * 隐藏空View
     */
    public void hideEmpty() {
        if (mData.contains(mEmptyCell)) {
            remove(mEmptyCell);
        }
    }
}


