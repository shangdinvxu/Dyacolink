package com.linkloving.dyh08.logic.UI.setting;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.linkloving.dyh08.IntentFactory;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.utils.logUtils.MyLog;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/21.
 */

public class SettingActivity extends ToolBarActivity {
    @InjectView(R.id.listview)
    ListView listview;
    private LayoutInflater layoutInflater;
    private View totalView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting_activity);
        ButterKnife.inject(this);
        layoutInflater = LayoutInflater.from(SettingActivity.this);
        totalView = layoutInflater.inflate(R.layout.tw_setting_activity, null);
       String[] strings = {getString(R.string.Notificationsetting),
                getString(R.string.General),
                getString(R.string.Datasync),
        };
        Myadapter myadapter = new Myadapter(SettingActivity.this, strings);
        listview.setAdapter(myadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        IntentFactory.startNotification(SettingActivity.this);
                        break;
                    case 1:
                        IntentFactory.startGeneral(SettingActivity.this);
                        break;
                    case 2:
                        initDatasynchroizationPopupwindow();
                        break;
                }
            }
        });

    }

    private void initDatasynchroizationPopupwindow() {
        View view = layoutInflater.inflate(R.layout.datasynchronizationpopupwindow, null);
        ImageView retrievedata = (ImageView) view.findViewById(R.id.retrievedata);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        retrievedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRetrievedata();
            }
        });

    }

    private void initRetrievedata() {
        View view = layoutInflater.inflate(R.layout.retrievedatapopupwindow, null);
        ImageView retrievedata = (ImageView) view.findViewById(R.id.retrievedata);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow = getnewPopupWindow(view);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
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
