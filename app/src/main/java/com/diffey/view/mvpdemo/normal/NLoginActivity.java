package com.diffey.view.mvpdemo.normal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diffey.view.mvpdemo.R;
import com.diffey.view.mvpdemo.SuccessActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NLoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nlogin);
        ButterKnife.bind(this);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                validateCredentials();
                break;
            default:
                break;
        }
    }

    private void validateCredentials() {
        final String uName = username.getText().toString();
        final String uPassword = password.getText().toString();

        if (!isValidity(uName, uPassword)) {
            progress.setVisibility(View.INVISIBLE);
            return;
        }
        progress.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.INVISIBLE);
                if (uName.equals("111") && uPassword.equals("111")) {
                    startActivity(new Intent(NLoginActivity.this, SuccessActivity.class));
                } else {
                    Toast.makeText(NLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    private boolean isValidity(String uName, String uPassword) {
        boolean isValide = true;
        if (TextUtils.isEmpty(uName)) {
            username.setError("用户名不能为空！");
            isValide = false;
        }

        if (TextUtils.isEmpty(uPassword)) {
            password.setError("密码不能为空！");
            isValide = false;
        }
        return isValide;
    }
}
