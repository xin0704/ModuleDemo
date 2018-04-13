package com.demo.library.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by admin on 2018/3/27.
 */

public class IBaseActivity extends AppCompatActivity implements View.OnClickListener{

    public Activity mContext;

    public ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ViewManager.getInstance().addActivity(this);
        initImmersionBar();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewManager.getInstance().finishActivity(this);
        if (mImmersionBar != null){
            mImmersionBar.destroy();
        }
    }

    protected void initImmersionBar(){
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }

    public void addFragment(IBaseFragment fragment, int containerId) {

        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();

    }

    public void replaceFragment(IBaseFragment fragment, int containerId) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    public void hideFragment(IBaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .hide(fragment)
                .commitAllowingStateLoss();

    }

    public void showFragment(IBaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commitAllowingStateLoss();

    }

    public void removeFragment(IBaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss();

    }

    /**
     * 弹出栈顶的fragment
     */
    public void popFragment() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }

    }

    @Override
    public void onClick(View v) {

    }
}
