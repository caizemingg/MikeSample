package mike.sample.plugin

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dalvik.system.DexClassLoader
import dalvik.system.PathClassLoader
import kotlinx.android.synthetic.main.activity_main.*
import mike.sample.AboutFragment
import mike.sample.DisplayUtil
import mike.sample.MainContract
import mike.sample.R
import mike.sample.plugin.PluginManager
import javax.inject.Inject


class APluginProxyActivity : AppCompatActivity() {
    companion object {
        const val TAG = "APluginProxyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val className = "com.cvte.plugina.A"
        val className =  "com.cvte.plugina.APluginActivity"
        val dexClassLoader = DexClassLoader(
            "${Environment.getExternalStorageDirectory().absolutePath}/plugina-debug.apk",
            applicationInfo.dataDir, applicationInfo.nativeLibraryDir, classLoader
        )

        val forName = Class.forName(className, true, dexClassLoader)
        forName.newInstance()
        forName.methods.forEach {
            Log.e(TAG, "method name = ${it.name}")
        }

//        val className = "com.cvte.plugina.A"
//        Log.e(PluginManager.TAG, "loadPlugin, path = $path")
//
//        val pathClassLoader = PathClassLoader(path, ClassLoader.getSystemClassLoader())
//        val forName = Class.forName(className, true, pathClassLoader)
//        forName.newInstance()
//        forName.methods.forEach {
//            Log.e(PluginManager.TAG, "method name = ${it.name}")
//        }
        setContentView(R.layout.activity_main)
    }
}