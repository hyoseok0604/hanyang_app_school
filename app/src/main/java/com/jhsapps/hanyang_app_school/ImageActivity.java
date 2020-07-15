package com.jhsapps.hanyang_app_school;

import android.graphics.drawable.Drawable;
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
public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ButterKnife.bind(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Drawable d1 = img1.getDrawable();
        Drawable d2 = img2.getDrawable();

        img1.setImageDrawable(d2);
        img2.setImageDrawable(d1);
    }
}
