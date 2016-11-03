package com.linkloving.dyh08.logic.UI.settings;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;

import com.linkloving.dyh08.IntentFactory;
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
    private int wearingStyle = 0;
    private int remindtype = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting);
        ButterKnife.inject(this);
        userEntity = MyApplication.getInstance(UserSettingsActivity.this).getLocalUserInfoProvider();
        userBase = userEntity.getUserBase();
        editNickname.setText(userBase.getNickname());
        int user_sex = userBase.getUser_sex();
        if (user_sex == 1) {
            radioMan.setChecked(true);
        } else {
            radioWoman.setChecked(true);
        }
        if (userBase.getUser_wearingStyle() == 1) {
            radioLeft.setChecked(true);
        } else {
            radioRight.setChecked(true);
        }
        String birthdate = userBase.getBirthdate();
        if (birthdate.length() > 0) {
            String[] split = birthdate.split("-");
            editYear.setText(split[0]);
            editMon.setText(split[1]);
            editDay.setText(split[2]);
        }
        if (userBase.getRemind()==1){
            radioRemOn.setChecked(true);
        }else {
            radioRemOff.setChecked(true);
        }
    }

    @OnClick(R.id.radio_left)
    void setRadioLeft(View view) {
        wearingStyle = 0;
    }

    @OnClick(R.id.radio_right)
    void setRadioRight(View view) {
        wearingStyle = 1;
    }

    @OnClick(R.id.btn_enter)
    void enter(View view) {
        String name = editNickname.getText().toString().trim();
        userBase.setNickname(name);
        String day = editDay.getText().toString().trim();
        String month = editMon.getText().toString().trim();
        String year = editYear.getText().toString().trim();
        String birthday = year + "-" + month + "-" + day;
        userBase.setBirthdate(birthday);
        userBase.setUser_wearingStyle(wearingStyle);
        userBase.setRemind(remindtype);
        IntentFactory.startPortalActivityIntent(UserSettingsActivity.this);
    }

    @OnClick(R.id.radio_rem_off)
    void setRadioRemOff(View view) {
        remindtype = 2;
    }
    @OnClick(R.id.radio_rem_on)
    void setRadioRemOn(View view){
        remindtype = 1 ;
    }

    @Override
    protected void getIntentforActivity() {

    }

    @Override
    protected void initView() {

    }
    @OnClick(R.id.user_head)
    void setUserHead(View view){

    }

    @Override
    protected void initListeners() {

    }
}
