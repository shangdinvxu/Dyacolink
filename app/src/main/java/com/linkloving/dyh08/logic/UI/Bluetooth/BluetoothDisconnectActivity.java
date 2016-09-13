package com.linkloving.dyh08.logic.UI.Bluetooth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.linkloving.dyh08.IntentFactory;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Daniel.Xu on 2016/9/12.
 */
public class BluetoothDisconnectActivity extends ToolBarActivity {
    @InjectView(R.id.blue_middle_changeIV)
    ImageView blueMiddleChangeIV;
    @InjectView(R.id.cancel)
    Button cancel;
    @InjectView(R.id.confirm)
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_binding_bluetooth_activity2);
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

    @OnClick(R.id.cancel)
    void onCancel(View view) {
        IntentFactory.startPortalActivityIntent(BluetoothDisconnectActivity.this);
    }

    @OnClick(R.id.confirm)
    void onConfirm(View view) {
            IntentFactory.startBindActivity3(BluetoothDisconnectActivity.this);
    }

}
