package com.diffey.view.mvpdemo.themvp;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.diffey.view.mvpdemo.R;
import com.diffey.view.mvpdemo.SuccessActivity;
import com.kymjs.frame.presenter.ActivityPresenter;

public class TheMVPLoginActivity extends ActivityPresenter<LoginViewDelegate> {

    @Override
    protected Class<LoginViewDelegate> getDelegateClass() {
        return LoginViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials();
            }
        }, R.id.button);
    }

    private void validateCredentials() {
        final String uName = viewDelegate.getUname();
        final String uPassword = viewDelegate.getUpassword();

        if (!isValidity(uName, uPassword)) {
            viewDelegate.hideProgress();
            return;
        }
        viewDelegate.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewDelegate.hideProgress();
                if (uName.equals("111") && uPassword.equals("111")) {
                    startActivity(new Intent(TheMVPLoginActivity.this, SuccessActivity.class));
                } else {
                    Toast.makeText(TheMVPLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    private boolean isValidity(String uName, String uPassword) {
        boolean isValide = true;
        if (TextUtils.isEmpty(uName)) {
            viewDelegate.setUnameError("用户名不能为空！");
            isValide = false;
        }

        if (TextUtils.isEmpty(uPassword)) {
            viewDelegate.setUpasswordError("密码不能为空！");
            isValide = false;
        }
        return isValide;
    }
}
