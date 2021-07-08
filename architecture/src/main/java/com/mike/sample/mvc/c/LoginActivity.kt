package com.mike.sample.mvc.c

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.mike.sample.R
import com.mike.sample.mvc.m.LoginBean
import com.mike.sample.mvc.m.LoginCallBack
import com.mike.sample.mvc.m.LoginModel
import com.mike.sample.mvvm.v.afterTextChanged
import com.mike.sample.ui.login.LoginFormState
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Android MVC中， activity不是纯粹的C，还实现了部分V的功能
 */
class LoginActivity : AppCompatActivity() {

    private val mLoginModel = LoginModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            pbLoading.visibility = View.VISIBLE
            mLoginModel.login(etUsername.text.toString(), etPassword.text.toString(), object : LoginCallBack {
                override fun success(loginBean: LoginBean) {
                    pbLoading.visibility = View.GONE
                    // 登录成功后，把用户信息进行持久化，
                    // 是否需要持久化是一个业务逻辑，而持久化用户数据的具体实现我们放到了model层，以便其他功能能复用，
                    // 例如后续增加了自动登录的功能，那我们很可能一样是需要把自动登录的用户数据进行持久化
                    mLoginModel.saveLoginInfo(loginBean)
                }

                override fun failure(errorCode: Int, errorMsg: String) {
                    pbLoading.visibility = View.GONE
                }
            })
        }
        etUsername.afterTextChanged {
            checkInfoValid()
        }
        etPassword.afterTextChanged {
            checkInfoValid()
        }
    }

    private fun checkInfoValid() {
        btnLogin.isEnabled = true
        if (!isUserNameValid(etUsername.text.toString())) {
            etUsername.error = getString(R.string.invalid_username)
            btnLogin.isEnabled = false
        }

        if (!isPasswordValid(etPassword.text.toString())) {
            etPassword.error = getString(R.string.invalid_password)
            btnLogin.isEnabled = false
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

}

