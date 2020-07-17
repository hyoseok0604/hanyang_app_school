package com.jhsapps.hanyang_app_school;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by 장효석 on 2020-07-17.
 */
public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;

    Button one, two, three, four, five, six, seven, eight, nine, zero, dot, plus, minus, multi, div, ans, clear, pm;

    double result = 0, after = 0, before = 0;

    boolean isPoint = false, isNew = true;

    int type = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        tv = (TextView) findViewById(R.id.large_text);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);

        dot = (Button) findViewById(R.id.dot);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);

        ans = (Button) findViewById(R.id.ans);

        clear = (Button) findViewById(R.id.clear);

        pm = (Button) findViewById(R.id.pm);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);

        dot.setOnClickListener(this);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multi.setOnClickListener(this);
        div.setOnClickListener(this);

        ans.setOnClickListener(this);

        clear.setOnClickListener(this);

        pm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 숫자 부분 처리
            case R.id.one:
                num("1");
                break;
            case R.id.two:
                num("2");
                break;
            case R.id.three:
                num("3");
                break;
            case R.id.four:
                num("4");
                break;
            case R.id.five:
                num("5");
                break;
            case R.id.six:
                num("6");
                break;
            case R.id.seven:
                num("7");
                break;
            case R.id.eight:
                num("8");
                break;
            case R.id.nine:
                num("9");
                break;
            case R.id.zero:
                num("0"); // TODO : 0으로 시작하는 경우와 관련된 예외 처리...
                break;

            case R.id.plus:
                operator(1);
                break;

            case R.id.minus:
                operator(2);
                break;

            case R.id.multi:
                operator(3);
                break;

            case R.id.div:
                operator(4);
                break;

            case R.id.ans:
                after = Double.parseDouble(tv.getText().toString());
                switch (type){
                    case 1:
                        result = before + after;
                        break;
                    case 2:
                        result = before - after;
                        break;
                    case 3:
                        result = before * after;
                        break;
                    case 4:
                        result = before / after;
                        break;
                    default:
                        result = after;
                }
                tv.setText(String.valueOf(result));
                type = 0;
                isPoint = false;
                isNew = true;
                break;

            case R.id.clear:
                tv.setText("");
                type = 0;
                isPoint = false;
                isNew = true;
                break;

            case R.id.dot:
                if(isPoint){
                    tv.setText(tv.getText().toString().replace(".", ""));
                    isPoint = false;
                }else{
                    tv.append(".");
                    isPoint = true;
                }
                break;

            case R.id.pm:
                if(tv.getText().toString().startsWith("-")) tv.setText(tv.getText().toString().substring(1));
                else tv.setText("-"+tv.getText().toString());
        }
    }

    private void num(String s){
        if (isNew){
            isPoint = false;
            tv.setText("");
            isNew = false;
        }
        tv.append(s);
    }

    private void operator(int t){
        before = Double.parseDouble(tv.getText().toString());
        isNew = true;
        type = t;
    }
}