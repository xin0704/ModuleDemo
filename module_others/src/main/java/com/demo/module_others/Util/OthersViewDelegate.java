package com.demo.module_others.Util;

import android.support.annotation.Keep;
import android.view.View;

import com.demo.library.Base.IBaseFragment;
import com.demo.library.Util.IViewDelegate;
import com.demo.module_others.Fragment.OthersFragment;

/**
 * Created by admin on 2018/3/29.
 */
@Keep
public class OthersViewDelegate implements IViewDelegate {
    @Override
    public IBaseFragment getFragment(String name) {
        return OthersFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
