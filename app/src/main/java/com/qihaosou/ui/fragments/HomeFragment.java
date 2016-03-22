package com.qihaosou.ui.fragments;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qihaosou.R;
import com.qihaosou.ui.activitys.CompanySearchActivity;
import com.qihaosou.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.InjectView;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public class HomeFragment extends BaseFragment {
    @InjectView(R.id.list_view)
    ListView mListView;
    private TextView btnSearch;
    private int mCurrentList = 0;
    ArrayAdapter<String> adapter = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        View headerView=mInflater.inflate(R.layout.home_header_layout, null);
        mListView.addHeaderView(headerView);
        btnSearch= (TextView) headerView.findViewById(R.id.btn_search);
        ArrayList<String> list1 = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(adapter);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CompanySearchActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void initData() {

    }
}
