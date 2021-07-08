package com.mike.sample.mvp.v

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.mike.sample.R
import com.mike.sample.mvc.m.LoginBean
import com.mike.sample.mvc.m.LoginCallBack
import com.mike.sample.mvc.m.LoginModel
import com.mike.sample.mvp.LoginContract
import com.mike.sample.mvp.p.LoginPresenter
import com.mike.sample.mvvm.v.afterTextChanged
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Android MVC中， activity不是纯粹的C，还实现了部分V的功能
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {
    private val mPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            pbLoading.visibility = View.VISIBLE
            mPresenter.login(etUsername.text.toString(), etPassword.text.toString())
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
        if (!mPresenter.isUserNameValid(etUsername.text.toString())) {
            etUsername.error = getString(R.string.invalid_username)
            btnLogin.isEnabled = false
        }

        if (!mPresenter.isPasswordValid(etPassword.text.toString())) {
            etPassword.error = getString(R.string.invalid_password)
            btnLogin.isEnabled = false
        }
    }


    override fun showLoading(show: Boolean) {
        if (show) {
            pbLoading.visibility = View.VISIBLE
        } else {
            pbLoading.visibility = View.GONE
        }
    }

}

