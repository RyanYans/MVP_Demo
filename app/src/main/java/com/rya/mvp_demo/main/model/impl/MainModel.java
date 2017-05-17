package com.rya.mvp_demo.main.model.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.rya.mvp_demo.main.model.IMainModel;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Yan on 2017/5/17.
 * <p>
 * Reach me : http://ryanyans.github.io
 * Email : ryanyans32@gmail.com
 */

public class MainModel implements IMainModel<MainModel.DataListener> {

    private DataListener mListener;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            if (mListener != null) {
                mListener.onSuccessInfo(bitmap);
            }

        }
    };

    @Override
    public void getPic(String url, DataListener listener) {
        mListener = listener;

        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();

                    InputStream inputStream = response.body().byteStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    Message msg = Message.obtain();
                    msg.obj = bitmap;
                    mHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public interface DataListener{
        void onSuccessInfo(Bitmap bitmap);

        void onError();
    }
}
