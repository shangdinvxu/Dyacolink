package com.linkloving.dyh08.logic.UI.login;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.linkloving.dyh08.R;

import butterknife.ButterKnife;

/**
 * Created by Daniel.Xu on 2016/9/5.
 */
public class LoginFinishActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_finishlogin);
        ButterKnife.inject(this);
        init();
    }

    private void init() {

    }
}
