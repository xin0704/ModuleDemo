package com.demo.testmoduledemo;

import android.content.Context;
import android.support.annotation.NonNull;

import com.demo.library.Base.IBaseApplication;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by admin on 2018/3/27.
 */

public class MyApplication extends IBaseApplication {
    static {
        //设置刷新默认头布局
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                //设置是否静默加载
                layout.setEnableAutoLoadMore(false);
                //设置是否开启在加载时候禁止操作内容视图
                layout.setDisableContentWhenLoading(true);
                ClassicsHeader.REFRESH_HEADER_UPDATE = "上次更新：yyyy-MM-dd HH:mm:ss";
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate).setFinishDuration(500);
            }
        });

        //设置加载更多默认布局
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                //设置是否静默加载
                layout.setEnableAutoLoadMore(false);
                //设置是否开启在加载时候禁止操作内容视图
                layout.setDisableContentWhenLoading(true);
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate).setFinishDuration(500);
            }
        });
    }
}
