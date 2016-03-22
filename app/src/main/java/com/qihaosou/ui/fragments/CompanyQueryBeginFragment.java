package com.qihaosou.ui.fragments;

import android.view.View;

import com.qihaosou.R;
import com.qihaosou.adapter.ViewPageFragmentAdapter;
import com.qihaosou.ui.base.BaseViewPagerFragment;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public class CompanyQueryBeginFragment extends BaseViewPagerFragment {
    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] title = getResources().getStringArray(
                R.array.begin_search);
        adapter.addTab(title[0], "search_history", DemoFragment.class,
                null);
        adapter.addTab(title[1], "search_collect", DemoFragment.class,
                null);
    }


    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
