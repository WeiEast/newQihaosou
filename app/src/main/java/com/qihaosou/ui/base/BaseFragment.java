package com.qihaosou.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihaosou.R;
import com.qihaosou.app.AppContext;
import com.qihaosou.interf.BaseFragmentInterface;
import com.qihaosou.ui.dialog.DialogControl;

import butterknife.ButterKnife;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/22
 * Description:
 */
public abstract class BaseFragment extends Fragment implements BaseFragmentInterface {
    protected static final int STATE_NONE = 0;
    protected static final int STATE_REFRESH = 1;
    protected static final int STATE_LOADMORE = 2;
    public static final int STATE_NOMORE = 3;
    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态
    protected int mState = STATE_NONE;

    protected LayoutInflater mInflater;
    public AppContext getApplication() {
        return (AppContext) getActivity().getApplication();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflateContentView() > 0) {
            View view = inflater.inflate(inflateContentView(),null);
            this.mInflater = inflater;
            ButterKnife.inject(this, view);
            initView(view);
            initData();
            return view;
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    abstract protected int inflateContentView();
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected int getLayoutId() {
        return 0;
    }
    protected View inflateView(int resId) {
        return this.mInflater.inflate(resId, null);
    }

    public boolean onBackPressed() {
        return false;
    }
    protected void hideWaitDialog() {
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogControl) {
            ((DialogControl) activity).hideWaitDialog();
        }
    }

    protected ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    protected ProgressDialog showWaitDialog(int resid) {
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl) activity).showWaitDialog(resid);
        }
        return null;
    }

    protected ProgressDialog showWaitDialog(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl) activity).showWaitDialog(str);
        }
        return null;
    }

}
