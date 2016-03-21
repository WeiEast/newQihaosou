package com.qihaosou.ui.baseactivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.qihaosou.R;
import com.qihaosou.app.AppManager;
import com.qihaosou.interf.BaseViewInterface;
import com.qihaosou.util.StringUtils;
import butterknife.ButterKnife;
/**
 * Author: Created by wenjundu
 * Date:on 2016/3/21
 * Description:
 */
public class BaseActivity extends AppCompatActivity implements BaseViewInterface{
    protected LayoutInflater mInflater;

    private Toolbar mActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        if (!hasActionBar()) {
            // supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
       // mActionBar = (Toolbar) findViewById(R.id.actionBar);//getSupportActionBar();
        mInflater = getLayoutInflater();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }

        // 通过注解绑定控件
        ButterKnife.inject(this);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
    protected void onBeforeSetContentLayout() {}
    protected boolean hasActionBar() {
        return true;
    }
    protected int getLayoutId() {
        return 0;
    }
    protected boolean hasBackButton() {
        return false;
    }
    protected int getActionBarTitle() {
        return R.string.app_name;
    }
    protected View inflateView(int resId) {
        return mInflater.inflate(resId, null);
    }
    protected void initActionBar(Toolbar actionBar) {
        if (actionBar == null)
            return;
        setSupportActionBar(mActionBar);
        if (hasBackButton()) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            getSupportActionBar().setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }
        }
    }
    public void setActionBarTitle(int resId) {
        if (resId != 0) {
            setActionBarTitle(getString(resId));
        }
    }

    public void setActionBarTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            title = getString(R.string.app_name);
        }
        if (hasActionBar() && mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
