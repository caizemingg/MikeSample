package com.mike.sample

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/1/25
 * @description:
 */
interface ILogin : IProvider{

    fun login(userName: String, password: String): Boolean
}