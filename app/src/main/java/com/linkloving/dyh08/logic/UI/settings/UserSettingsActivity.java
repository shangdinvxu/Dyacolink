package com.linkloving.dyh08.logic.UI.settings;

import android.os.Bundle;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;

import butterknife.ButterKnife;

/**
 * Created by zkx on 2016/7/26.
 */
public class UserSettingsActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting);
        ButterKnife.inject(this);
    }

    @Override
    protected void getIntentforActivity() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListeners() {

    }
}
