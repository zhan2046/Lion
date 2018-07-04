package com.ruzhan.lion;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class App extends Application {

    private static App INSTANCE;

    public static App get() {
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        Utils.init(this);
    }
}
