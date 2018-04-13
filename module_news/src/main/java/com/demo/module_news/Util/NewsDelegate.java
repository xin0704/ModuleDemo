package com.demo.module_news.Util;

import android.support.annotation.Keep;

import com.demo.library.Base.ViewManager;
import com.demo.library.Util.IApplicationDelegate;
import com.demo.module_news.Fragment.NewsFragment;


/**
 * <p>类说明</p>
 * @name NewsDelegate
 */
@Keep
public class NewsDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(0, NewsFragment.newInstance());
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
