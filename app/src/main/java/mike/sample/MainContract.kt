package mike.sample

import android.view.View


/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/12
 * @description:
 */
interface MainContract {

    interface View : BaseContract.BaseView<Presenter, android.view.View> {
    }

    interface Presenter : BaseContract.BasePresenter<View> {

    }
}