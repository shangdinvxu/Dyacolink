package com.linkloving.dyh08.logic.UI.HeartRate.lineView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.nfc.Tag;
import android.util.AttributeSet;
import android.view.View;

import com.linkloving.dyh08.R;
import com.linkloving.dyh08.ViewUtils.barchartview.ScreenUtils;
import com.linkloving.dyh08.logic.UI.goal.SportGoalActivity;
import com.linkloving.dyh08.utils.logUtils.MyLog;

import java.util.ArrayList;
import java.util.List;

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

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        screenW = ScreenUtils.getScreenW(context);
        screenH = ScreenUtils.getScreenH(context);

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
//        canvas.drawLine((float) (screenW * 0.1), (float) (oneHourHight * 23), (float) (screenW ), (float) (oneHourHight * 26), linePaint);
//        canvas.drawLine((float) (screenW * 0.1), (float) (oneHourHight * 16), (float) (screenW ), (float) (oneHourHight * 18), linePaint);
//        canvas.drawLine((float) (screenW * 0.1), (float) (oneHourHight * 9), (float) (screenW ), (float) (oneHourHight * 10), linePaint);
//        canvas.drawLine((float) (screenW * 0.1), (float) (oneHourHight * 2), (float) (screenW ), (float) (oneHourHight * 2), linePaint);
        textPaint.setTextSize(ScreenUtils.dp2px(getContext(), 16));
        for (int i = 0; i < mItems.size(); i++) {
////          画深睡的rect
//            barRect.left = (int) (screenW * 0.02 + barItemWidth * i + barSpace * (i + 1));
//            barRect.top = (int) (oneHourHight * 14 - mItems.get(i).itemDeepValue * oneHourHight * 1.25);
//            barRect.right = (int) (barRect.left + barItemWidth);
//            barRect.bottom = (int) (oneHourHight * 14);
//            barPaint.setColor(mBarColors[0]);
//            canvas.drawRect(barRect, barPaint);
//            barRect.bottom = barRect.top;
//            barRect.top = (int) (oneHourHight * 14 - (mItems.get(i).itemDeepValue+mItems.get(i).itemLightValue) * oneHourHight * 1.25);
//            barPaint.setColor(mBarColors[1]);
//            canvas.drawRect(barRect, barPaint);
//            画点连线
//            如果间隔小于5就画线,不然就不画
            if (i<mItems.size()-1){
//                判断是否连续,连续才画线.
//                if((mItems.get(i+1).itemType-mItems.get(i).itemType)<2){
//                不乘以1000就会变成0.0
                    canvas.drawLine((float) ((mItems.get(i).itemType*1000/288)*(screenW * 0.72)/1000+0.2*screenW),
                            (float)(oneHourHight*28- (mItems.get(i).itemDeepValue*1000/200*oneHourHight * 24)/1000),
                            (float) ((mItems.get(i+1).itemType*1000/288)*(screenW * 0.72)/1000+0.2*screenW),
                            (float)(oneHourHight*28-(mItems.get(i+1).itemDeepValue*1000/200 *oneHourHight * 24)/1000),
                            linePaint);
MyLog.e(TAG,"(mItems.get(i).itemType/288)*(screenW * 0.72)"+(mItems.get(i).itemType/288)*(screenW * 0.72));
                    MyLog.e(TAG,0.15*screenW+"________"+(float) ((mItems.get(i).itemType/288)*(screenW * 0.72)+0.15*screenW)+"x"+"-----"+ (float) (mItems.get(i).itemDeepValue/200 *oneHourHight * 28+oneHourHight*4)+"y");
//                   288坐标对应的x坐标,
//                    (mItems.get(i).itemType/288*(screenW * 0.72)+0.15+screenW)
//                    200对应的y坐标
//                    mItems.get(i).itemDeepValue/200 *oneHourHight * 30+oneHourHight*4

//                }
            }

//            //draw bar rect
//            deepSleepRect.left = (int) (screenW * 0.02 + barItemWidth * i + barSpace * (i + 1));
//            deepSleepRect.top = (int) (oneHourHight * 14 - mItems.get(i).itemDeepValue * oneHourHight * 2);
//            deepSleepRect.right = (int) (barRect.left + barItemWidth);
//            deepSleepRect.bottom = (int) (oneHourHight * 14);
//            deepSleepPaint.setColor(mBarColors[0]);
//            canvas.drawRect(deepSleepRect, deepSleepPaint);
        }


        //draw x-index line.
//        canvas.drawLine(0, (float) (oneHourHight * 14), screenW, (float) (oneHourHight * 14), linePaint);


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
            float texttypeStarty = (float) (oneHourHight * 31);
            MyLog.e(TAG,texttypeStartx+"------"+texttypeStarty);
            canvas.drawText(typeText, texttypeStartx, texttypeStarty, textPaint);
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
        public long itemType;
        public float itemDeepValue;
        public float itemLightValue;


        public BarChartItemBean(long itemType, float itemDeepValue, float itemLightValue) {
            this.itemType = itemType;
            this.itemDeepValue = itemDeepValue;
            this.itemLightValue = itemLightValue;
        }
    }
}