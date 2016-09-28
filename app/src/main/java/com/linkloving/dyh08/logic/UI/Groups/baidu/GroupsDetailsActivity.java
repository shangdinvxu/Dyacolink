package com.linkloving.dyh08.logic.UI.Groups.baidu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.linkloving.band.dto.SportRecord;
import com.linkloving.band.sleep.DLPSportData;
import com.linkloving.band.sleep.SleepDataHelper;
import com.linkloving.band.ui.DatasProcessHelper;
import com.linkloving.band.ui.DetailChartCountData;
import com.linkloving.dyh08.IntentFactory;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.toolbar.ToolBarActivity;
import com.linkloving.dyh08.db.sport.UserDeviceRecord;
import com.linkloving.dyh08.logic.UI.workout.Greendao.TraceGreendao;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.utils.CommonUtils;
import com.linkloving.dyh08.utils.ToolKits;
import com.linkloving.dyh08.utils.logUtils.MyLog;
import com.linkloving.utils.TimeZoneHelper;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import Trace.GreenDao.DaoMaster;
import Trace.GreenDao.Note;
import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Daniel.Xu on 2016/8/18.
 */
public class GroupsDetailsActivity extends ToolBarActivity {
    private static final String TAG = GroupsDetailsActivity.class.getSimpleName();
    @InjectView(R.id.gourps_topmap)
    MapView gourpsTopmap;
    @InjectView(R.id.groups_time)
    TextView groupsTime;
    @InjectView(R.id.groups_tv_Step)
    AppCompatTextView groupsTvStep;
    @InjectView(R.id.groups_tv_Calories)
    AppCompatTextView groupsTvCalories;
    @InjectView(R.id.groups_tv_Distance)
    AppCompatTextView groupsTvDistance;
    @InjectView(R.id.main_tv_Duration)
    AppCompatTextView groupsTvDuration;
//    @InjectView(R.id.AvgPace)
//    AppCompatTextView AvgPace;
//    @InjectView(R.id.AvgSpeed)
//    AppCompatTextView AvgSpeed;
//    @InjectView(R.id.AvgHeart)
//    AppCompatTextView AvgHeart;
//    @InjectView(R.id.MaxHeart)
//    AppCompatTextView MaxHeart;
    @InjectView(R.id.sharebutton)
    Button shareIcon;


    private int[] mSectionIndices; //源数据中每种类型头索引
    private String[] mSectionLetters;
    private static Overlay overlay = null;
    protected static MapStatusUpdate msUpdate = null;
    private static PolylineOptions polyline = null;
    protected static OverlayOptions overlayOptions;
    private static BitmapDescriptor realtimeBitmap;

    private TraceGreendao traGreendao;
    private static List<LatLng> pointList = new ArrayList<LatLng>();

    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private List<Note> startTimeList;
    private List<Note> endTimeList;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private ListView groupsListview;
    private static BaiduMap map = null;
    private Date startDate;
    private Date endDate;
    private long itemDuration;
    private String duration;
    private int user_id;
    private float distance = 0;
    private int step = 0;
    private int calories = 0;
    private ArrayList<SportRecord> sportRecordArrayList;
    private Integer position;
    private DetailChartCountData count;
    private UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_groups_detail);
        ButterKnife.inject(this);

        userEntity = MyApplication.getInstance(GroupsDetailsActivity.this).getLocalUserInfoProvider();
        user_id = userEntity.getUser_id();

        map = gourpsTopmap.getMap();
        Intent intent = getIntent();
        String postionStr = intent.getStringExtra("postion");
        position = Integer.valueOf(postionStr);
        devOpenHelper = new DaoMaster.DevOpenHelper(GroupsDetailsActivity.this, "Note", null);
        db = devOpenHelper.getReadableDatabase();
        traGreendao = new TraceGreendao(GroupsDetailsActivity.this, db);
        startTimeList = traGreendao.searchAllStarttime();
        endTimeList = traGreendao.searchAllEndTime();
        startDate = startTimeList.get(position).getStartDate();
        endDate = endTimeList.get(position).getStartDate();
        List<Note> lists = traGreendao.searchLocation(startDate, endDate);
        String durtion = getDurtion(position);
        groupsTvDuration.setText(durtion);
        groupsTvDistance.setText(getDistanceKM() + "");
        MyLog.e("itemDuration", itemDuration + "");
//这一部分是求Calories的逻辑
        List<DLPSportData> srs = SleepDataHelper.querySleepDatas2(sportRecordArrayList);
        String startDateLocal = new SimpleDateFormat(ToolKits.DATE_FORMAT_YYYY_MM_DD).format(startDate);
        try {
            count = DatasProcessHelper.countSportData(srs, startDateLocal);
            MyLog.e(TAG, "DEBUG【历史数据查询】汇总" + count.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        float x = count.runing_duation + count.walking_duration;
        float v = count.runing_distance + count.walking_distance;
        int walkCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.walking_distance)),
                (int) count.walking_duration * 60, userEntity.getUserBase().getUser_weight());
        MyLog.e("walkCal", walkCal + "");
//        userEntity.getUserBase().getUser_weight()
        int runCal = ToolKits.calculateCalories(Float.parseFloat(String.valueOf(count.runing_distance)), (int) count.runing_duation * 60, userEntity.getUserBase().getUser_weight());
        int calValue = walkCal + runCal;
        groupsTvCalories.setText(calValue + "");

        float hourtime = (float) itemDuration / 3600000;
        float avgSpeed = (distance / 1000) / hourtime;
        String avgSpeedStr = new Formatter().format("%.1f", avgSpeed).toString();
//        AvgSpeed.setText(avgSpeedStr + "km/h");
        for (int i = 0; i < lists.size(); i++) {
            Date runDate = lists.get(i).getRunDate();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String format1 = simpleDateFormat1.format(runDate);
            showRealtimeTrack(lists.get(i).getLatitude(), lists.get(i).getLongitude());
        }
        String avgPace = getAvgPace();
//        AvgPace.setText(avgPace + "/km");
        groupsTvStep.setText(getStep() + "");
        groupsTime.setText(getMiddleTime());
        shareIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupsDetailsActivity.this, GroupsShareActivity.class);
                intent.putExtra("postion", String.valueOf(position));
                startActivity(intent);
            }
        });
    }

    private String getMiddleTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a.HH:MM", Locale.US);
        String middleTime = simpleDateFormat.format(startDate);
        return middleTime;
    }

    private int getStep() {
        if (sportRecordArrayList.size() == 0) {
            step = 0;
        } else {
            for (SportRecord sportRecordArray : sportRecordArrayList) {
                MyLog.e(TAG, "step" + sportRecordArray.getStep());
                step = Integer.parseInt(sportRecordArray.getStep()) + step;

            }
        }
        return step;
    }

    private int getCalories() {
        if (sportRecordArrayList.size() == 0) {
            calories = 0;
        } else {
            for (SportRecord sportRecordArray : sportRecordArrayList) {
                MyLog.e(TAG, "calories" + sportRecordArray.getDistance());

            }
        }
        return step;
    }


    private String getAvgPace() {
        if (distance == 0) {
            return 0 + "";
        } else {
            float v = itemDuration / distance;
            int paceTime = (int) v;
            Date date = new Date(paceTime);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(Calendar.MINUTE, -TimeZoneHelper.getTimeZoneOffsetMinute());
            Date time = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            String paceFormat = simpleDateFormat.format(time);
            return paceFormat;
        }
    }

    public String getDurtion(int position) {
        long endTime = endDate.getTime();
        long startTime = startDate.getTime();
//        时间间隔转UTC
        itemDuration = Math.abs(endTime - startTime);
        MyLog.e(TAG, itemDuration + "itemDuration");
        Date date = new Date(itemDuration);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MINUTE, -TimeZoneHelper.getTimeZoneOffsetMinute());
        Date time = instance.getTime();
        duration = simpleDateFormat.format(time);
        return duration;
    }


    private String getDistanceKM() {
        MyLog.e("startDate+----+endDate", startDate.toString() + "" + endDate.toString());
        sportRecordArrayList = UserDeviceRecord.findHistoryChartwithHMS
                (GroupsDetailsActivity.this, String.valueOf(user_id), startDate, endDate);
//        MyLog.e(TAG,"sportRecordArrayList"+sportRecordArrayList.get(0).toString());
        if (sportRecordArrayList.size() == 0) {
            distance = 0;
        } else {
            for (SportRecord sportRecordArray : sportRecordArrayList) {
                MyLog.e(TAG, "distance" + sportRecordArray.getDistance());
                distance = Integer.parseInt(sportRecordArray.getDistance()) + distance;
            }
        }
//        这一步吧distance转换成如5.3 的用来加km
        MyLog.e("distance", distance + "");
        double distanceKM = CommonUtils.getDoubleValue(distance / 1000, 1);
        return new Formatter().format("%.1f", distanceKM).toString();
    }


    protected void showRealtimeTrack(double latitude, double longitude) {
        MyLog.e(TAG, latitude + "==========" + longitude);
        if (Math.abs(latitude - 0.0) < 0.000001 && Math.abs(longitude - 0.0) < 0.000001) {
            Toast.makeText(GroupsDetailsActivity.this, "当前查询无轨迹点", Toast.LENGTH_SHORT).show();
        } else {
            LatLng latLng = new LatLng(latitude, longitude);
            LatLng sourceLatLng = latLng;
            CoordinateConverter converter = new
                    CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(sourceLatLng);
            latLng = converter.convert();
            pointList.add(latLng);
            // 绘制实时点
            drawRealtimePoint(latLng);
        }
    }

    /**
     * 绘制实时点
     *
     * @param point
     */
    private void drawRealtimePoint(LatLng point) {
        if (null != overlay) {
            overlay.remove();
        }
        MapStatus mMapStatus = new MapStatus.Builder().target(point).zoom(19).build();
        msUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        if (null == realtimeBitmap) {
            realtimeBitmap = BitmapDescriptorFactory
                    .fromResource(R.mipmap.icon_geo);
        }
        overlayOptions = new MarkerOptions().position(point)
                .icon(realtimeBitmap).zIndex(9).draggable(true);
        if (pointList.size() >= 2 && pointList.size() <= 10000) {
            // 添加路线（轨迹）
            polyline = new PolylineOptions().width(10)
                    .color(Color.RED).points(pointList);
        }
        addMarker();
    }

    /**
     * 添加地图覆盖物
     */
    protected static void addMarker() {

        if (null != msUpdate) {
            map.setMapStatus(msUpdate);
        }

        // 路线覆盖物
        if (null != polyline) {
            map.addOverlay(polyline);
        }

        // 实时点覆盖物
        if (null != overlayOptions) {
            overlay = map.addOverlay(overlayOptions);
        }

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
