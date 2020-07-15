package com.jhsapps.hanyang_app_school;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 장효석 on 2020-07-12.
 */
public class FrameActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;

    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;

    boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);

                if (flag){
                    img2.setVisibility(View.VISIBLE);
                }else{
                    img1.setVisibility(View.VISIBLE);
                }
                flag = !flag;
            }
        });
    }
}
