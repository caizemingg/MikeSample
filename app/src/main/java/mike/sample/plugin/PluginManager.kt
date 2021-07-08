package mike.sample.plugin

import android.content.Context
import android.util.Log
import dalvik.system.PathClassLoader
import mike.sample.AppApplication

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/10/13
 * @description:
 */
class PluginManager(private val mContext: Context) {

    companion object {
        const val TAG = "PluginManager"
    }

    fun loadPlugin(path: String) {
//        val className = "com.cvte.plugina.A"
//        Log.e(TAG, "loadPlugin, path = $path")
//
//        val pathClassLoader = PathClassLoader(path, ClassLoader.getSystemClassLoader())
//        val forName = Class.forName(className, true, pathClassLoader)
//        forName.newInstance()
//        forName.methods.forEach {
//            Log.e(TAG, "method name = ${it.name}")
//        }

    }
}