package com.linkloving.dyh08.logic.UI.map;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.logic.UI.Groups.baidu.GroupsShareActivity;
import com.linkloving.dyh08.utils.ToolKits;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.twitter.Twitter;

/**
 * Created by Daniel.Xu on 2016/9/21.
 */

public class MapActivity extends ToolBarActivity {
    @InjectView(R.id.groups_time)
    TextView groupsTime;
    @InjectView(R.id.groups_tv_Step)
    AppCompatTextView groupsTvStep;
    @InjectView(R.id.Rl_step)
    RelativeLayout RlStep;
    @InjectView(R.id.groups_tv_Calories)
    AppCompatTextView groupsTvCalories;
    @InjectView(R.id.Rl_calories)
    RelativeLayout RlCalories;
    @InjectView(R.id.groups_tv_Distance)
    AppCompatTextView groupsTvDistance;
    @InjectView(R.id.Rl_distance)
    RelativeLayout RlDistance;
    @InjectView(R.id.main_tv_Duration)
    AppCompatTextView mainTvDuration;
    @InjectView(R.id.Rl_sleep)
    RelativeLayout RlSleep;
    @InjectView(R.id.sharebutton)
    Button sharebutton;
    @InjectView(R.id.shareEditText)
    EditText shareEditText;
    @InjectView(R.id.screenhot)
    LinearLayout screenhot;
    private View view;
    private String filePathCache = "/sdcard/ranking_v0.png";
    private ImageView fb;
    private ImageView twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_share_day);
        view = LayoutInflater.from(MapActivity.this).inflate(R.layout.tw_share_day, null);
        ButterKnife.inject(this);
        ShareSDK.initSDK(MapActivity.this);
        initPopupWindow();
//        加载每日数据
        init();
    }

    private void initPopupWindow() {
        final View popupView = LayoutInflater.from(MapActivity.this).inflate(R.layout.tw_share_popuwindow, null);
        final PopupWindow popupWindow = new PopupWindow(popupView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(popupView);
        fb = (ImageView) popupView.findViewById(R.id.fb);
        twitter = (ImageView) popupView.findViewById(R.id.twitter);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffffffff));
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 20);
//                ToolKits.getScreenHot(MapActivity.this.getWindow().getDecorView(), filePathCache);
                ToolKits.getScreenHot(screenhot, filePathCache);
            }
        });
        share();

    }

    private void share() {
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facebook.ShareParams shareParams = new Facebook.ShareParams();
                String shareWord = shareEditText.getText().toString();
                shareParams.setText(shareWord);
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform facebook = ShareSDK.getPlatform(Facebook.NAME);
                facebook.share(shareParams);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Twitter.ShareParams shareParams = new Twitter.ShareParams();
                String shareWord = shareEditText.getText().toString();
                shareParams.setText(shareWord);
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(Twitter.NAME);
                platform.share(shareParams);
            }
        });
    }

    private void init() {
        String middleTime = getMiddleTime();
        groupsTime.setText(middleTime);
//       当天步数


    }


    private String getMiddleTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a.HH:MM", Locale.US);
        String middleTime = simpleDateFormat.format(date);
        return middleTime;
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
