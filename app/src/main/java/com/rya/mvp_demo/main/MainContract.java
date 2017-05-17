package com.rya.mvp_demo.main;

import android.graphics.Bitmap;

import com.rya.mvp_demo.base.IBasePresenter;
import com.rya.mvp_demo.base.IBaseView;

/**
 * Created by ryanyans32 on 2017/5/16.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

public interface MainContract {
    interface View extends IBaseView {
        void showPic();

        void hidePic();

        void changePic(Bitmap bitmap);
    }

    interface Presenter<V extends IBaseView> extends IBasePresenter<V> {
        void changePic();

        void showPic();

        void hidePic();
    }
}
