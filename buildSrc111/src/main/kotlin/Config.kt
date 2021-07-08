/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/26
 * @description:
 */
object Config {
    // 依赖本地项目，需要调试依赖库中的代码才打开
    const val implementLocalModule = false

    /**
     * 在jenkins构建
     * @return Boolean
     */
    fun isBuildInJenkins(): Boolean {
        val tag = System.getenv("BUILD_TAG")
        println("****************BUILD_TAG is $tag*****************")
        return tag != null && tag.contains("jenkins")
    }
}