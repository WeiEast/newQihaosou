package com.qihaosou.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/21
 * Description:
 */
public class AppContext extends Application{
    static Context _context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }

    public static synchronized AppContext context() {
        return (AppContext) _context;
    }
}
