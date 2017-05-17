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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
    }

    private void initListener() {
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidePic();
            }
        });
    }

    @Override
    public void showPic(Bitmap bitmap) {
        imgMain.setImageBitmap(bitmap);
    }

    @Override
    public void hidePic() {
        imgMain.setAlpha(0);
    }
}
