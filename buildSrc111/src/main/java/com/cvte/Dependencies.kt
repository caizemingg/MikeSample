package com.cvte

object Version {
    val kotlin = "1.3.72"
    val objectbox = "2.3.4"
}

fun genVersionName(): String {
    val versionName = System.getenv("MH_VERSION_NAME")
    if (versionName != null) {
        return versionName
    } else {
        val properties = java.util.Properties()
        val inputStream = java.io.FileInputStream("./local.properties")
//        = project.rootProject.file('local.properties').newDataInputStream()
        properties.load(inputStream)
        val property = properties.getProperty("MAJOR_VERSION")
        val property1 = properties.getProperty("MINOR_VERSION")

        return "U." + property + "." + property1
    }
}

fun genVersionCode(): Int {
    val versionCode = System.getenv("MH_VERSION_CODE")
    if (versionCode != null) {
        return Integer.parseInt(versionCode)
    } else {
        return 99999
    }
}

fun isBuildInJenkins(): Boolean {
    val tag = System.getenv("BUILD_TAG")
    println("****************BUILD_TAG is $tag*****************")
    return tag != null && tag.contains("jenkins")
}
