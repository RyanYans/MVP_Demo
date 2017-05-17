package com.rya.mvp_demo.main.view.impl;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.rya.mvp_demo.R;
import com.rya.mvp_demo.main.MainContract;
import com.rya.mvp_demo.main.presenter.impl.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.img_main)
    ImageView imgMain;
    @BindView(R.id.btn_change)
    ImageButton btnChange;
    @BindView(R.id.btn_show)
    Button btnShow;
    @BindView(R.id.btn_hide)
    Button btnHide;

    private MainContract.Presenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initPresenter();

        initListener();
    }

    private void initPresenter() {
        mMainPresenter = new MainPresenter(this);
    }

    private void initListener() {
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPresenter.hidePic();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.showPic();
            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.changePic();
            }
        });
    }

    @Override
    public void showPic() {
        imgMain.setAlpha(1f);
    }

    @Override
    public void hidePic() {
        imgMain.setAlpha(0f);
    }

    @Override
    public void changePic(Bitmap bitmap) {
        imgMain.setImageBitmap(bitmap);
    }
}
