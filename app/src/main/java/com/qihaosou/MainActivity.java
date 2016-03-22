package com.qihaosou;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.View;

import com.qihaosou.bean.UMShareImageBean;
import com.qihaosou.ui.base.BaseActivity;
import com.qihaosou.ui.dialog.ShareDialog;
import com.qihaosou.ui.fragments.DemoFragment;
import com.qihaosou.ui.fragments.DrawerNavigationMenu;
import com.qihaosou.ui.fragments.HomeFragment;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends BaseActivity implements DrawerNavigationMenu.NavigationDrawerCallbacks {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerNavigationMenu mNavigationDrawerFragment;
    private Fragment currentSupportFragment;
    private UMShareImageBean umShareImageBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureDrawer();
        if (null == savedInstanceState) {
        changeFragment(R.id.main_content, new HomeFragment());

        }
    }
    private void configureDrawer() {
        // Configure drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,mActionBar,
                R.string.drawer_open,
                R.string.drawer_closed) {

            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    public void initView() {
        mNavigationDrawerFragment = (DrawerNavigationMenu) getSupportFragmentManager()
                .findFragmentById(R.id.main_slidingmenu_frame);

    }

    @Override
    public void initData() {
        umShareImageBean=new UMShareImageBean();
        umShareImageBean.setShareText("hahahahah");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.menu_header_bg);
        UMImage image = new UMImage(MainActivity.this, bitmap);
        umShareImageBean.setUmImage(image);
        umShareImageBean.setShareTitle("快快分享吧");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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

    @Override
    public void onNavigationDrawerItemSelected(DrawerNavigationMenu.MenuType menuType) {
        switch (menuType){
            case MENU_SEARCH://企业查询
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case MENU_SHARE://APP分享
                ShareDialog shareDialog=new ShareDialog(MainActivity.this,umShareImageBean );
                //shareDialog.setUmShareListener(new UMShareCallBack(MainActivity.this));
                shareDialog.show();
                break;
            case MENU_COM://评价
                break;
            case MENU_USER://个人中心
                break;
        }
    }
}
