package com.demo.library.Util;


import android.support.annotation.Keep;
import android.view.View;

import com.demo.library.Base.IBaseFragment;

/**
 * <p>类说明</p>
 *
 * @name IFragmentDelegate
 */
@Keep
public interface IViewDelegate {

    IBaseFragment getFragment(String name);

    View getView(String name);

}
