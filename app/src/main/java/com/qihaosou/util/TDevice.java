package com.qihaosou.util;

import android.net.ConnectivityManager;

import com.qihaosou.app.AppContext;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public class TDevice {
    public static boolean hasInternet() {
        boolean flag;
        if (((ConnectivityManager) AppContext.context().getSystemService(
                "connectivity")).getActiveNetworkInfo() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }
}
