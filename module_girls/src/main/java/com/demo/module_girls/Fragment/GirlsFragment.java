package com.demo.module_girls.Fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.demo.library.Base.IBaseFragment;
import com.demo.library.Base.adapter.IBaseCell;
import com.demo.library.Base.adapter.SimpleAdapter;
import com.demo.module_girls.R;
import com.demo.module_girls.Util.LoadGirlsData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/27.
 */

public class GirlsFragment extends IBaseFragment {

    private RecyclerView recycleView;

    private SmartRefreshLayout smartRefreshLayout;

    private SimpleAdapter mAdapter;

    private List<IBaseCell> cells = new ArrayList<>();

    public static GirlsFragment newInstance() {
        return new GirlsFragment();
    }

    public GirlsFragment() {
    }

    @Override
    protected void initData() {

        cells.addAll(LoadGirlsData.getData());

    }

    @Override
    protected void initView() {


        recycleView = view.findViewById(R.id.recycle_view);

        smartRefreshLayout = view.findViewById(R.id.smart_refresh_layout);
        //设置暂不允许加载更多
        smartRefreshLayout.setEnableLoadMore(false);

        mAdapter = new SimpleAdapter();
        //设置瀑布流
        recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycleView.setAdapter(mAdapter);
        mAdapter.addAll(cells);

    }

    @Override
    protected void initListener() {

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //下拉刷新
                handler.sendEmptyMessageDelayed(1, 3000);
            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //加载更多
                handler.sendEmptyMessageDelayed(2, 2000);
            }
        });

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_girls;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    smartRefreshLayout.finishRefresh();
                    break;
                case 2:
                    smartRefreshLayout.finishLoadMore();
                    break;
            }


        }
    };
}
