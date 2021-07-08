package mike.sample

import android.app.Application
import android.os.Environment
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import mike.sample.plugin.PluginManager

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/12
 * @description:
 */
@HiltAndroidApp
class AppApplication : Application() {

    companion object {
        const val TAG = "AppApplication"
    }

    override fun onCreate() {
        super.onCreate()
        val pluginManager = PluginManager(this)
        pluginManager.loadPlugin("${Environment.getExternalStorageDirectory().absolutePath}/plugina-debug.apk")

//        val forName = Class.forName("mike.sample.MainPresenter")
//        registerActivityLifecycleCallbacks
    }
}