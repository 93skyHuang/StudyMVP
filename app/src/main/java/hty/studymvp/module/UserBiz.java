package hty.studymvp.module;

import hty.studymvp.module.bean.UserBean;
import hty.studymvp.presenter.OnLoginListener;

/**
 * @author: skyHuang @data: 2017/12/22.
 * @editor: null @data:null
 * @description: 做业务逻辑的类
 */

public class UserBiz implements IUserBiz {

    @Override
    public void login(final String userName, final String pwd, final OnLoginListener onLoginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("hty".equals(userName) && "111".equals(pwd)) {
                    UserBean userBean = new UserBean();
                    userBean.setPwd(pwd);
                    userBean.setUserName(userName);
                    onLoginListener.loginSuccess(userBean);
                } else {
                    onLoginListener.loginFail();
                }
            }
        }).start();
    }
}
