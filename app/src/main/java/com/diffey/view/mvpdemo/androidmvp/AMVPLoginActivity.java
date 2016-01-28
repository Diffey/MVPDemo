package com.diffey.view.mvpdemo.androidmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diffey.view.mvpdemo.R;
import com.diffey.view.mvpdemo.SuccessActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AMVPLoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    LoginPresenter loginPresenter;
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
        setContentView(R.layout.activity_amvp);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        button.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                loginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        username.setError("用户名不能为空");
    }

    @Override
    public void setPasswordError() {
        password.setError("密码不能为空");
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, SuccessActivity.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
