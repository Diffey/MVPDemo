package com.diffey.view.mvpdemo.themvp;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.diffey.view.mvpdemo.R;
import com.kymjs.frame.view.AppDelegate;

/**
 * Created by diff on 2016/1/29.
 */
public class LoginViewDelegate extends AppDelegate {
    EditText nEdit;
    EditText pEdit;
    ProgressBar progressBar;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_the_mvp;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        nEdit = get(R.id.username);
        pEdit = get(R.id.password);
        progressBar = get(R.id.progress);
    }

    public String getUname() {
        return nEdit.getText().toString();
    }

    public String getUpassword() {
        return pEdit.getText().toString();
    }

    public void setUnameError(String str) {
        nEdit.setError(str);
    }

    public void setUpasswordError(String str) {
        pEdit.setError(str);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
