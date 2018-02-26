package hty.studymvp.presenter;

import android.os.Handler;
import android.util.Log;

import hty.studymvp.module.bean.UserBean;
import hty.studymvp.module.UserBiz;

/**
 * @author: skyHuang @data: 2017/12/22.
 * @editor: null @data:null
 * @description:
 */

public class LoginPresenter {

    private UserLoginBiz userLoginBiz;
    private UserBiz userBiz;
    private Handler handler = new Handler();

    public LoginPresenter(UserLoginBiz userLoginBiz) {
        Log.i("info", "LoginPresenter: ");
        this.userLoginBiz = userLoginBiz;
        userBiz = new UserBiz();
    }

    public void login() {
        userBiz.login(userLoginBiz.getUserName(), userLoginBiz.getPwd(), new OnLoginListener() {

            @Override
            public void loginSuccess(final UserBean userBean) {
                Log.i("info", "loginSuccess: ");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginBiz.loginSuccess(userBean);
                    }
                });
            }

            @Override
            public void loginFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginBiz.loginFail();
                    }
                });

            }
        });
    }

}
