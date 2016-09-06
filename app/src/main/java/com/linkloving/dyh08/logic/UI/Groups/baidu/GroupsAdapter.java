package com.linkloving.dyh08.logic.UI.Groups.baidu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.linkloving.band.dto.SportRecord;
import com.linkloving.band.sleep.DLPSportData;
import com.linkloving.band.sleep.SleepDataHelper;
import com.linkloving.band.ui.DatasProcessHelper;
import com.linkloving.band.ui.DetailChartCountData;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.db.sport.UserDeviceRecord;
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
import java.util.List;

import Trace.GreenDao.DaoMaster;
import Trace.GreenDao.Note;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Administrator on 2016/8/11.
 */
public class GroupsAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
    private static final String TAG = GroupsAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mMonthData;
    private int[] mSectionIndices; //源数据中每种类型头索引
    private String[] mSectionLetters;
    private TraceGreendao traGreendao ;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private final List<Note>startTimeList;
    private final List<Note> endTimeList;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private final int user_id;
    private long itemDuration;
    private Date itemStartDate ;
    private Date itemEndDate ;
    private String duration;
    private TextView heardYearMonth;
    private TextView activityNumbers;
    private ArrayList<Integer> sectionIndices;
    private final List<Note> list;
    private DetailChartCountData count;
    private final UserEntity userEntity;

    public GroupsAdapter(Context context) {
        this.mContext = context;

        userEntity = MyApplication.getInstance(mContext).getLocalUserInfoProvider();
        user_id   = userEntity.getUser_id();

        mInflater = LayoutInflater.from(mContext);
        //源数据
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "Note", null);
        db = devOpenHelper.getReadableDatabase();
        traGreendao = new TraceGreendao(context,db);
        list = traGreendao.searchAlltimes();
        mMonthData = new String[list.size()];
        for (int i = 0 ;i< list.size();i++){
            mMonthData[i]= list.get(i).getDate();
            MyLog.e(TAG,"mMonthData[i].toString():"+mMonthData[i].toString());
        }
/*        //获取A.B.C的 index
        mSectionIndices = getSectionIndices();
//        //获取所有字母头的方法（去重复）
        mSectionLetters = getSectionLetters();*/

        startTimeList = traGreendao.searchAllStarttime();
        endTimeList = traGreendao.searchAllEndTime();
    }

    private int[] getSectionIndices() {
        //需要知道每个头在源数据里面的索引位置
        sectionIndices = new ArrayList<Integer>();
        String lastChar = mMonthData[0];
        sectionIndices.add(0);
        for(int i = 1;i< mMonthData.length;i++){
            if(mMonthData[i] != lastChar){
                sectionIndices.add(i);
            }
        }
        int[] sections = new int[sectionIndices.size()];
        for(int i = 0;i< sectionIndices.size();i++){
            sections[i] = sectionIndices.get(i);
        }
        return sections;
    }

    /**
     * 通过下标的索引 获取Head上的数据集
     * @return
     */
    public String [] getSectionLetters() {
        String[] letters = new String[mSectionIndices.length];
        for(int i = 0;i<mSectionIndices.length;i++){
            letters[i] = mMonthData[mSectionIndices[i]];
        }
        return letters;
    }

    public View getHeaderView(int i, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if(convertView == null){
            holder = new HeaderViewHolder();
            convertView = mInflater.inflate(R.layout.tw_groups_itemheard, parent, false);
            holder.heardYearMonth = (TextView) convertView.findViewById(R.id.groupsYearMonth);
           holder.activityNumbers = (TextView) convertView.findViewById(R.id.activityMonuts);
            convertView.setTag(holder);
        }else{
            holder = (HeaderViewHolder) convertView.getTag();
        }
        String yearMonth = mMonthData[i].toString();
        MyLog.e(TAG, yearMonth);
        holder.heardYearMonth.setText(mMonthData[i].toString());
        int amount = 0 ;
        for (Note listitem:list) {
            if (listitem.getDate().equals(yearMonth)){
                amount = amount +1 ;
            }
        }
        holder.activityNumbers.setText(amount+" activities");
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.sticklist_item_layout, parent, false);
            holder.dataTime = (AutoCompleteTextView) convertView.findViewById(R.id.dataTime);
            holder.distance = (AutoCompleteTextView) convertView.findViewById(R.id.distance);
            holder.duration = (AutoCompleteTextView) convertView.findViewById(R.id.duration);
            holder.avgSpeed = (AutoCompleteTextView) convertView.findViewById(R.id.avgSpeed);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.dataTime.setText(startTimeList.get(position).getDate());
//      每个item的开始时间和结束时间
        itemStartDate = startTimeList.get(position).getStartDate();
        itemEndDate = endTimeList.get(position).getStartDate();
        long endTime = itemEndDate.getTime();
        long startTime = itemStartDate.getTime();
//        时间间隔转UTC
        itemDuration = Math.abs(endTime - startTime);
        MyLog.e(TAG, itemDuration + "itemDuration");
        Date date = new Date(itemDuration);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MINUTE,-TimeZoneHelper.getTimeZoneOffsetMinute());
        Date time = instance.getTime();
        duration = simpleDateFormat.format(time);
        float distance = 0 ;
        ArrayList<SportRecord> sportRecordArrayList = UserDeviceRecord.
                findHistoryChartwithHMS(mContext, String.valueOf(user_id), itemStartDate, itemEndDate);

        if (sportRecordArrayList.size()==0){
            distance = 0 ;
        }else{
            for (SportRecord sportRecordArray:sportRecordArrayList) {
                MyLog.e(TAG,"distance"+sportRecordArray.getDistance());
                distance =Integer.parseInt(sportRecordArray.getDistance())+distance ;
            }
        }
//        这一步吧distance转换成如5.3 的用来加km
        double distanceKM = CommonUtils.getDoubleValue(distance / 1000, 1);
        float hourtime = (float)itemDuration/3600000 ;
        float avgSpeed = (distance/1000) /hourtime;
        String distanceStr = new Formatter().format("%.1f", distanceKM).toString();
        holder.distance.setText(distanceStr + " km");

        holder.duration.setText(duration);
        String avgSpeedStr = new Formatter().format("%.1f", avgSpeed).toString();
        holder.avgSpeed.setText(avgSpeedStr+" km/h");
        return convertView;

    }

    @Override
    public long getHeaderId(int position) {
        MyLog.e(TAG, "getHeardId执行了");
        MyLog.e(TAG, "heardID是:  " + mMonthData[position].charAt(0));
        return mMonthData[position].charAt(0);
//        return position ;
    }

    @Override
    public int getCount() {
        return mMonthData.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class HeaderViewHolder {
        TextView heardYearMonth;
        TextView activityNumbers ;

    }

    class ViewHolder {
        AutoCompleteTextView dataTime;
        AutoCompleteTextView distance;
        AutoCompleteTextView duration;
        AutoCompleteTextView avgSpeed;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }
    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
