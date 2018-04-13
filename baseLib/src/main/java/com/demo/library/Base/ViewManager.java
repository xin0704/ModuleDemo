package com.demo.library.Base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by admin on 2018/3/27.
 */

public class ViewManager {

    private static Stack<Activity> activityStack;

    private static List<IBaseFragment> fragmentList;

    private static ViewManager viewManager;

    public static ViewManager getInstance() {

        if (viewManager == null) {
            synchronized (ViewManager.class) {
                if (viewManager == null) {
                    viewManager = new ViewManager();
                }
            }
        }
        return viewManager;
    }

    public void addActivity(Activity activity) {

        if (activityStack == null) {
            activityStack = new Stack<>();
        }

        activityStack.add(activity);

    }

    public void finishActivity(Activity activity) {

        if (activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishAllActivity() {

        if (activityStack != null) {
            for (int i = 0; i < activityStack.size(); i++) {

                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }

            }
            activityStack.clear();
        }
    }

    public void addFragment(int index, IBaseFragment fragment) {

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.add(index, fragment);

    }

    public IBaseFragment getFragment(int index) {
        if (fragmentList != null) {
            return fragmentList.get(index);
        }
        return null;
    }

    public List<IBaseFragment> getAllFragment() {
        if (fragmentList != null) {
            return fragmentList;
        }
        return null;
    }


}
