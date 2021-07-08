package mike.sample

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/12
 * @description:
 */
@ActivityScoped
class MainPresenter @Inject constructor() : MainContract.Presenter {
    companion object {
        const val TAG = "MainPresenter"
    }

    override fun start(view: MainContract.View) {
        Log.e(TAG, "start")
    }

    override fun stop() {
        Log.e(TAG, "stop")
    }
}