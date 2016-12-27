package com.linkloving.dyh08.logic.UI.distance;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkloving.band.dto.SportRecord;
import com.linkloving.band.ui.DetailChartCountData;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.db.sport.UserDeviceRecord;
import com.linkloving.dyh08.ViewUtils.barchartview.DayBarChartView;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.utils.logUtils.MyLog;

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
    private static final String TAG = com.linkloving.dyh08.logic.UI.step.DaychartviewFragment.class.getSimpleName();
    private List<DayBarChartView.BarChartItemBean> dayhour = new ArrayList<>();
    private DayBarChartView dayBarChartView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tw_calories_chartview_fragment, container, false);
        dayBarChartView = (DayBarChartView) view.findViewById(R.id.day_barchartView);
        dayBarChartView.setPopupViewType(DayBarChartView.DISTANCE__TYPE);
        String checkDate = getArguments().getString("checkDate");
        new DaychartviewFragment.DayChartAsynck().execute(checkDate);
        return view;
    }

    private class DayChartAsynck extends AsyncTask<Object, Object, List<DayBarChartView.BarChartItemBean>> {

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
        protected List<DayBarChartView.BarChartItemBean> doInBackground(Object... objects) {
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
//                String format1 = simpleDateFormat.format(time2);
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
                             stepnumber = Integer.parseInt(sportRecordArray.getDistance()) + stepnumber;
                    }
                }
//                List<DLPSportData> srs = SleepDataHelper.querySleepDatas2(sportRecordArrayList);
//                String startDateLocal = new SimpleDateFormat(ToolKits.DATE_FORMAT_YYYY_MM_DD).format(time1);
//                try {
//                    count = DatasProcessHelper.countSportData(srs, startDateLocal);
//                    MyLog.e(TAG, "DEBUG【历史数据查询】汇总" + count.toString());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                float walkstep = count.walking_distance ;
//                float runing_steps = count.runing_distance;

           /*     int walkCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.walking_distance)),
                        (int) count.walking_duration * 60, userEntity.getUserBase().getUser_weight());
//        userEntity.getUserBase().getUser_weight()
                int runCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.runing_distance)), (int)count.runing_duation * 60, userEntity.getUserBase().getUser_weight());
                int calValue = walkCal + runCal;
                MyLog.e(TAG, "calValue" + calValue);*/
                DayBarChartView.BarChartItemBean barChartItemBean = new DayBarChartView.BarChartItemBean(Integer.toString(i+1),stepnumber);
                dayhour.add(barChartItemBean);
            }
            return dayhour;
        }
        protected void onPostExecute(final List<DayBarChartView.BarChartItemBean> dayhour) {
            super.onPostExecute(dayhour);
            dayBarChartView.setItems(dayhour);
            dayBarChartView.setDialogListerer(new DayBarChartView.DialogListerer() {
                @Override
                public void showDialog(int i, int x, int y) {
                    String textShowTime = i+":00";
                    dayBarChartView.showPopupWindow(view,textShowTime, (int) dayhour.get(i).itemValue, x, y);
                }
                @Override
                public void dismissPopupWindow() {
                    dayBarChartView.popupWindow.dismiss();
                }
            });
        }
    }
}
