package mike.sample

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInstaller
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.lang.reflect.Method
import java.util.logging.Logger

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/5/11
 * @description:
 */
object PkgUtils {
    const val timeOut = 5L

    /**
     * 应用安装，安卓5.0以上会校验签名是否一致，不一致则会先卸载再安装
     **/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    fun installApk21(context: Context, apkFilePath: String) {
        val apkFile = File(apkFilePath)
        val packageInstaller = context.packageManager.packageInstaller
        val pkgName = getApkPackageName(context, apkFilePath)
//        Logger.d(">>> PkgUtils apk package name:$pkgName")

        val sessionParams = PackageInstaller.SessionParams(
            PackageInstaller.SessionParams.MODE_FULL_INSTALL
        )
        sessionParams.setAppPackageName(pkgName)
        sessionParams.setSize(apkFile.length())
        try {
            //允许低版本安装的原因：在新版本出问题但是来不及修复需要进行版本回退
            val allowDowngrade: Method = PackageInstaller.SessionParams::class.java.getMethod(
                "setAllowDowngrade",
                Boolean::class.javaPrimitiveType
            )
            allowDowngrade.isAccessible = true
            allowDowngrade.invoke(sessionParams, true)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        val sessionId = createSession(packageInstaller, sessionParams)
        if (sessionId != -1) {
            val copySuccess = copyApkFile(packageInstaller, sessionId, apkFilePath, it)
            if (copySuccess) {
                install(context, packageInstaller, sessionId)
            } else {
//                Logger.d(">>> PkgUtils copySuccess = false")
            }
        }
    }

    /**
     * 根据 sessionParams 创建 Session
     **/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    private fun createSession(
        packageInstaller: PackageInstaller,
        sessionParams: PackageInstaller.SessionParams
    ): Int {
        var sessionId = -1
        try {
            sessionId = packageInstaller.createSession(sessionParams)
        } catch (e: IOException) {
            e.printStackTrace()
            throw e
        }
        return sessionId
    }

    /**
     * 将 apk 文件输入 session
     **/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    private fun copyApkFile(
        packageInstaller: PackageInstaller,
        sessionId: Int, apkFilePath: String, pkgName: String
    ): Boolean {
        var success = false
        val apkFile = File(apkFilePath)
        try {
            packageInstaller.openSession(sessionId).use { session ->
                session.openWrite(pkgName, 0, apkFile.length()).use { out ->
                    FileInputStream(apkFile).use { input ->
                        var read: Int
                        val buffer = ByteArray(1024)
                        while (input.read(buffer).also { read = it } != -1) {
                            out.write(buffer, 0, read)
                        }
                        session.fsync(out)
                        success = true
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            throw e
        }
        return success
    }

    /**
     * 最后提交 session，并且设置回调
     **/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    private fun install(context: Context, packageInstaller: PackageInstaller, sessionId: Int) {
        var session: PackageInstaller.Session? = null
        try {
            session = packageInstaller.openSession(sessionId).apply {
                val intent = Intent(context, InstallResultReceiver::class.java)
                val pendingIntent = PendingIntent.getBroadcast(
                    context,
                    1, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                commit(pendingIntent.intentSender)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            throw ex
        } finally {
            session?.close()
        }
    }
}
