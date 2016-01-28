package com.diffey.view.mvpdemo.androidmvp;

/**
 * Created by diff on 2016/1/28.
 */
public interface LoginPresenter {
    void validateCredentials(String uName, String uPassword);

    void onDestroy();
}
