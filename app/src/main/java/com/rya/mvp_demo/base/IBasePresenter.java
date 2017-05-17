package com.rya.mvp_demo.base;

/**
 * Created by ryanyans32 on 2017/5/16.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

public interface IBasePresenter<V extends IBaseView> {
    /**
     * 绑定
     * @param view
     */
    void attachView(V view);
    /**
     * 防止内存的泄漏, 清除Presenter与Activity之间的绑定
     */
    void detachView();
    /**
     * @return 获取View
     */
    V getIView();
}
