package mike.sample.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/10/12
 * @description:
 */

interface Shop {
    fun sell()
}

class AppleShop : Shop {
    override fun sell() {
        println("AppleShop sell apple")
    }
}

class BananaShop : Shop {
    override fun sell() {
        println("BananaShop sell banana")
    }
}

// 静态代理
class AppleShopStaticProxy(private val mAppleShop: AppleShop) : Shop {
    override fun sell() {
        println("AppleShopStaticProxy before sell apple")
        mAppleShop.sell()
        println("AppleShopStaticProxy after sell apple")

    }
}

// 动态代理，jdk会为我们生成代理类
class ShopInvocationHandler(private val mShop: Shop) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any? {
        println("ShopInvocationHandler before")
        val result = if (args == null) {
            method.invoke(mShop)
        } else {
            method.invoke(mShop, args)
        }

        println("ShopInvocationHandler after")
        return result
    }

}

fun main() {
    val appleShopProxy = AppleShopStaticProxy(AppleShop())
    appleShopProxy.sell()

    val newProxyInstance = Proxy.newProxyInstance(
        Shop::class.java.classLoader,
        arrayOf(Shop::class.java),
        ShopInvocationHandler(BananaShop())
    ) as Shop
    newProxyInstance.sell()

}