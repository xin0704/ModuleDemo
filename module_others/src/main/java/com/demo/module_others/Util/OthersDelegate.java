package com.demo.module_others.Util;

import android.support.annotation.Keep;

import com.demo.library.Base.ViewManager;
import com.demo.library.Util.IApplicationDelegate;
import com.demo.module_others.Fragment.OthersFragment;

/**
 * Created by admin on 2018/3/29.
 */
@Keep
public class OthersDelegate implements IApplicationDelegate {
    @Override
    public void onCreate() {
        ViewManager.getInstance().addFragment(0, OthersFragment.newInstance());
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
