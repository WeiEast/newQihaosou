package com.qihaosou.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihaosou.R;
import com.qihaosou.adapter.MarkAdapter;
import com.qihaosou.bean.CompanyLogoBean;
import com.qihaosou.ui.base.BaseListFragment;
import com.qihaosou.ui.base.ListBaseAdapter;
import com.qihaosou.ui.empty.EmptyLayout;

import java.util.ArrayList;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public class DemoFragment extends BaseListFragment{

    @Override
    protected ListBaseAdapter getListAdapter() {
        return new MarkAdapter();
    }
    @Override
    protected void sendRequestData() {
        ArrayList<CompanyLogoBean> list=new ArrayList<CompanyLogoBean>();
//        for(int i=0;i<20;i++){
//            CompanyLogoBean companyLogoBean=new CompanyLogoBean();
//            companyLogoBean.setRegName("苹果专利");
//            companyLogoBean.setSbName("詹姆斯卡梅伦安东尼戴维斯的情况却温暖的风口请你放开手拿疯狂");
//            list.add(companyLogoBean);
//        }
        mAdapter.addData(list);
        mErrorLayout.setNoDataContent("哈哈哈，没搜索你看个蛋蛋");
        executeOnLoadDataSuccess(list);
        executeOnLoadFinish();
    }

    @Override
    public void initData() {

    }
}
