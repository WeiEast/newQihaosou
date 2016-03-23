package com.qihaosou.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.context.GlobalContext;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/21
 * Description:
 */
public class AppContext extends GlobalContext {
    public static final int PAGE_SIZE = 20;// 默认分页大小
    static Context _context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        try {
            OkHttpUtils.getInstance()//
                    .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)//全局的连接超时时间
                    .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)//全局的读取超时时间
                    .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS);//全局的写入超时时间
            //.setCertificates(getAssets().open("srca.cer"), getAssets().open("zhy_server.cer"))//
            // .setCertificates(new Buffer().writeUtf8(CER_12306).inputStream());//设置自签名网站的证书

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized AppContext context() {
        return (AppContext) _context;
    }
}
