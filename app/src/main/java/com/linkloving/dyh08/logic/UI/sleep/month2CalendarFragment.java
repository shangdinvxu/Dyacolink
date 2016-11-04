package com.linkloving.dyh08.logic.UI.sleep;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkloving.band.dto.DaySynopic;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.logic.UI.sleep.sleepBarchartView.BarChartViewforMonth;
import com.linkloving.dyh08.utils.CommonUtils;
import com.linkloving.dyh08.utils.DbDataUtils;
import com.linkloving.dyh08.utils.logUtils.MyLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Daniel.Xu on 2016/11/3.
 */

public class Month2CalendarFragment extends Fragment {
    private static final String TAG = Month2CalendarFragment.class.getSimpleName();
    BarChartViewforMonth barChartView;
    private View view;
    private BarChartViewforMonth.BarChartItemBean[] items;
    private List<BarChartViewforMonth.BarChartItemBean> month;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sleepmonthfragment, container, false);
        barChartView = (BarChartViewforMonth) view.findViewById(R.id.sleep_week_barchartview);
        String date = getArguments().getString("monthDate");
        MyLog.e(TAG, date);
        new MonthChartAsynckTask().execute(date);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public class MonthChartAsynckTask extends AsyncTask<Object, Object, List<DaySynopic>> {
        private final String[] PLANETS = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        private Date dateWithI;
        private String firstDayOfMonth;
        private String lastDayOfMonth;
        private int year;
        private String[] splitdata;
        private String[] split = {"", "", ""};
        private Date parseDate;
        String param;

        protected List<DaySynopic> doInBackground(Object... params) {

            param = params[0].toString();
            //            如果没有的话则说明选择的是今天的,手动给他一个日期
            MyLog.e("param1", param);
            if (param == null || param.length() <= 0) {
                Date time = Calendar.getInstance().getTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
                String todayParam = simpleDateFormat.format(time);
                param = todayParam;
            }
            MyLog.e("param1", param);
            String[] split = param.split("-");
            String year = split[0];
            String month = split[1];
            firstDayOfMonth = CommonUtils.getFirstDayOfMonth(Integer.parseInt(year), Integer.parseInt(month));
            lastDayOfMonth = CommonUtils.getLastDayOfMonth(Integer.parseInt(year), Integer.parseInt(month));
            MyLog.e("firstDayOfMonth", "firstDayOfMonth" + firstDayOfMonth + "_______" + lastDayOfMonth);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
            return DbDataUtils.findMonthDatainSql(getActivity(), simpleDateFormat, firstDayOfMonth, lastDayOfMonth);
        }

        @Override
        protected void onPostExecute(List<DaySynopic> daySynopics) {
            super.onPostExecute(daySynopics);
            int step = 0;
            month = new ArrayList<>();
            Calendar rightNow = Calendar.getInstance();
            SimpleDateFormat sim = new SimpleDateFormat("MM/dd");
            for (DaySynopic daySynopic : daySynopics) {
                int deepSleepHour = (int) (CommonUtils.getScaledDoubleValue(Double.valueOf(daySynopic.getDeepSleepMiute()), 0));
                //跑步 里程
                int lightSleepHour = (int) (CommonUtils.getScaledDoubleValue(Double.valueOf(daySynopic.getSleepMinute()), 0));
                double sleepTime = CommonUtils.getScaledDoubleValue(lightSleepHour + deepSleepHour, 1);

                String date = daySynopic.getData_date();
                try {
                    parseDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String format = sim.format(parseDate);
                MyLog.e(TAG,"lightSleepHour"+lightSleepHour+"======"+"deepSleepHour"+deepSleepHour);
                BarChartViewforMonth.BarChartItemBean barChartItemBean = new BarChartViewforMonth.BarChartItemBean(format, deepSleepHour,lightSleepHour);
                MyLog.e(TAG, barChartItemBean.itemType.toString() + "=======");
                month.add(barChartItemBean);
            }
          /*  BarChartViewforMonth.BarChartItemBean barChartItemBean1 = new BarChartViewforMonth.BarChartItemBean("2", 1,1);
            BarChartViewforMonth.BarChartItemBean barChartItemBean23 = new BarChartViewforMonth.BarChartItemBean("2", 2,2);
            BarChartViewforMonth.BarChartItemBean barChartItemBean4 = new BarChartViewforMonth.BarChartItemBean("2", 3,3);
            BarChartViewforMonth.BarChartItemBean barChartItemBean5 = new BarChartViewforMonth.BarChartItemBean("2", 4,4);
            BarChartViewforMonth.BarChartItemBean barChartItemBean6 = new BarChartViewforMonth.BarChartItemBean("1", 5,5);
            BarChartViewforMonth.BarChartItemBean barChartItemBean11 = new BarChartViewforMonth.BarChartItemBean("2", 1,1);
            BarChartViewforMonth.BarChartItemBean barChartItemBean231 = new BarChartViewforMonth.BarChartItemBean("2", 2,2);
            BarChartViewforMonth.BarChartItemBean barChartItemBean41 = new BarChartViewforMonth.BarChartItemBean("2", 3,3);
            BarChartViewforMonth.BarChartItemBean barChartItemBean51 = new BarChartViewforMonth.BarChartItemBean("2", 4,4);
            BarChartViewforMonth.BarChartItemBean barChartItemBean61= new BarChartViewforMonth.BarChartItemBean("1", 5,5);
            month.add(barChartItemBean1);
            month.add(barChartItemBean23);
            month.add(barChartItemBean4);
            month.add(barChartItemBean5);
            month.add(barChartItemBean6);
            month.add(barChartItemBean11);
            month.add(barChartItemBean231);
            month.add(barChartItemBean41);
            month.add(barChartItemBean51);
            month.add(barChartItemBean61);*/
            barChartView.setItems(month);
        }
    }
}



