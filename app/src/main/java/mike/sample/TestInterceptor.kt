package mike.sample

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * @author caizeming
 * @email caizeming@cvte.com
 * @date 2021/2/7
 * @description:
 */
@Interceptor(priority = 8, name = "测试用拦截器")
class TestInterceptor : IInterceptor {
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        callback.onContinue(postcard) // 处理完成，交还控制权
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程

        // 以上两种至少需要调用其中一种，否则不会继续路由
    }

    override fun init(context: Context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
    }
}