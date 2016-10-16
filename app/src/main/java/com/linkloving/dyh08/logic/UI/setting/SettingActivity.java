package com.linkloving.dyh08.logic.UI.setting;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.linkloving.dyh08.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/16.
 */

public class SettingActivity extends Activity {
    @InjectView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_setting_activity);
        ButterKnife.inject(this);
        Myadapter myadapter = new Myadapter(SettingActivity.this);
        listview.setAdapter(myadapter);
    }

}
