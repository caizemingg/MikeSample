package com.mike.sample.mvp.p

import android.util.Patterns
import android.view.View
import com.mike.sample.mvc.m.LoginBean
import com.mike.sample.mvc.m.LoginCallBack
import com.mike.sample.mvc.m.LoginModel
import com.mike.sample.mvp.LoginContract
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/12/25
 * @description:
 */
class LoginPresenter(private val mView: LoginContract.View) : LoginContract.Presenter {
    private val mLoginModel = LoginModel()

    override fun login(username: String, password: String) {
        mView.showLoading(true)
        mLoginModel.login(username, password, object : LoginCallBack {
            override fun success(loginBean: LoginBean) {
                mView.showLoading(false)
                // 登录成功后，把用户信息进行持久化，
                // 是否需要持久化是一个业务逻辑，而持久化用户数据的具体实现我们放到了model层，以便其他功能能复用，
                // 例如后续增加了自动登录的功能，那我们很可能一样是需要把自动登录的用户数据进行持久化
                mLoginModel.saveLoginInfo(loginBean)
            }

            override fun failure(errorCode: Int, errorMsg: String) {
                mView.showLoading(false)

            }
        })
    }

    override fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    override fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }


}