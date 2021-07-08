plugins {
    id("com.android.application")
    id("com.alibaba.arouter")
//    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
//    id("generate_config_bean.dss.cvte.plugin")
}

val MYOU_KEY: String by project
val KEY_STORE_FILE_510: String by project
val KEY_STORE_PASSWORD_OS: String by project
val KEY_ALIAS_OS: String by project
val KEY_PASSWORD_OS: String by project


android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "mike.sample"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        ndk?.abiFilter("armeabi-v7a")
//        ndk?.abiFilter("arm64-v8a")
//        multiDexEnabled = true
    }

//    val JOB_BASE_NAME = System.getenv("JOB_BASE_NAME")
//    val MH_VERSION_NAME = System.getenv("MH_VERSION_NAME")
    applicationVariants.all {

        println("jenkinsAppOutputPath = $name")
        // 修改APK输出路径为app
        val apkOutputPath = project.buildDir.absolutePath
        val jenkinsAppOutputPath = apkOutputPath.replace("whiteboard", "app")
        // 清空jenkinsAppOutputPath目录文件
        val file = File(jenkinsAppOutputPath)
        if (file.exists()) {
            file.deleteRecursively()
        }
        packageApplicationProvider.get()
        val dir = packageApplicationProvider?.get()?.outputDirectory?.get()?.dir("$jenkinsAppOutputPath/outputs/apk/")
        packageApplicationProvider?.get()?.outputDirectory?.let {
            it.set(dir)
        }
//        outputs.all{
//            val dest = File("${outputFile.parentFile.absolutePath}${JOB_BASE_NAME}_${outputFile.name}_${JOB_BASE_NAME}")
//            outputFile.renameTo(dest)
//        }
    }
}

project.task("TestTest") {
    println(File("config.json").absolutePath)

}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.10")

//    implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
//    implementation("com.android.support:appcompat-v7:27.1.1")
//    implementation("com.android.support.constraint:constraint-layout:1.1.0")
//    testImplementation("junit:junit:4.12")
//    androidTestImplementation("com.android.support.test:runner:1.0.2")
//    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")

//    implementation Version.kotlin
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
//    implementation A.androidPlugin
//    implementation(A.androidPlugin) {
//        exclude(module = "drive")
//    }
//    implementation(C.androidPlugin)
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("com.google.dagger:hilt-android:2.28-alpha")
    implementation("androidx.annotation:annotation:1.1.0")
//    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")

    implementation("com.alibaba:arouter-api:1.5.1")
    kapt("com.alibaba:arouter-compiler:1.5.1")


    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    implementation(project(":mylibrary"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0")

    compileOnly(project(":login-component-api"))
//    runtimeOnly(project(":login-component-impl"))
//    implementation(project(":login-component-impl"))

}