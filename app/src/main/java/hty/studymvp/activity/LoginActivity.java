package hty.studymvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hty.studymvp.R;
import hty.studymvp.module.bean.UserBean;
import hty.studymvp.presenter.UserLoginBiz;
import hty.studymvp.presenter.LoginPresenter;

/**
 * @author: skyHuang @data: 2017/12/22.
 * @editor: null @data:null
 * @description:
 */

public class LoginActivity extends AppCompatActivity implements UserLoginBiz {
    private EditText etUserName;
    private EditText etPwd;
    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        etUserName = (EditText) findViewById(R.id.user_name_et);
        etPwd = (EditText) findViewById(R.id.pwd_et);
        Button btnLogin = (Button) findViewById(R.id.btn);
        Log.i("info", "onCreate: btn="+ btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("info", "onClick: ");
                loginPresenter.login();
            }
        });

    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(this, "登录成功" + "用户名=" + userBean.getUserName()
                + "密码" + userBean.getPwd(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "密码或用户名不正确", Toast.LENGTH_SHORT).show();
    }
}
