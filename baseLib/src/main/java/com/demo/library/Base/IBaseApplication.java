package com.demo.library.Base;

import android.app.Application;

import com.demo.library.Util.ClassUtils;
import com.demo.library.Util.IApplicationDelegate;
import com.demo.library.Util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/27.
 */

public class IBaseApplication extends Application {

    private static final String ROOT_PACKAGE = "com.demo.testmoduledemo";
    private static final String NEWS_PACKAGE = "com.demo.module_news";
    private static final String GIRLS_PACKAGE = "com.demo.module_girls";
    private static final String OTHERS_PACKAGE = "com.demo.module_others";

    private List<IApplicationDelegate> applicationDelegates = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);

        List<IApplicationDelegate> listNews = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, NEWS_PACKAGE);
        List<IApplicationDelegate> listGirls = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, GIRLS_PACKAGE);
        List<IApplicationDelegate> listOthers = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, OTHERS_PACKAGE);

        applicationDelegates.addAll(listOthers);
        applicationDelegates.addAll(listGirls);
        applicationDelegates.addAll(listNews);

        for (IApplicationDelegate delegate : applicationDelegates) {
            delegate.onCreate();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : applicationDelegates) {
            delegate.onTerminate();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : applicationDelegates) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : applicationDelegates) {
            delegate.onTrimMemory(level);
        }
    }
}
