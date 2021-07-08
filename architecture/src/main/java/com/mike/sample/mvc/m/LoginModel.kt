package com.mike.sample.mvc.m

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/12/25
 * @description:
 */
class LoginModel {

    fun login(username: String, password: String, loginCallBack: LoginCallBack) {

    }

    fun saveLoginInfo(loginBean: LoginBean) {

    }
}

interface LoginCallBack {
    fun success(loginBean: LoginBean)
    fun failure(errorCode: Int, errorMsg: String)
}

data class LoginBean(val username: String, val avatar: String)