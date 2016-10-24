package com.linkloving.dyh08.logic.UI.setting;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.ViewUtils.Wheelview.WheelView;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/16.
 */

public class NotificationSettingActivity extends ToolBarActivity {
    @InjectView(R.id.listview)
    ListView listview;
    private LayoutInflater layoutInflater;
    private View totalView;
    private ArrayList<String> hrStrings;
    private ArrayList<String> minStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting_activity);
        ButterKnife.inject(this);
        hrStrings = new ArrayList<>();
        for (int i = 0 ; i<=23;i++){
            String s ;
            if (i<10){
                s="0"+i;
            }else{
                s = Integer.toString(i);
            }
            hrStrings.add(s);
        }
        minStrings = new ArrayList<>();
        for (int i=0 ;i<=59;i++){
            String s ;
            if (i<10){
                s="0"+i;
            }else{
                s = Integer.toString(i);
            }
            minStrings.add(s);
        }
        String[] strings = {getString(R.string.messagenoti),
                getString(  R.string.sendentarynotif),
                getString(R.string.alarmclock),
                getString(R.string.timersetting),
        };
        layoutInflater = LayoutInflater.from(NotificationSettingActivity.this);
        totalView = layoutInflater.inflate(R.layout.tw_setting_activity, null);
        Myadapter myadapter = new Myadapter(NotificationSettingActivity.this,strings);
        listview.setAdapter(myadapter);
        View heardview = LayoutInflater.from(NotificationSettingActivity.this).inflate(R.layout.tw_setting_heardview, null);
        TextView textHeartView = (TextView) heardview.findViewById(R.id.textHeartView);
        textHeartView.setText(R.string.Notificationsetting);
        listview.addHeaderView(heardview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /**因为有头所以从1开始*/
                switch (position){
                    case 1:
                        initMessagePopupWindow();
                        break;
                    case 2:
                        initSedentaryPopupWindow();
                        break;
                    case 3:
                        initClockPopupWindow();
                        break;
                    case 4:
                        initTimeSettingPopupWindow();
                        break;

                }
            }
        });
    }

    private void initTimeSettingPopupWindow() {
        View view = layoutInflater.inflate(R.layout.timesettingpopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        TextView clock1 = (TextView) view.findViewById(R.id.clock_1);
        TextView clock2 = (TextView) view.findViewById(R.id.clock2);
        TextView clock3 = (TextView) view.findViewById(R.id.clock_3);
        TextView clock4 = (TextView) view.findViewById(R.id.clock_4);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        clock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });

    }

    private void initClockPopupWindow() {
        View view = layoutInflater.inflate(R.layout.alarmclockpopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        TextView clock1 = (TextView) view.findViewById(R.id.clock_1);
        TextView clock2 = (TextView) view.findViewById(R.id.clock2);
        TextView clock3 = (TextView) view.findViewById(R.id.clock_3);
        TextView clock4 = (TextView) view.findViewById(R.id.clock_4);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        clock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        clock4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
    }

    private void initSedentaryPopupWindow() {
        View view = layoutInflater.inflate(R.layout.sedentarypopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        ImageView startTimeNext = (ImageView) view.findViewById(R.id.startTimeNext);
        ImageView endTimeNext = (ImageView) view.findViewById(R.id.endTimeNext);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        startTimeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
        endTimeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePopupWindow();
            }
        });
    }

    public PopupWindow showStartTimePopupWindow(){
        View view = View.inflate(NotificationSettingActivity.this, R.layout.starttimepopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        WheelView hrWheelView = (WheelView) view.findViewById(R.id.hr);
        hrWheelView.setItems(hrStrings);
        WheelView minWheelView = (WheelView) view.findViewById(R.id.min);
        minWheelView.setItems(minStrings);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        return  popupWindow;
    }

    private void initMessagePopupWindow() {
        View view = layoutInflater.inflate(R.layout.messagepopupwindow, null);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setClippingEnabled(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffD3D3D3));
        popupWindow.showAtLocation(totalView, Gravity.BOTTOM,0,0);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
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

}
