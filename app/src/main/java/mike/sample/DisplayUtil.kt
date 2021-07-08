package mike.sample

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/6/9
 * @description:
 */
object DisplayUtil {


    fun getPhysicalScreenSize(context: Context): Float {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        windowManager.defaultDisplay.getRealSize(point)
        val displayMetrics = context.resources.displayMetrics
        val densityDpi = displayMetrics.densityDpi
        val x = (point.x / displayMetrics.xdpi).pow(2)
        val y = (point.y / displayMetrics.ydpi).pow(2)
        return sqrt(x + y)
    }

    fun dumpDisplayInfo(context: Context): String {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val realSize = Point()
        windowManager.defaultDisplay.getRealSize(realSize)
        val displayMetrics = context.resources.displayMetrics
        val x = (realSize.x / displayMetrics.xdpi).pow(2)
        val y = (realSize.y / displayMetrics.ydpi).pow(2)
        val physicalScreenSize =  sqrt(x + y)
        return "分辨率： ${displayMetrics.widthPixels} * ${displayMetrics.heightPixels}, " +
                "density: ${displayMetrics.density}, densityDpi = ${displayMetrics.densityDpi}, " +
                "scaledDensity: ${displayMetrics.scaledDensity}, physicalScreenSize = $physicalScreenSize"
//        return "$displayMetrics,  physicalScreenSize = $physicalScreenSize"
    }
}