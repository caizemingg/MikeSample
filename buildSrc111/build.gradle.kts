plugins {
    `java-library`
    `kotlin-dsl`
}
//
dependencies {
    implementation("com.android.tools.build:gradle:3.5.3")
    implementation("com.squareup:kotlinpoet:1.7.2")
    implementation(gradleApi())
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    google()
    jcenter()
}


//apply plugin: 'java-library'
//apply plugin: 'kotlin-dsl'
//repositories {
//    google()
//    jcenter()
//}
//dependencies {
//    添加gradle版本
//    implementation 'com.android.tools.build:gradle:3.3.2'
//    添加gradle对应api
//    implementation gradleApi()
//}