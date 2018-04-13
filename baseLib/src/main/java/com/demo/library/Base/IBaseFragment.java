package com.demo.library.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by admin on 2018/3/27.
 */

public abstract class IBaseFragment extends Fragment {

    protected IBaseActivity mActivity;

    protected View view;

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract int setContentView();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
        } else {
            view = inflater.inflate(setContentView(), null);

            initData();
            initView();
            initListener();
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (IBaseActivity) context;
    }


    /**
     * 获取宿主Activity
     *
     * @return BaseActivity
     */
    protected IBaseActivity getHoldingActivity() {
        return mActivity;
    }

    protected RecyclerView.LayoutManager initLayoutManger() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }


}
