package com.diffey.view.mvpdemo.androidmvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by diff on 2016/1/28.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validateCredentials(final String uName, final String uPassword) {
        if (!isValidity(uName, uPassword)) {
            loginView.hideProgress();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgress();
                if (uName.equals("111") && uPassword.equals("111")) {
                    loginView.loginSuccess();
                } else {
                    loginView.loginError();
                }
            }
        }, 3000);
    }

    private boolean isValidity(String uName, String uPassword) {
        boolean isValide = true;

        if (TextUtils.isEmpty(uName)) {
            loginView.setUsernameError();
            isValide = false;
        }

        if (TextUtils.isEmpty(uPassword)) {
            loginView.setPasswordError();
            isValide = false;
        }
        return isValide;
    }

    @Override
    public void onDestroy() {
        this.loginView = null;
    }
}
