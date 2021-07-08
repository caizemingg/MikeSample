package com.mike.sample.mvp

import com.mike.sample.mvc.m.LoginBean
import com.mike.sample.mvc.m.LoginCallBack

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/12/25
 * @description:
 */
interface LoginContract {
    interface Presenter {
        fun login(username: String, password: String)
        fun isUserNameValid(username: String): Boolean
        fun isPasswordValid(password: String): Boolean
    }

    interface View {
        fun showLoading(show: Boolean)
    }
}