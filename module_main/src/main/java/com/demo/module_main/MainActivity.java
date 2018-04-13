package com.demo.module_main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.demo.library.Base.IBaseActivity;
import com.demo.library.Base.IBaseFragment;
import com.demo.library.Util.ClassUtils;
import com.demo.library.Util.GlideImageLoader;
import com.demo.library.Util.IViewDelegate;
import com.demo.library.Base.ViewManager;
import com.demo.library.view.NoScrollViewPager;
import com.gyf.barlibrary.ImmersionBar;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends IBaseActivity {


    private NoScrollViewPager mPager;

    private List<IBaseFragment> mFragments = new ArrayList<>();

    private FragmentAdapter mAdapter;

    private BottomNavigationView bottomNavigationView;

    private Toolbar toolbar;

    private NavigationView navigationView;

    private DrawerLayout drawerLayout;

    private Banner banner;

    private CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();

        initBanner();

        initCollapsingToolbarLayout();

        initDrawer();

        initBottomNav();

        initViewPager();

    }

    private void initToolBar() {

        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("news");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });
    }

    private void initCollapsingToolbarLayout(){
        collapsingToolbarLayout = findViewById(R.id.collapsing_tool_bar_layout);
        collapsingToolbarLayout.setTitleEnabled(false);
    }

    private void initBanner() {

        banner = findViewById(R.id.header_banner);

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.img1);
        images.add(R.mipmap.img2);
        images.add(R.mipmap.img3);
        images.add(R.mipmap.img4);

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void initBottomNav() {

        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i = item.getItemId();

                if (i == R.id.navigation_home) {
                    mPager.setCurrentItem(0);
                    getSupportActionBar().setTitle("news");
                    return true;
                } else if (i == R.id.navigation_dashboard) {
                    mPager.setCurrentItem(1);
                    getSupportActionBar().setTitle("girls");
                    return true;
                } else if (i == R.id.navigation_notifications) {
                    mPager.setCurrentItem(2);
                    getSupportActionBar().setTitle("others");
                    return true;
                }

                return false;
            }
        });
    }

    private void initDrawer() {

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.left_nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(mContext, item.getTitle(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);

                return true;
            }
        });


    }


    private void initViewPager() {

        mFragments = ViewManager.getInstance().getAllFragment();

//        IBaseFragment newsFragment = getNewsFragment();
//        mFragments.add(newsFragment);
//
//        IBaseFragment girlsFragment = getGirlsFragment();
//        mFragments.add(girlsFragment);
//
//        IBaseFragment othersFragment = getOthersFragment();
//        mFragments.add(othersFragment);

        mPager = findViewById(R.id.container_pager);
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(true);
        mPager.setAdapter(mAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private IBaseFragment getNewsFragment() {

        IBaseFragment iBaseFragment = null;

        List<IViewDelegate> delegateList = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.demo.module_news");
        if (delegateList != null && !delegateList.isEmpty()) {
            iBaseFragment = delegateList.get(0).getFragment("");
        }

        return iBaseFragment;
    }

    private IBaseFragment getGirlsFragment() {

        IBaseFragment iBaseFragment = null;

        List<IViewDelegate> delegateList = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.demo.module_girls");
        if (delegateList != null && !delegateList.isEmpty()) {
            iBaseFragment = delegateList.get(0).getFragment("");
        }

        return iBaseFragment;
    }

    private IBaseFragment getOthersFragment() {

        IBaseFragment iBaseFragment = null;

        List<IViewDelegate> delegateList = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.demo.module_others");
        if (delegateList != null && !delegateList.isEmpty()) {
            iBaseFragment = delegateList.get(0).getFragment("");
        }

        return iBaseFragment;
    }
}
