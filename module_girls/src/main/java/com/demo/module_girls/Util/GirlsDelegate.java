package com.demo.module_girls.Util;

import android.support.annotation.Keep;

import com.demo.library.Base.ViewManager;
import com.demo.library.Util.IApplicationDelegate;
import com.demo.module_girls.Fragment.GirlsFragment;


/**
 * <p>类说明</p>
 * @name GirlsDelegate
 */
@Keep
public class GirlsDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(0, GirlsFragment.newInstance());
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
