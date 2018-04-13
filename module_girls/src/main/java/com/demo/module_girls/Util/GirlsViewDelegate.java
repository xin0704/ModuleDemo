package com.demo.module_girls.Util;

import android.support.annotation.Keep;
import android.view.View;

import com.demo.library.Base.IBaseFragment;
import com.demo.library.Util.IViewDelegate;
import com.demo.module_girls.Fragment.GirlsFragment;

/**
 * <p>类说明</p>
 * @name GirlsViewDelegate
 */
@Keep
public class GirlsViewDelegate implements IViewDelegate {

    @Override
    public IBaseFragment getFragment(String name) {
        return GirlsFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
