package com.linkloving.dyh08.logic.UI.height;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.AppManager;
import com.linkloving.dyh08.logic.UI.launch.view.ScaleRulerView;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HeightActivity extends AutoLayoutActivity {
    @InjectView(R.id.scaleWheelView_height)
    ScaleRulerView heightRulerView;
    @InjectView(R.id.et_userHeight)
    AppCompatTextView height;
    @InjectView(R.id.back)
    ImageView back;


    private float mHeight = 158;
    private float mMaxHeight = 220;
    private float mMinHeight = 100;

    @Override
    public void finish() {
        super.finish();
        AppManager.getAppManager().removeActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_activity_height);
        AppManager.getAppManager().addActivity(this);
        ButterKnife.inject(this);
        heightRulerView.initViewParam(mHeight,mMaxHeight,mMinHeight);
        heightRulerView.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                height.setText((int)value+"");
            }
        });

    }

    @OnClick(R.id.back)
    void back(View view){
        HeightActivity.this.finish();
    }



}
