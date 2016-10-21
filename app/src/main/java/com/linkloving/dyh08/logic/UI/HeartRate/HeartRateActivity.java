package com.linkloving.dyh08.logic.UI.HeartRate;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/15.
 */

public class HeartRateActivity extends ToolBarActivity implements View.OnClickListener{
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
    @InjectView(R.id.resting)
    TextView restingText;
    @InjectView(R.id.avgerage)
    TextView avgerageText;
    @InjectView(R.id.middle_framelayout)
    FrameLayout middleFramelayout;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_heartrate);
        ButterKnife.inject(this);
        HeartrateDay.setOnClickListener(this);
        HeartrateMonth.setOnClickListener(this);
        HeartrateWeek.setOnClickListener(this);
        initDay();
        HeartrateDay.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.d_on_72px, 0, 0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Heartrate_day:
                restartBotton();
                HeartrateDay.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.d_on_72px, 0, 0);
                initDay();
                break;
            case R.id.Heartrate_week:
                restartBotton();
                HeartrateWeek.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.w_on_72px, 0, 0);
                initWeek();
                break;
            case R.id.Heartrate_month:
                restartBotton();
                HeartrateMonth.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.m_on_72px, 0, 0);
                initMonth();
                break;
        }

    }

    private void initMonth() {
        MonthFragment monthFragment = new MonthFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.middle_framelayout, monthFragment);
        fragmentTransaction.commit();
        monthFragment.setRestingBpmListener(new RestingBpm() {
            @Override
            public void restAndAvg(int resting, int average, Date data) {
                restingText.setText(resting+"");
                avgerageText.setText(average+"");
                String format = simpleDateFormat.format(data);
                groupsTime.setText(format);
            }
        });

    }

    private void initWeek() {
        WeekFragment weekFragment = new WeekFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.middle_framelayout, weekFragment);
        fragmentTransaction.commit();
        weekFragment.setRestingBpmListener(new RestingBpm() {
            @Override
            public void restAndAvg(int resting, int average, Date data) {
                restingText.setText(resting+"");
                avgerageText.setText(average+"");
                String format = simpleDateFormat.format(data);
                groupsTime.setText(format);
            }
        });
    }

    private void initDay() {
        DayFragment dayFragment = new DayFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.middle_framelayout, dayFragment);
        fragmentTransaction.commit();
        dayFragment.setRestingBpmListener(new RestingBpm() {
            @Override
            public void restAndAvg(int resting, int average, Date data) {
                restingText.setText(resting+"");
                avgerageText.setText(average+"");
                String format = simpleDateFormat.format(data);
                groupsTime.setText(format);
            }
        });
    }


    /**
     * 切换Fragment时候 重置按钮图片
     */
    private void restartBotton() {
        HeartrateDay.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.d_off_72px, 0, 0);
        HeartrateWeek.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.w_off_72px, 0, 0);
        HeartrateMonth.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.m_off_72px, 0, 0);
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
