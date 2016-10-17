package com.linkloving.dyh08.logic.UI.HeartRate;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkloving.band.ui.BRDetailData;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.logic.UI.HeartRate.lineView.BarChartView;
import com.linkloving.dyh08.logic.UI.HeartRate.lineView.DetailChartControl;
import com.linkloving.dyh08.logic.UI.launch.AppStartActivity;
import com.linkloving.dyh08.logic.UI.workout.Greendao.TraceGreendao;
import com.linkloving.dyh08.utils.logUtils.MyLog;
import com.linkloving.dyh08.utils.manager.AsyncTaskManger;

import java.util.ArrayList;
import java.util.List;

import Trace.GreenDao.DaoMaster;
import Trace.GreenDao.heartrate;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Daniel.Xu on 2016/10/15.
 */

public class DayFragment extends Fragment {
    private final static String TAG = DayFragment.class.getSimpleName();

    @InjectView(R.id.Heartrate_day_barchartview)
    BarChartView barchartview;
    private View view;
    private DetailChartControl detailChartControl;
    private ProgressDialog progressDialog;

    /** 当前正在运行中的数据加载异步线程(放全局的目的是尽量控制当前只有一个在运行，防止用户恶意切换导致OOM) */
    private AsyncTask<Object, Object, List<BRDetailData>> dayDataAsync = null;
    private DaoMaster.DevOpenHelper heartrateHelper;
    private TraceGreendao traceGreendao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tw_heartrate_day, container, false);
        ButterKnife.inject(this, view);
        List<BarChartView.BarChartItemBean> barChartItemBeen = new ArrayList<BarChartView.BarChartItemBean>();
        BarChartView.BarChartItemBean barChartItemBean1 = new BarChartView.BarChartItemBean(0, 0, 1);
        BarChartView.BarChartItemBean barChartItemBean2= new BarChartView.BarChartItemBean(150, 200, 1);
        BarChartView.BarChartItemBean barChartItemBean3 = new BarChartView.BarChartItemBean(288, 100, 1);
        barChartItemBeen.add(barChartItemBean1);
        barChartItemBeen.add(barChartItemBean2);
        barChartItemBeen.add(barChartItemBean3);
        barchartview.setItems(barChartItemBeen);

//   调滑动的线
        detailChartControl = (DetailChartControl)view.findViewById(R.id.activity_detailChartView1);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.summarizing_data));
        progressDialog.setCanceledOnTouchOutside(false);
//        String date = getArguments().getString("date");
        String date = "2016-10-16";
        DaySleepAsynck sleepAsynck = new DaySleepAsynck(getActivity(),detailChartControl,progressDialog, MyApplication.getInstance(getActivity()).getLocalUserInfoProvider());
        if (dayDataAsync != null){
            AsyncTaskManger.getAsyncTaskManger().removeAsyncTask(sleepAsynck, true);
        }
        AsyncTaskManger.getAsyncTaskManger().addAsyncTask(dayDataAsync = sleepAsynck);
        sleepAsynck.execute(date);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        heartrateHelper = new DaoMaster.DevOpenHelper(getActivity(), "heartrate", null);
//        SQLiteDatabase readableDatabase = heartrateHelper.getReadableDatabase();
//        GreendaoUtils greendaoUtils = new GreendaoUtils(getActivity(), readableDatabase);
//        greendaoUtils.add(2,5,6);
//        List<heartrate> search = greendaoUtils.search(2);
//        MyLog.e(TAG,search.get(0).getMax()+"");
//        MyLog.e(TAG,"-----------------------");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
