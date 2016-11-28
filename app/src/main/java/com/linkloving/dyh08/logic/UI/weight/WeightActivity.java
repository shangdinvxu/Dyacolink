package com.linkloving.dyh08.logic.UI.weight;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.AppManager;
import com.linkloving.dyh08.logic.UI.height.HeightActivity;
import com.linkloving.dyh08.logic.UI.launch.view.ScaleRulerView;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/8/1.
 */
public class WeightActivity extends AutoLayoutActivity {
    @InjectView(R.id.scaleWheelView_weight)
    ScaleRulerView weightRulerView;
    @InjectView(R.id.et_userWeight)
    AppCompatTextView weight;
    @InjectView(R.id.back)
    ImageView back;
    private UserEntity userEntity;

    private float mHeight = 60;
    private float mMaxHeight = 200;
    private float mMinHeight = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_activity_weight);
        AppManager.getAppManager().addActivity(this);
        ButterKnife.inject(this);
        userEntity = MyApplication.getInstance(WeightActivity.this).getLocalUserInfoProvider();
        weightRulerView.initViewParam(mHeight,mMaxHeight,mMinHeight);

        weightRulerView.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                weight.setText((int)value+"");
            }
        });

    }

    @OnClick(R.id.back)
    void back(View view){
        String weight = this.weight.getText().toString();
        int  weightInt = Integer.parseInt(weight);
        userEntity.getUserBase().setUser_weight(weightInt);
        WeightActivity.this.finish();
    }
}
