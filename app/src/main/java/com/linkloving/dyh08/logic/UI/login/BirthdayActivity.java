package com.linkloving.dyh08.logic.UI.login;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.linkloving.dyh08.IntentFactory;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.logic.dto.UserBase;
import com.linkloving.dyh08.logic.dto.UserEntity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/9/5.
 */
public class BirthdayActivity extends Activity {

    @InjectView(R.id.yearET)
    EditText yearET;
    @InjectView(R.id.monthET)
    EditText monthET;
    @InjectView(R.id.dayET)
    EditText dayET;
    @InjectView(R.id.left)
    ImageView left;
    @InjectView(R.id.right)
    ImageView right;
    private UserEntity userEntity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_birthday);
        ButterKnife.inject(this);
        userEntity = MyApplication.getInstance(BirthdayActivity.this).getLocalUserInfoProvider();
        init();
    }

    private void init() {
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFactory.startGender(BirthdayActivity.this);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = yearET.getText().toString().trim();
                String month = monthET.getText().toString().trim();
                String day = dayET.getText().toString().trim();
                String birthday = year+"-"+month+"-"+day ;
                if (year.length()<=0||month.length()<=0||day.length()<=0){
                    Toast.makeText(BirthdayActivity.this, "请填写正确的生日", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    userEntity.getUserBase().setBirthdate(birthday);
                    IntentFactory.startWeight(BirthdayActivity.this);
                }

            }
        });
    }
}
