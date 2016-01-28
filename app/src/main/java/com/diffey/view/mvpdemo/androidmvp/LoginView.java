package com.diffey.view.mvpdemo.androidmvp;

/**
 * Created by diff on 2016/1/28.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void loginSuccess();

    void loginError();
}
