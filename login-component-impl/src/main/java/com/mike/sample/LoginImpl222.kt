package com.mike.sample

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/1/25
 * @description:
 */
@Route(path = "/login22/main")
open class LoginImpl222 : ILogin {
    companion object {
        const val TAG = "czm"
    }

    override fun login(userName: String, password: String): Boolean {
        Log.e(TAG, "-------------------------------")
        Log.e(TAG, "login, userName = $userName, $this")
        Log.e(TAG, "-------------------------------")
        return true
    }

    override fun init(context: Context?) {
        Log.e("czm", "LoginImpl init")
    }
}