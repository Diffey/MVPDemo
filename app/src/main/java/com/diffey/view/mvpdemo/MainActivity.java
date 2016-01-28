package com.diffey.view.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diffey.view.mvpdemo.androidmvp.AMVPLoginActivity;
import com.diffey.view.mvpdemo.normal.NLoginActivity;
import com.diffey.view.mvpdemo.themvp.TheMVPLoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.main_btn_normal)
    Button mainBtnNormal;
    @Bind(R.id.main_btn_amvp)
    Button mainBtnAmvp;
    @Bind(R.id.main_btn_tmvp)
    Button mainBtnTmvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainBtnNormal.setOnClickListener(this);
        mainBtnAmvp.setOnClickListener(this);
        mainBtnTmvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.main_btn_normal:
                intent = new Intent(MainActivity.this, NLoginActivity.class);
                break;
            case R.id.main_btn_amvp:
                intent = new Intent(MainActivity.this, AMVPLoginActivity.class);
                break;
            case R.id.main_btn_tmvp:
                intent = new Intent(MainActivity.this, TheMVPLoginActivity.class);
                break;
            default:
                intent = new Intent(MainActivity.this, SuccessActivity.class);
                break;
        }
        startActivity(intent);
    }
}
