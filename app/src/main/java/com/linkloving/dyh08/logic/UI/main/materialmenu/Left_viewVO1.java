package com.linkloving.dyh08.logic.UI.main.materialmenu;

import com.linkloving.dyh08.R;

/**
 * Created by leo.wang on 2016/7/25.
 */
public class Left_viewVO1 {
    public static final int Bluetooth = 0;
    public static final int Settings = 1;
    public static final int Workout = 2;
    public static final int Groups = 3;
    public static final int Heart_Rate = 4;
    public static final int Height = 5;
    public static final int Weight = 6;
    public static final int Sign_out = 7;

    public static int[] menuIcon = {
            R.mipmap.imageblueicon,
            R.mipmap.imageseticon,
            R.mipmap.imageworkouticon,
            R.mipmap.imagegroupsicon,
            R.mipmap.imageheartsicon,
            R.mipmap.imageheighticon,
            R.mipmap.imageweighticon,
            R.mipmap.imagesignouticon
    };
    public static int[] menuText = {
           R.string.Bluetooth,
            R.string.Settings,
            R.string.Workout,
                    R.string.Groups,
                    R.string.Heart_Rate,
                    R.string.Height,
                    R.string.Weight,
                    R.string.Sign_Out
    };
}