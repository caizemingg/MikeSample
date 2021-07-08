package mike.sample

import android.view.View

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020-03-09
 * @description:
 */
interface BaseContract {

    interface BaseView<T, V : View> {
        /**
         * 关联presenter
         */
        fun start(presenter: T)

        /**
         * 安卓View
         * @return T 返回安卓View
         */
        fun asView(): V

    }

    interface BasePresenter<T : BaseView<*, *>> {
        /**
         * UI显示时调用，根据逻辑需要做一些初始化
         */
        fun start(view: T)

        /**
         * UI消失时调用，做一些释放资源等操作
         */
        fun stop()
    }
}