package com.rya.mvp_demo.main.presenter.impl;

import android.graphics.Bitmap;

import com.rya.mvp_demo.base.IBaseView;
import com.rya.mvp_demo.main.MainContract;
import com.rya.mvp_demo.main.model.IMainModel;
import com.rya.mvp_demo.main.model.impl.MainModel;
import com.rya.mvp_demo.main.view.impl.MainActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2017/5/17.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

public class MainPresenter implements MainContract.Presenter<MainContract.View> {
    private WeakReference<MainContract.View> mMainViewRef;
    private IMainModel mMainModel;

    private String[] strs = new String[]{"http://ac-mhke0kuv.clouddn.com/8a2873772d249d3c2d01.png?imageView/2/w/800/h/600/q/80/format/png"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495635139&di=e8ccb9a5d1ea9ebb7687e4d8f5b5ee6a&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.mukewang.com%2F5848fe1f0001ed9f06000338.jpg"};
    private int current = 0;

    public MainPresenter(MainContract.View view) {
        attachView(view);
        mMainModel = new MainModel();
    }

    @Override
    public void changePic() {
        mMainModel.getPic(strs[current++ % 2], new MainModel.DataListener() {
            @Override
            public void onSuccessInfo(Bitmap bitmap) {
                getIView().changePic(bitmap);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void showPic() {
        getIView().showPic();
    }

    @Override
    public void hidePic() {
        getIView().hidePic();
    }

    @Override
    public void attachView(MainContract.View view) {
        mMainViewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mMainViewRef != null) {
            mMainViewRef.clear();
            mMainViewRef = null;
        }
    }

    @Override
    public MainContract.View getIView() {
        if (mMainViewRef != null) {
            return mMainViewRef.get();
        }
        return null;
    }

}
