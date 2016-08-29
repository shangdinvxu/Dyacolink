package com.linkloving.dyh08.logic.UI.distance;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.ViewUtils.calendar.MonthDateView;

import butterknife.ButterKnife;

/**
 * Created by leo.wang on 2016/7/28.
 */
public class DayViewFragment extends Fragment {

    public ImageView left_btn ;
    public ImageView right_btn;
    public MonthDateView monthDateView;

    private IDataChangeListener dataChangeListener;
    private View view ;
    public String date;

    public void setDataChangeListener(IDataChangeListener dataChangeListener){
        this.dataChangeListener = dataChangeListener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tw_dayview_fragment, container, false);
        ButterKnife.inject(this, view);
      /*  List<Integer> list = new ArrayList<Integer>();
        list.add(10);
		list.add(12);
		list.add(15);
		list.add(16);*/
        left_btn = (ImageView) view.findViewById(R.id.step_calendar_iv_left);
        right_btn = (ImageView) view.findViewById(R.id.step_calendar_iv_right);
        monthDateView = (MonthDateView) view.findViewById(R.id.monthDateView);
//        tv_date = (TextView)view.findViewById(R.id.date_text);
//        tv_week = (TextView) view.findViewById(R.id.week_text);
//        tv_today = (TextView)view.findViewById(R.id.tv_today);
//        monthDateView.setTextView(tv_date, tv_week);
//        monthDateView.setDaysHasThingList(list);
        monthDateView.setDateClick(new MonthDateView.DateClick() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClickOnDate() {
                //拼接日期字符串（可以自己定义）
                if (monthDateView.getmSelDay()==0){
                    return ;
                }
                String checkDate =monthDateView.getmSelYear()+"-"+monthDateView.getmSelMonth()+"-"+monthDateView.getmSelDay();
               dataChangeListener.onDataChange(checkDate);
            }
        });
        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthDateView.onLeftClick();
            }
        });
        right_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 monthDateView.onRightClick();
            }
        });

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
