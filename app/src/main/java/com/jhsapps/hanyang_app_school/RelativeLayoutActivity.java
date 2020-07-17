package com.jhsapps.hanyang_app_school;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 장효석 on 2020-07-17.
 */
public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.layout)
    RelativeLayout parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        ButterKnife.bind(this);

        addClickListener();
    }

    private void addClickListener() {
        for(int i = 0 ; i < parent.getChildCount() ; i++){
            View v = parent.getChildAt(i);
            if(v instanceof Button){
                v.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, v.getTag().toString(), Toast.LENGTH_SHORT).show();
    }
}
