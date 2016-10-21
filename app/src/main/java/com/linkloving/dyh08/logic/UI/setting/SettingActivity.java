package com.linkloving.dyh08.logic.UI.setting;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting_activity);
        ButterKnife.inject(this);
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
                        break;
                    case 2:
                        break;
                }
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
