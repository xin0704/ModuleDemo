package com.demo.module_news.Util;

import android.support.annotation.Keep;
import android.view.View;

import com.demo.library.Base.IBaseFragment;
import com.demo.library.Util.IViewDelegate;
import com.demo.module_news.Fragment.NewsFragment;

/**
 * <p>类说明</p>
 * @name NewsViewDelegate
 */
@Keep
public class NewsViewDelegate implements IViewDelegate {

    @Override
    public IBaseFragment getFragment(String name) {
        return NewsFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
