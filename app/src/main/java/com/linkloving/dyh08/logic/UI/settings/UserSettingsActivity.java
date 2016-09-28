package com.linkloving.dyh08.logic.UI.settings;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;

import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.logic.UI.login.BirthdayActivity;
import com.linkloving.dyh08.logic.dto.UserBase;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.logic.utils.CircleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zkx on 2016/7/26.
 */
public class UserSettingsActivity extends ToolBarActivity {

    @InjectView(R.id.user_head)
    CircleImageView userHead;
    @InjectView(R.id.edit_nickname)
    AppCompatEditText editNickname;
    @InjectView(R.id.radio_man)
    AppCompatRadioButton radioMan;
    @InjectView(R.id.radio_woman)
    AppCompatRadioButton radioWoman;
    @InjectView(R.id.edit_year)
    AppCompatEditText editYear;
    @InjectView(R.id.edit_mon)
    AppCompatEditText editMon;
    @InjectView(R.id.edit_day)
    AppCompatEditText editDay;
    @InjectView(R.id.radio_left)
    AppCompatRadioButton radioLeft;
    @InjectView(R.id.radio_right)
    AppCompatRadioButton radioRight;
    @InjectView(R.id.radio_rem_on)
    AppCompatRadioButton radioRemOn;
    @InjectView(R.id.radio_rem_off)
    AppCompatRadioButton radioRemOff;
    @InjectView(R.id.btn_enter)
    AppCompatButton btnEnter;
    private UserEntity userEntity;
    private UserBase userBase;
    private int wearingStyle = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting);
        ButterKnife.inject(this);
        userEntity = MyApplication.getInstance(UserSettingsActivity.this).getLocalUserInfoProvider();
        userBase = userEntity.getUserBase();
    }

    @OnClick(R.id.radio_left)
    void setRadioLeft(View view){
        wearingStyle = 0 ;
    }
    @OnClick(R.id.radio_right)
    void  setRadioRight(View view){
        wearingStyle = 1 ;
    }

    @OnClick(R.id.btn_enter)
     void enter(View view){
        String name = editNickname.getText().toString().trim();
        userBase.setNickname(name);
        String day = editDay.getText().toString().trim();
        String month = editMon.getText().toString().trim();
        String year = editYear.getText().toString().trim();
        String birthday = day+month+year ;
        userBase.setBirthdate(birthday);
        userBase.setUser_wearingStyle(wearingStyle);


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
