package com.linkloving.dyh08.logic.UI.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linkloving.dyh08.R;

/**
 * Created by Daniel.Xu on 2016/10/16.
 */

public class Myadapter extends BaseAdapter {
    private Context context ;
    public Myadapter(Context context) {
        this.context = context;
    }

    private String[] name = {context.getString(R.string.messagenoti),
            context.getString(  R.string.sendentarynotif),
            context.getString(R.string.alarmclock),
            context.getString(R.string.timersetting),
            };
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.tw_setting_detail, null);
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(name[position].toString());
        return view;
    }
}
