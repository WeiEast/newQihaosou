package com.qihaosou.ui.activitys;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.https.TaskException;
import com.lzy.okhttputils.request.BaseRequest;
import com.qihaosou.R;
import com.qihaosou.interf.MyTextWacher;
import com.qihaosou.ui.base.BaseActivity;
import com.qihaosou.util.UIHelper;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import butterknife.InjectView;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: wenjundu
 * Email:179451678@qq.com
 * Date:2016/1/13
 * Description:
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    @InjectView(R.id.tv_forget_password)
    TextView forgetPasswordTV;
    @InjectView(R.id.tv_register_acount)
    TextView registerTV;
    @InjectView(R.id.edt_login_number)
    EditText phoneET;
    @InjectView(R.id.edt_login_password)
    EditText passwordET;
    @InjectView(R.id.btn_login_newpage)
    Button loginBtn;
    @InjectView(R.id.ll_thridlogin_qq)
    LinearLayout loginQQ;
    @InjectView(R.id.ll_thridlogin_wx)
    LinearLayout loginWechat;
    private UMShareAPI mShareAPI = null;
    private MyTextWacher wacher;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        String phone=phoneET.getText().toString();
        String password=passwordET.getText().toString();
        SHARE_MEDIA platform = null;
        switch (v.getId()){
            case R.id.tv_forget_password://忘记密码
                UIHelper.showResetPasswordActivity(this);
                break;
            case R.id.tv_register_acount://注册
                UIHelper.showRegisterActivity(this);
                break;
            case R.id.btn_login_newpage://登录
                Login(phone,password);
                break;
            case R.id.ll_thridlogin_qq://qq登录
                platform = SHARE_MEDIA.QQ;
                break;
            case R.id.ll_thridlogin_wx://微信登录
                platform = SHARE_MEDIA.WEIXIN;
                break;
        }
        if(platform!=null)
            mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);
    }

    private void Login(String phone,String password) {
        String clientType="android";
        final LoadingDialog loadingDialog=new LoadingDialog(LoginActivity.this);
        OkHttpUtils.post(UriHelper.getInstance().getLoginUrl(phone, password, clientType)).tag(this).execute(new UserBeanCallBack() {

            @Override
            public void onBefore(BaseRequest request) {
                loadingDialog.show();
            }

            @Override
            public void onAfter(@Nullable UserBean userBean, Request request, Response response, @Nullable TaskException e) {
                loadingDialog.dismiss();

            }

            @Override
            public void onError(Request request, @Nullable Response response, @Nullable TaskException e) {
                ToastUtil.TextToast(LoginActivity.this,e.getMessage());
            }

            @Override
            public void onResponse(UserBean userBean) {
                ToastUtil.TextToast(getApplicationContext(),getString(R.string.login_success));
                finish();
            }
        });
    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//            if(platform==SHARE_MEDIA.QQ){
                ToastUtil.TextToast(getApplicationContext(), action+"Authorize succeed");
                L.e("........:"+data.toString());
//            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ToastUtil.TextToast(getApplicationContext(), "Authorize fail");
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ToastUtil.TextToast(getApplicationContext(), "Authorize cancel");
        }
    };

    @Override
    public void initView() {
        forgetPasswordTV.setOnClickListener(this);
        registerTV.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        loginWechat.setOnClickListener(this);
        loginQQ.setOnClickListener(this);
        wacher=new MyTextWacher(loginBtn,phoneET,passwordET);
        phoneET.addTextChangedListener(wacher);
        passwordET.addTextChangedListener(wacher);
    }

    @Override
    public void initData() {
        mShareAPI = UMShareAPI.get(this);
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.login_button_login;
    }
}
