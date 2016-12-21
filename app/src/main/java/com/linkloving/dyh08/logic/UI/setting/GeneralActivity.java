package com.linkloving.dyh08.logic.UI.setting;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.android.bluetoothlegatt.BLEProvider;
import com.linkloving.dyh08.BleService;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.prefrences.LocalUserSettingsToolkits;
import com.linkloving.dyh08.prefrences.PreferencesToolkits;
import com.linkloving.dyh08.prefrences.devicebean.DeviceSetting;
import com.linkloving.dyh08.utils.DeviceInfoHelper;
import com.linkloving.dyh08.utils.ToolKits;

import java.security.Provider;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/24.
 */

public class GeneralActivity extends ToolBarActivity {
    @InjectView(R.id.listview)
    ListView listview;
    private LayoutInflater layoutInflater;
    private View totalView;
    private BLEProvider provider;
    private UserEntity userEntity;
    private DeviceSetting deviceSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting_activity);
        ButterKnife.inject(this);
        String[] strings = {getString(R.string.Goalsetting),
                getString(R.string.Searchingwearable),
                getString(R.string.unitsetting),
                getString(R.string.Selectthe),
                getString(R.string.Communityweb),
                getString(R.string.AutomaticHR)
                ,getString(R.string.showhand)
        };
        provider = BleService.getInstance(GeneralActivity.this).getCurrentHandlerProvider();
        userEntity = MyApplication.getInstance(getApplicationContext()).getLocalUserInfoProvider();
        deviceSetting = LocalUserSettingsToolkits.getLocalSetting(GeneralActivity.this, userEntity.getUser_id() + "");
        layoutInflater = LayoutInflater.from(GeneralActivity.this);
        totalView = layoutInflater.inflate(R.layout.tw_setting_activity, null);
        Myadapter myadapter = new Myadapter(GeneralActivity.this, strings);
        listview.setAdapter(myadapter);
        View heardview = LayoutInflater.from(GeneralActivity.this).inflate(R.layout.tw_setting_heardview, null);
        TextView textHeartView = (TextView) heardview.findViewById(R.id.textHeartView);
        textHeartView.setText(R.string.General);
        listview.addHeaderView(heardview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**因为有头所以从1开始*/
                switch (position){
                    case 1:
                        initGoalSettingsPopupWindow();
                        break;
                    case 2:
                        initSearchingWearablePopupWindow();
                        break;
                    case 3:
                        initUnitsetting();
                        break;
                    case 4:
                        initSelecttheMap();
                        break;
                    case 5:
                        initCommunitywebsite();
                        break;
                    case 6:
                        initAutomaticHR();
                        break;
                    case 7:
                        initShowhand();
                        break;

                }
            }
        });
    }

    private void initShowhand() {
        View view = layoutInflater.inflate(R.layout.showhandpopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        byte showhand = deviceSetting.getShowhand();
        Switch showhandSwitch = (Switch) view.findViewById(R.id.showhand);
        if (showhand==(byte) 0x01){
            showhandSwitch.setChecked(true);
        }else {
            showhandSwitch.setChecked(false);
        }
        showhandSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                deviceSetting.setShowhand((byte) (isChecked?0x01:0x00));
                LocalUserSettingsToolkits.updateLocalSetting(GeneralActivity.this,deviceSetting);
                    provider.SetHandUp(GeneralActivity.this, DeviceInfoHelper.fromUserEntity(GeneralActivity.this,
                            userEntity));
            }
        });
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

    private void initAutomaticHR() {
        View view = layoutInflater.inflate(R.layout.automatichrpopupwindow, null);
        final Switch realtime = (Switch) view.findViewById(R.id.realtime);
        final Switch wearable = (Switch) view.findViewById(R.id.wearable);
        boolean handRingSet = PreferencesToolkits.getHandRingSet(GeneralActivity.this);
        boolean heartrateSync = PreferencesToolkits.getHeartrateSync(GeneralActivity.this);
        realtime.setChecked(heartrateSync);
        wearable.setChecked(handRingSet);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                PreferencesToolkits.setHandRingSet(GeneralActivity.this,wearable.isChecked());
                PreferencesToolkits.setHeartrateSync(GeneralActivity.this,realtime.isChecked());
            }
        });
    }

    private void initCommunitywebsite() {
        View view = layoutInflater.inflate(R.layout.communitywebpopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void initSelecttheMap() {
        View view = layoutInflater.inflate(R.layout.selectthemappopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void initUnitsetting() {
        View view = layoutInflater.inflate(R.layout.unitsettingpopupwindow, null);
        final Button metric = (Button) view.findViewById(R.id.metric);
        final Button britsh = (Button) view.findViewById(R.id.britsh);
        int localSettingUnitInfo = PreferencesToolkits.getLocalSettingUnitInfo(GeneralActivity.this);
        if (localSettingUnitInfo==ToolKits.UNIT_GONG){
            metric.setBackgroundColor(0xFFfbc400);
            britsh.setBackgroundColor(0xffF5F5F5);
        }else {
            britsh.setBackgroundColor(0xFFfbc400);
            metric.setBackgroundColor(0xffF5F5F5);
        }
        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesToolkits.setLocalSettingUnitInfo(GeneralActivity.this, ToolKits.UNIT_GONG);
                metric.setBackgroundColor(0xFFfbc400);
                britsh.setBackgroundColor(0xffF5F5F5);
            }
        });
        britsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesToolkits.setLocalSettingUnitInfo(GeneralActivity.this,ToolKits.UNIT_YING);
                britsh.setBackgroundColor(0xFFfbc400);
                metric.setBackgroundColor(0xffF5F5F5);
            }
        });
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void initSearchingWearablePopupWindow() {
        View view = layoutInflater.inflate(R.layout.searchingwearablepopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void initGoalSettingsPopupWindow() {
        View view = layoutInflater.inflate(R.layout.goalsettingpopupwindow, null);
        final SeekBar stepsSeekbar = (SeekBar) view.findViewById(R.id.stepsSeekbar);
        final TextView distancesTextview = (TextView) view.findViewById(R.id.distances_textView);
        final TextView caloriesTextview = (TextView) view.findViewById(R.id.calories_textView);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final TextView stepsTextview = (TextView) view.findViewById(R.id.steps_textView);
        String stepGogalnfo = PreferencesToolkits.getGoalInfo(GeneralActivity.this, PreferencesToolkits.KEY_GOAL_STEP);
        if (!"".equals(stepGogalnfo)){
            stepsTextview.setText(stepGogalnfo);
            stepsSeekbar.setProgress(Integer.parseInt(stepGogalnfo)-2000);
        }
        stepsSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                stepsTextview.setText((progress+2000)+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar distanceSeekbar = (SeekBar) view.findViewById(R.id.DistanceBar);
        String distanceGogalnfo = PreferencesToolkits.getGoalInfo(GeneralActivity.this, PreferencesToolkits.KEY_GOAL_DISTANCE);
        if (!"".equals(distanceGogalnfo)){
            distancesTextview.setText(distanceGogalnfo);
            distanceSeekbar.setProgress(Integer.parseInt(distanceGogalnfo));
        }
        distanceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distancesTextview.setText((progress)+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar caloriesSeekbar = (SeekBar) view.findViewById(R.id.caloriesBar);
        String caloriesGogalnfo = PreferencesToolkits.getGoalInfo(GeneralActivity.this, PreferencesToolkits.KEY_GOAL_CAL);
        if (!"".equals(caloriesGogalnfo)){
            caloriesTextview.setText(caloriesGogalnfo);
            caloriesSeekbar.setProgress(Integer.parseInt(caloriesGogalnfo)-1000);
        }
        caloriesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                caloriesTextview.setText((progress+1000)+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                PreferencesToolkits.setGoalInfo(GeneralActivity.this,
                        PreferencesToolkits.KEY_GOAL_STEP,stepsTextview.getText().toString());
                PreferencesToolkits.setGoalInfo(GeneralActivity.this,
                        PreferencesToolkits.KEY_GOAL_DISTANCE,distancesTextview.getText().toString());
                PreferencesToolkits.setGoalInfo(GeneralActivity.this,
                        PreferencesToolkits.KEY_GOAL_CAL,caloriesTextview.getText().toString());
            }
        });

    }

    private PopupWindow getnewPopupWindow(View view){
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        return popupWindow;
    }
}
