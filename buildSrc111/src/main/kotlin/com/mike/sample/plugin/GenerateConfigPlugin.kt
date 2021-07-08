package com.mike.sample.plugin

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import org.gradle.api.Plugin
import org.gradle.api.Project



/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/1/6
 * @description:
 */
class GenerateConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
//        val greeterClass = ClassName("", "Greeter")
//        val file = FileSpec.builder("", "HelloWorld")
//            .addType(TypeSpec.classBuilder("Greeter")
//                .primaryConstructor(FunSpec.constructorBuilder()
//                    .addParameter("name", String::class)
//                    .build())
//                .addProperty(
//                    PropertySpec.builder("name", String::class)
//                    .initializer("name")
//                    .build())
//                .addFunction(FunSpec.builder("greet")
//                    .addStatement("println(%P)", "Hello, \$name")
//                    .build())
//                .build())
//            .addFunction(FunSpec.builder("main")
//                .addParameter("args", String::class, VARARG)
//                .addStatement("%T(args[0]).greet()", greeterClass)
//                .build())
//            .build()
//
//        file.writeTo(System.out)

//        if (project.plugins.hasPlugin(AppPlugin::class.java)) {
//
//        }
//        target.extensions.getByType(AppExt)
    }
}