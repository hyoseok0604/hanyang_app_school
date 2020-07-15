package com.jhsapps.hanyang_app_school;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 장효석 on 2020-07-12.
 */
public class ThreadCountDownActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView tv;

    int n = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadcountdown);

        ButterKnife.bind(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(n > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n--;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(n + "");
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadCountDownActivity.this, "완료", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}
