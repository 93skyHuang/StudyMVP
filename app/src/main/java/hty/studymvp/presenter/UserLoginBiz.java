package hty.studymvp.presenter;

import hty.studymvp.module.bean.UserBean;

/**
 * @author: skyHuang @data: 2017/12/22.
 * @editor: null @data:null
 * @description:
 */

public interface UserLoginBiz {
    String getUserName();

    String getPwd();

    void loginSuccess(UserBean userBean);

    void loginFail();
}
