package com.qihaosou.ui.activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.qihaosou.R;
import com.qihaosou.ui.base.BaseActivity;
import com.qihaosou.ui.fragments.CompanyQueryBeginFragment;


/**
 * Author:wenjundu
 * Email: 179451678@qq.com
 * Date:  2016/1/19
 * Description:查企业
 */
public class CompanySearchActivity extends BaseActivity {

    private Fragment currentSupportFragment; //记录当前的fragment
    private Fragment companyQueryBeginFragment,searchResultFragment ;//查询前的Fragment 和查询结果fragment
    @Override
    public void initView() {
        companyQueryBeginFragment=new CompanyQueryBeginFragment();
        changeFragment(R.id.search_content_layout,companyQueryBeginFragment);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_search;
    }
    /**
     * 用Fragment替换视图
     *
     * @param resView        将要被替换掉的视图
     * @param targetFragment 用来替换的Fragment
     */
    public void changeFragment(int resView, Fragment targetFragment) {
        if (targetFragment.equals(currentSupportFragment)) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
//            transaction.replace(resView, targetFragment);
            transaction.add(resView, targetFragment, targetFragment.getClass().getName());
        }
        if (targetFragment.isHidden()) {
            transaction.show(targetFragment);
        }
        if (currentSupportFragment != null && currentSupportFragment.isVisible()) {
            transaction.hide(currentSupportFragment);
        }
        currentSupportFragment = targetFragment;
        transaction.commit();
    }
}
