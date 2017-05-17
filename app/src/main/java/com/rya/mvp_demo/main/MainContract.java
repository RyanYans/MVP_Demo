package com.rya.mvp_demo.main;

import android.graphics.Bitmap;

import com.rya.mvp_demo.base.BasePresenter;
import com.rya.mvp_demo.base.BaseView;

/**
 * Created by ryanyans32 on 2017/5/16.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

public interface MainContract {
    interface View extends BaseView {
        void showPic(Bitmap bitmap);

        void hidePic();
    }

    interface Presenter extends BasePresenter {
        void changePic();

        void shwoPic();

        void hidePic();
    }
}
