package com.linkloving.dyh08.logic.UI.HeartRate.DayView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.linkloving.dyh08.ViewUtils.barchartview.ScreenUtils;
import com.linkloving.dyh08.utils.logUtils.MyLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 自定义组件：条形统计图
 */
public class BarChartView extends View {
    public static final String TAG = BarChartView.class.getSimpleName();
    private int screenW, screenH;
    private List<BarChartView.BarChartItemBean> mItems = new ArrayList<BarChartItemBean>();
    //第一个是深色,第二个是total色,第三是画横线
    private int[] mBarColors = new int[]{Color.rgb(26, 43, 95), Color.rgb(38, 174, 222), Color.rgb(217, 173, 18)};
    private Paint barPaint, linePaint, textPaint;
    private Rect barRect;
    private int lineStrokeWidth;
    private double barItemWidth, barSpace, oneHourHight;
    private Rect deepSleepRect;
    private Paint deepSleepPaint;
    private SimpleDateFormat simpleDateFormat;
//    每天有多少分钟
    private final static long ONE_DAY_MILLISECOND = 86400 ;
    private final static long EIGHT_HOUR_SECONDS  =28800 ;
    private final static long THIRTY_MINUTES_SECONDS = 2400 ;

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        screenW = ScreenUtils.getScreenW(context);
        screenH = ScreenUtils.getScreenH(context);
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        barPaint = new Paint();
        deepSleepPaint = new Paint();
        barPaint.setColor(mBarColors[0]);
        linePaint = new Paint();
        lineStrokeWidth = ScreenUtils.dp2px(context, 1);
        linePaint.setStrokeWidth(lineStrokeWidth);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        barRect = new Rect(0, 0, 0, 0);
        deepSleepRect = new Rect(0, 0, 0, 0);
        barItemWidth = screenW * 0.09;
        barSpace = screenW * 0.035;
//        设置一个一小时的高度
        oneHourHight = screenH * 0.017;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(26, 43, 95));
//        画2 4 6 8 10 线
        linePaint.setColor(mBarColors[2]);
        for (int i = 0 ; i<5;i++){
            canvas.drawLine( (float) (screenW * 0.1), (float) (oneHourHight * (4+6*i)), (float) (screenW ), (float) (oneHourHight * (4+6*i)), linePaint);
            MyLog.e(TAG,"2468横线"+(float) (oneHourHight * (4+6*i)));
//            画竖的小线.
            if(i%2!=0){
                canvas.drawLine((float) (screenW * (0.2 + i * 0.18)), (float) (oneHourHight * 28),(float) (screenW * (0.2 + i * 0.18)),(float) (oneHourHight * 27.5) , linePaint);
            }else{
                canvas.drawLine((float) (screenW * (0.2 + i * 0.18)), (float) (oneHourHight * 28),(float) (screenW * (0.2 + i * 0.18)),(float) (oneHourHight * 27) , linePaint);
            }
        }
        textPaint.setTextSize(ScreenUtils.dp2px(getContext(), 16));
//        将时间变成的几点几分。
        transformToPoint();
        for (int i = 0; i < mItems.size(); i++) {
            if (i<mItems.size()-1){
                    //大于30分钟就不画线
                if ((mItems.get(i+1).starttime-mItems.get(i).starttime)<THIRTY_MINUTES_SECONDS) {
                    /**将开始时间装换成相应的百分比*/
                    canvas.drawLine((float) (((((double) (mItems.get(i).starttime + EIGHT_HOUR_SECONDS) / ONE_DAY_MILLISECOND) * (screenW * 0.72)) + 0.2 * screenW)),
                            (float) (oneHourHight * 28 - (mItems.get(i).itemDeepValue * 1000 / 200 * oneHourHight * 24) / 1000),
                            (float) (((((double) (mItems.get(i + 1).starttime + EIGHT_HOUR_SECONDS) / ONE_DAY_MILLISECOND) * (screenW * 0.72)) + 0.2 * screenW)),
                            (float) (oneHourHight * 28 - (mItems.get(i + 1).itemDeepValue * 1000 / 200 * oneHourHight * 24) / 1000),
                            linePaint);
                }
            }
        }

//        画 2 4 6 8 10H 文字
        String[] twoHour = {"200", "150", "100", "50", "0"};
        textPaint.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            String typeText = twoHour[i];
            float texttypeStartx = (float) 0.02*screenW;
            float texttypeStarty = (float) (oneHourHight * (4.5+6*i));
            canvas.drawText(typeText, texttypeStartx, texttypeStarty, textPaint);
        }

        String[] week = {"00:00", "06:00", "12:00", "18:00","24:00" };
        for (int i = 0; i < 5; i++) {
            String typeText = week[i];
            float texttypeStartx = (float) (screenW * (0.15 + i * 0.18));
            float texttypeStarty = (float) (oneHourHight * 29.5);
            MyLog.e(TAG,texttypeStartx+"------"+texttypeStarty);
            canvas.drawText(typeText, texttypeStartx, texttypeStarty, textPaint);
        }
    }

    /**
     * 将时间转化成点
     */
    public  void  transformToPoint(){
        MyLog.e(TAG,"transform执行了");
        for (BarChartItemBean record :mItems) {
//            取出一天的时间是多少。
            long oneDayTime = record.starttime % ONE_DAY_MILLISECOND;
            record.starttime=oneDayTime ;
        }
    }

    public List<BarChartItemBean> getItems() {
        return mItems;
    }

    public void setItems(List<BarChartItemBean> items) {

        this.mItems = items;
        invalidate();
    }

    /**
     * A model class to keep the bar item info.
     */
    public static class BarChartItemBean {
         long starttime;
         float itemDeepValue;
         float itemLightValue;


        public BarChartItemBean(long time, float maxHeartrate, float minHeartrate) {
            this.starttime = time;
            this.itemDeepValue = maxHeartrate;
            this.itemLightValue = minHeartrate;
        }
    }
}