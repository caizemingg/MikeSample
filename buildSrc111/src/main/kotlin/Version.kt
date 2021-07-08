/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/25
 * @description:
 */
object Version {
    // 应用版本号
    const val MAJOR_VERSION = 5
    const val MINOR_VERSION = 1
    const val PATCH_VERSION = 2

    const val kotlin = "1.3.72"
    const val objectbox = "2.3.4"

    fun getVersionName(): String {
        return System.getenv("MH_VERSION_NAME") ?: "U.$MAJOR_VERSION.$MINOR_VERSION.$PATCH_VERSION"
    }

    fun getVersionCode(): Int {
        val versionCode = System.getenv("MH_VERSION_CODE")
        return if (versionCode != null) {
            Integer.parseInt(versionCode)
        } else {
            99999
        }
    }
}
