package com.rya.mvp_demo.main.model;

import android.graphics.Bitmap;

import com.rya.mvp_demo.base.IBaseModel;
import com.rya.mvp_demo.main.MainContract;
import com.rya.mvp_demo.main.model.impl.MainModel;

/**
 * Created by Yan on 2017/5/17.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

// // TODO: 2017/5/17 耦合
public interface IMainModel<T> extends IBaseModel {
    void getPic(String url, T listener);
}
