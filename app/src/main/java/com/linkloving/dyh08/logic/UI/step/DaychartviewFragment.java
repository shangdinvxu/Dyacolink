package com.linkloving.dyh08.logic.UI.step;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkloving.band.dto.SportRecord;
import com.linkloving.band.sleep.DLPSportData;
import com.linkloving.band.sleep.SleepDataHelper;
import com.linkloving.band.ui.DatasProcessHelper;
import com.linkloving.band.ui.DetailChartCountData;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.db.sport.UserDeviceRecord;
import com.linkloving.dyh08.logic.UI.Groups.baidu.GroupsDetailsActivity;
import com.linkloving.dyh08.logic.UI.calories.barchartview.BarChartView;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.utils.ToolKits;
import com.linkloving.dyh08.utils.logUtils.MyLog;
import com.linkloving.utils.TimeZoneHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by leo.wang on 2016/8/2.
 */
public class DaychartviewFragment extends Fragment {
    public static final String COLUMN_START_TIME="start_time";
    private static final String TAG = DaychartviewFragment.class.getSimpleName();
    private List<BarChartView.BarChartItemBean> dayhour = new ArrayList<>();
    private BarChartView barChartView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tw_calories_chartview_fragment, container, false);
        barChartView = (BarChartView) view.findViewById(R.id.day_barchartView);
        barChartView.setPopupViewType(BarChartView.STEP__TYPE);
        String checkDate = getArguments().getString("checkDate");
        new DaychartviewFragment.DayChartAsynck().execute(checkDate);
        return view;
    }

    private class DayChartAsynck extends AsyncTask<Object, Object, List<BarChartView.BarChartItemBean>> {

        private Date parse;
        private ArrayList<Date> stringTimeList;
        ArrayList<SportRecord> sportRecordArrayList = new ArrayList<SportRecord>();
        UserDeviceRecord chatMessageTable = UserDeviceRecord.getInstance(getActivity());
        String user_id = MyApplication.getInstance(getActivity()).getLocalUserInfoProvider().getUser_id() + "";
        Date startdata ;
        Date enddata ;
        private DetailChartCountData count;
        UserEntity userEntity= MyApplication.getInstance(getActivity()).getLocalUserInfoProvider();


        @Override
        protected List<BarChartView.BarChartItemBean> doInBackground(Object... objects) {
            stringTimeList = new ArrayList<>();
            String time = objects[0].toString()+" 00:00:00.000";
            MyLog.e("time是",time);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            try {
                parse =  simpleDateFormat.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
//            instance.add(Calendar.MINUTE, -TimeZoneHelper.getTimeZoneOffsetMinute());// before 8 hour
            Date time1 = instance.getTime();
//            String format = simpleDateFormat.format(time1);
            stringTimeList.add(time1);
            for (int i = 0; i<24;i++)
            {
                instance.add(Calendar.HOUR_OF_DAY,1);
                Date time2 = instance.getTime();
                String format1 = simpleDateFormat.format(time2);
//                stringTimeList.add(format1);
                stringTimeList.add(time2);
            }

            for (int i=0;i<24;i++){
                int stepnumber = 0 ;
                startdata = stringTimeList.get(i);
                enddata = stringTimeList.get(i+1);
//                String where = COLUMN_START_TIME+">='"+startdata+"' and "+COLUMN_START_TIME+"<'"+enddata+"'";
//                // 查找此期间内的运动原始数据
//                sportRecordArrayList = chatMessageTable.findHistory(user_id, where);
                sportRecordArrayList = UserDeviceRecord.findHistoryChartwithHMS
                        (getActivity(), String.valueOf(user_id), startdata, enddata);
                if (sportRecordArrayList.size() == 0) {
                    stepnumber = 0;
                } else {
                    for (SportRecord sportRecordArray : sportRecordArrayList) {
                        if (sportRecordArray.getState().equals("1")||sportRecordArray.getState().equals("2")||sportRecordArray.getState().equals("3"))
                        stepnumber = Integer.parseInt(sportRecordArray.getStep()) + stepnumber;
                    }
                }
//              List<DLPSportData> srs = SleepDataHelper.querySleepDatas2(sportRecordArrayList);
 /*                 String startDateLocal = new SimpleDateFormat(ToolKits.DATE_FORMAT_YYYY_MM_DD).format(time1);
                try {
                    count = DatasProcessHelper.countSportData(srs, startDateLocal);
                    MyLog.e(TAG, "DEBUG【历史数据查询】汇总" + count.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                float walkstep = count.walking_steps ;
                float runing_steps = count.runing_steps;*/

                BarChartView.BarChartItemBean barChartItemBean = new BarChartView.BarChartItemBean(Integer.toString(i+1), stepnumber);

                dayhour.add(barChartItemBean);
            }
            return dayhour;
        }
        protected void onPostExecute(final List<BarChartView.BarChartItemBean> dayhour) {
            super.onPostExecute(dayhour);
            barChartView.setItems(dayhour);
            barChartView.setDialogListerer(new BarChartView.DialogListerer() {
                @Override
                public void showDialog(int i, int x, int y) {
                    String textShowTime = i+":00";
                    barChartView.showPopupWindow(view, textShowTime,(int) dayhour.get(i).itemValue, x, y);
                }
                @Override
                public void dismissPopupWindow() {
                    barChartView.popupWindow.dismiss();
                }
            });
        }
    }
}
