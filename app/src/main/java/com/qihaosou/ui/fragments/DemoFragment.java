package com.qihaosou.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihaosou.R;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public class DemoFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_drawer_menu, container, false);
    }
}
