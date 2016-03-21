package com.qihaosou;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import com.qihaosou.ui.baseactivity.BaseActivity;
import com.qihaosou.ui.fragments.DrawerNavigationMenu;

public class MainActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerNavigationMenu mNavigationDrawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureDrawer();
    }
    private void configureDrawer() {
        // Configure drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_closed) {

            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    public void initView() {
        mNavigationDrawerFragment = (DrawerNavigationMenu) getSupportFragmentManager()
                .findFragmentById(R.id.main_slidingmenu_frame);

    }

    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
