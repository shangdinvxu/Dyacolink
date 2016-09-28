package com.linkloving.dyh08.logic.UI.launch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.linkloving.dyh08.BleService;
import com.linkloving.dyh08.IntentFactory;
import com.linkloving.dyh08.MyApplication;
import com.linkloving.dyh08.R;
import com.linkloving.dyh08.basic.AppManager;
import com.linkloving.dyh08.logic.dto.EntEntity;
import com.linkloving.dyh08.logic.dto.SportDeviceEntity;
import com.linkloving.dyh08.logic.dto.UserBase;
import com.linkloving.dyh08.logic.dto.UserEntity;
import com.linkloving.dyh08.prefrences.PreferencesToolkits;

public class AppStartActivity extends AppCompatActivity {

    private final static String TAG = AppStartActivity.class.getSimpleName();
    public static String SHAREDPREFERENCES_NAME = "first_pref";
    private RelativeLayout startLL = null;
    private int logined = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // FIX: 以下代码是为了解决Android自level 1以来的[安装完成点击“Open”后导致的应用被重复启动]的Bug
        // @see https://code.google.com/p/android/issues/detail?id=52247
        // @see https://code.google.com/p/android/issues/detail?id=2373
        // @see https://code.google.com/p/android/issues/detail?id=26658
        // @see https://github.com/cleverua/android_startup_activity
        // @see http://stackoverflow.com/questions/4341600/how-to-prevent-multiple-instances-of-an-activity-when-it-is-launched-with-differ/
        // @see http://stackoverflow.com/questions/12111943/duplicate-activities-on-the-back-stack-after-initial-installation-of-apk
        // 加了以下代码还得确保Manifast里加上权限申请：“android.permission.GET_TASKS”
        if (!isTaskRoot())
        {// FIX START
            final Intent intent = getIntent();
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
                    intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
                finish();
            }
        }// FIX END
        super.onCreate(savedInstanceState);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final View view = View.inflate(this, R.layout.activity_app_start, null);
        setContentView(view);

        startLL = (RelativeLayout) findViewById(R.id.start_LL);
        /**设置APP状态为打开*/
        BleService.getInstance(this).setEXIT_APP(false);

        UserEntity user = PreferencesToolkits.getLocalUserInfo(this);

        AppManager.getAppManager().addActivity(this);




      /*  if(user != null && !CommonUtils.isStringEmpty(user.getEsplash_screen_file_name()))
        {
            //MyApplication.getInstance(this)._const.DIR_ENT_IMAGE_RELATIVE_DIR + "/" + user.getEsplash_screen_file_name()
            File file = new File(EntHelper.getEntFileSavedDir(this)+"/"+ user.getEsplash_screen_file_name());
            if(file.exists())
            {
                try
                {
                    // Drawable com.eva.android
                    startLL.setBackground(BitmapHelper.loadDrawble(file.getAbsolutePath()));
                }
                catch (Exception e)
                {
                    Log.w(TAG, e.getMessage(), e);
                }
            }
        }*/
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0)
            {
                redirectTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }

            @Override
            public void onAnimationStart(Animation animation)
            {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
    }


    /**
     * 跳转到...
     */
    private void redirectTo()
    {
            UserEntity userAuthedInfo = PreferencesToolkits.getLocalUserInfoForLaunch(this);
            if( userAuthedInfo == null)
            {
                userAuthedInfo = new UserEntity();
                userAuthedInfo.setUser_id(123456);
                userAuthedInfo.setDeviceEntity(new SportDeviceEntity());
                userAuthedInfo.setUserBase(new UserBase("1980-01-01"));
                userAuthedInfo.setEntEntity(new EntEntity());
                userAuthedInfo.getUserBase().setUser_status(1);
                userAuthedInfo.getUserBase().setNickname("User");
                userAuthedInfo.getUserBase().setUser_weight(60);
                userAuthedInfo.getUserBase().setUser_height(175);
//                userAuthedInfo.getDeviceEntity().setLast_sync_device_id("");
            }
            MyApplication.getInstance(this).setLocalUserInfoProvider(userAuthedInfo);
//        开始跳转到用户信息设置界面
        SharedPreferences logined1 = getSharedPreferences("logined", MODE_PRIVATE);
        int login = logined1.getInt("login", 0);
        logined=login ;
        if (logined==0){
            IntentFactory.startUsername(AppStartActivity.this);
            SharedPreferences logined = getSharedPreferences("logined", MODE_PRIVATE);
            SharedPreferences.Editor edit = logined.edit();
            edit.putInt("login",1);
            edit.commit();
        }else{
                        startActivity(IntentFactory.createPortalActivityIntent(AppStartActivity.this));
        }
            AppStartActivity.this.finish();
    }


}
