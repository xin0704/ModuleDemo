package com.demo.library.Base.adapter;

/**
 * Created by admin on 2018/4/3.
 */

public abstract class IBaseCell<T> implements Cell{

    public T mData;

    public IBaseCell(T t){
        mData = t;
    }

    @Override
    public void releaseResource() {
        // do nothing
        // 如果有需要回收的资源，子类自己实现
    }

}
