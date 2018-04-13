package com.demo.module_main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.demo.library.Base.IBaseFragment;


import java.util.List;

/**
 *
 * <p>Fragments适配器 </p>
 *
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<IBaseFragment> mFragments;

    public FragmentAdapter(FragmentManager fm, List<IBaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public int getItemPosition(Object object) {
        return android.support.v4.view.PagerAdapter.POSITION_NONE;
    }
}
