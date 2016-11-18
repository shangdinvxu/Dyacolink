package com.linkloving.dyh08.logic.UI.map;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.linkloving.band.dto.SportRecord;
import com.linkloving.band.sleep.DLPSportData;
import com.linkloving.band.sleep.SleepDataHelper;
import com.linkloving.band.ui.DatasProcessHelper;
import com.linkloving.band.ui.DetailChartCountData;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.db.sport.UserDeviceRecord;
import com.linkloving.dyh08.logic.UI.Groups.baidu.GroupsDetailsActivity;
import com.linkloving.dyh08.logic.UI.Groups.baidu.GroupsShareActivity;
import com.linkloving.dyh08.logic.UI.workout.Greendao.TraceGreendao;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.utils.CommonUtils;
import com.linkloving.dyh08.utils.ToolKits;
import com.linkloving.dyh08.utils.logUtils.MyLog;
import com.linkloving.utils.TimeZoneHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import Trace.GreenDao.DaoMaster;
import Trace.GreenDao.Note;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.linkedin.LinkedIn;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.wechat.utils.WechatHelper;

/**
 * Created by Daniel.Xu on 2016/9/21.
 */

public class MapActivity extends ToolBarActivity {
    private static final String TAG = MapActivity.class.getSimpleName();
    @InjectView(R.id.groups_time)
    TextView groupsTime;
    @InjectView(R.id.groups_tv_Step)
    AppCompatTextView groupsTvStep;
    @InjectView(R.id.Rl_step)
    RelativeLayout RlStep;
    @InjectView(R.id.groups_tv_Calories)
    AppCompatTextView groupsTvCalories;
    @InjectView(R.id.Rl_calories)
    RelativeLayout RlCalories;
    @InjectView(R.id.groups_tv_Distance)
    AppCompatTextView groupsTvDistance;
    @InjectView(R.id.Rl_distance)
    RelativeLayout RlDistance;
    @InjectView(R.id.main_tv_Duration)
    AppCompatTextView mainTvDuration;
    @InjectView(R.id.Rl_sleep)
    RelativeLayout RlSleep;
    @InjectView(R.id.sharebutton)
    Button sharebutton;
    @InjectView(R.id.shareEditText)
    EditText shareEditText;
    @InjectView(R.id.screenhot)
    LinearLayout screenhot;
    private View view;
    private String filePathCache = "/sdcard/ranking_v444.png";
    private ImageView fb,wx,qq,linkin,instagram;
    private ImageView twitter;
    private TraceGreendao traGreendao;
    private static List<LatLng> pointList = new ArrayList<LatLng>();
    private SQLiteDatabase db;
    private List<Note> startTimeList;
    private List<Note> endTimeList;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date todayDate;
    private String stringToday;
    private Date startDate;
    private UserEntity userEntity;
    private int user_id;
    private ArrayList<SportRecord> sportRecordArrayList;
    private float distance = 0;
    private int step = 0;
    private  int calValue = 0;
    private DetailChartCountData count;
    private String filePathCacheTotal = "/sdcard/ranking_v333.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_share_day);
        view = LayoutInflater.from(MapActivity.this).inflate(R.layout.tw_share_day, null);
        ButterKnife.inject(this);
        ShareSDK.initSDK(MapActivity.this);
        userEntity = MyApplication.getInstance(MapActivity.this).getLocalUserInfoProvider();
        user_id = userEntity.getUser_id();
        initPopupWindow();
//        加载每日数据
        init();
    }

    private void initPopupWindow() {
        final View popupView = LayoutInflater.from(MapActivity.this).inflate(R.layout.tw_share_popuwindow, null);
        final PopupWindow popupWindow = new PopupWindow(popupView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(popupView);
        fb = (ImageView) popupView.findViewById(R.id.fb);
        wx = (ImageView) popupView.findViewById(R.id.wx);
        qq = (ImageView) popupView.findViewById(R.id.qq);
        linkin = (ImageView) popupView.findViewById(R.id.Linkin);
        instagram = (ImageView) popupView.findViewById(R.id.instagram);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffffffff));
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 20);
                ToolKits.getScreenHot(screenhot, filePathCache);
            }
        });
        share();

    }

    private void share() {
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facebook.ShareParams shareParams = new Facebook.ShareParams();
//                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCacheTotal);
                Platform facebook = ShareSDK.getPlatform(Facebook.NAME);
                facebook.share(shareParams);
                boolean b = facebook.hasShareCallback();
                facebook.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        MyLog.e(TAG,throwable.toString()+"-----------Error");
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
            }
        });
        wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WechatHelper.ShareParams shareParams = new WechatHelper.ShareParams();
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
                platform.share(shareParams);
                platform.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
            }
        });

        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QQ.ShareParams shareParams = new QQ.ShareParams();
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(QQ.NAME);
                platform.share(shareParams);
                boolean b = platform.hasShareCallback();
            }
        });
        linkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedIn.ShareParams shareParams = new LinkedIn.ShareParams();
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(LinkedIn.NAME);
                platform.share(shareParams);
                boolean b = platform.hasShareCallback();
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instagram.ShareParams shareParams = new Instagram.ShareParams();
                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(Instagram.NAME);
                platform.share(shareParams);
                boolean b = platform.hasShareCallback();
            }
        });
    /*    twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Twitter.ShareParams shareParams = new Twitter.ShareParams();
//                shareParams.setFilePath(filePathCache);
                shareParams.setImagePath(filePathCache);
                Platform platform = ShareSDK.getPlatform(Twitter.NAME);
                platform.share(shareParams);
                boolean b = platform.hasShareCallback();
                showToast(b);
            }
        });*/
    }



    private void init() {
        devOpenHelper = new DaoMaster.DevOpenHelper(MapActivity.this, "Note", null);
        db = devOpenHelper.getReadableDatabase();
        traGreendao = new TraceGreendao(MapActivity.this, db);
        String middleTime = getMiddleTime();
        groupsTime.setText(middleTime);
        startTimeList = traGreendao.searchAllStarttime();
        endTimeList = traGreendao.searchAllEndTime();
//        得到哪几个记录是今天的
        List<Integer> startNoteList = new ArrayList<>();
        for (int i = 0; i < startTimeList.size(); i++) {
            startDate = startTimeList.get(i).getStartDate();
            MyLog.e(TAG,"startDate"+startDate);
            String starttime = simpleDateFormat.format(startDate);
            MyLog.e(TAG,"starttime-----------"+starttime);
            if (starttime.equals(stringToday)) {
                startNoteList.add(i);
            }
        }
        long duration = 0 ;
        MyLog.e(TAG,startTimeList.size()+"-----"+startNoteList.size());
        for (Integer i : startNoteList) {
            long startTime = startTimeList.get(startNoteList.get(i-1)).getStartDate().getTime();
            long endTime = endTimeList.get(startNoteList.get(i-1)).getStartDate().getTime();
            duration = duration+endTime-startTime;
        }
        String durtionText = getDurtion(duration);
        mainTvDuration.setText(durtionText);



        //求Distance的逻辑
        float distanceTotal = 0 ;
        float stepTotal = 0 ;
        int  caloriesTotal = 0 ;

        for (Integer i :startNoteList){
            Date startDate = startTimeList.get(startNoteList.get(i-1)).getStartDate();
            Date endDate = endTimeList.get(startNoteList.get(i-1)).getStartDate();
            sportRecordArrayList = UserDeviceRecord.findHistoryChartwithHMS
                    (MapActivity.this, String.valueOf(user_id), startDate, endDate);
            if (sportRecordArrayList.size() == 0) {
                distance = 0;
                step = 0 ;
                calValue = 0 ;
            } else {
                for (SportRecord sportRecordArray : sportRecordArrayList) {
                    MyLog.e(TAG, "distance" + sportRecordArray.getDistance());
                    distance = Integer.parseInt(sportRecordArray.getDistance()) + distance;
                    step = Integer.parseInt(sportRecordArray.getStep()) + step;
                    //这一部分是求Calories的逻辑
                    List<DLPSportData> srs = SleepDataHelper.querySleepDatas2(sportRecordArrayList);
                    String startDateLocal = new SimpleDateFormat(ToolKits.DATE_FORMAT_YYYY_MM_DD).format(startDate);
                    try {
                        count = DatasProcessHelper.countSportData(srs, startDateLocal);
                        MyLog.e(TAG, "DEBUG【历史数据查询】汇总" + count.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    int walkCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.walking_distance)),
                            (int) count.walking_duration * 60, userEntity.getUserBase().getUser_weight());
                    MyLog.e("walkCal", walkCal + "");
//        userEntity.getUserBase().getUser_weight()
                    int runCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.runing_distance)), (int) count.runing_duation * 60, userEntity.getUserBase().getUser_weight());
                     calValue = walkCal + runCal;
                }
            }
            caloriesTotal = caloriesTotal+calValue ;
            distanceTotal = distanceTotal+distance ;
            stepTotal = stepTotal +step ;
        }
//        这一步吧distance转换成如5.3 的用来加km
        MyLog.e("distance", distance + "");
        double distanceKM = CommonUtils.getDoubleValue(distanceTotal / 1000, 1);
        String distanceTotalString = new Formatter().format("%.1f", distanceKM).toString();

        groupsTvDistance.setText(distanceTotalString);
        groupsTvStep.setText(stepTotal+"");
        groupsTvCalories.setText(caloriesTotal+"");

    }

    /**
     * long 转String
     * @param durationTime
     * @return
     */
    public String getDurtion(long durationTime) {
//        时间间隔转UTC
        Date date = new Date(durationTime);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MINUTE, -TimeZoneHelper.getTimeZoneOffsetMinute());
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
       String duration = simpleDateFormat.format(time);
        return duration;
    }


    private String getMiddleTime() {
        todayDate = new Date();
        SimpleDateFormat simpleDateFormatWithM = new SimpleDateFormat("yyyy-MM-dd a.HH:MM", Locale.US);
        String middleTime = simpleDateFormatWithM.format(todayDate);
        stringToday = simpleDateFormat.format(todayDate);
        return middleTime;
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
