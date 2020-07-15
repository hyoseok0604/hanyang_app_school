package com.jhsapps.hanyang_app_school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandlerActivity extends AppCompatActivity {

    Handler mHandler;

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        ButterKnife.bind(this);

         mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                tv.setText(msg.arg1+"");
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                while(n < 100){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = mHandler.obtainMessage();
                    msg.arg1 = n;
                    mHandler.sendMessage(msg);
                    n++;
                }
            }
        }).start();
    }
}