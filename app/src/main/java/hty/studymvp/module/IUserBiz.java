package hty.studymvp.module;

import hty.studymvp.presenter.OnLoginListener;

/**
 * @author: skyHuang @data: 2017/12/22.
 * @editor: null @data:null
 * @description:
 */

public interface IUserBiz {
    void login(String userName, String pwd,OnLoginListener onLoginListener);
}
