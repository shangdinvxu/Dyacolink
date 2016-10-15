package com.linkloving.dyh08.logic.UI.HeartRate;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/15.
 */

public class HeartRateActivity extends ToolBarActivity {
    @InjectView(R.id.groups_time)
    TextView groupsTime;
    @InjectView(R.id.Heartrate_day)
    RadioButton HeartrateDay;
    @InjectView(R.id.Heartrate_week)
    RadioButton HeartrateWeek;
    @InjectView(R.id.Heartrate_month)
    RadioButton HeartrateMonth;
    @InjectView(R.id.tw_Heartrate_buttom)
    RadioGroup twHeartrateButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_heartrate);
        ButterKnife.inject(this);
        DayFragment dayFragment = new DayFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.middle_framelayout,dayFragment);
        fragmentTransaction.commit();

    }



    /**
     * 切换Fragment时候 重置按钮图片
     */
    private void restartBotton() {
        HeartrateDay.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.d_off_72px, 0, 0);
        HeartrateWeek.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.w_off_72px, 0, 0);
        HeartrateMonth.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.m_off_72px, 0, 0);
//        step_button_year_im.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.y_off_72px, 0, 0);
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
