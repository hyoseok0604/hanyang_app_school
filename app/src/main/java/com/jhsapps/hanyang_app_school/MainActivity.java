package com.jhsapps.hanyang_app_school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.table) TableLayout mainTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        connectOnClickListener();
    }

    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i);
            viewList.addAll(v.getTouchables());
        }
        return viewList;
    }

    private void connectOnClickListener () {
        List<View> btnList = getAllButtons(mainTableLayout);
        for (View btn:btnList) {
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.linear:
                intent = new Intent(this, LinearLayoutActivity.class);
                break;
            case R.id.relative:
                //intent = new Intent(this, RelativeActivity.class);
                break;
            case R.id.calc:
                //intent = new Intent(this, CalcActivity.class);
                break;
            case R.id.frame:
                intent = new Intent(this, FrameActivity.class);
                break;
            case R.id.image:
                intent = new Intent(this, ImageActivity.class);
                break;
            case R.id.countdown:
                intent = new Intent(this, ThreadCountDownActivity.class);
                break;
            case R.id.handler1:
                intent = new Intent(this, HandlerActivity.class);
                break;
        }

        if (intent != null) startActivity(intent);
    }
}