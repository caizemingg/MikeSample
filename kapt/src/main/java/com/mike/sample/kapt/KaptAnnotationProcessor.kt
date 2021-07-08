package com.mike.sample.kapt

import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/1/6
 * @description:
 */
@AutoService(Processor::class)
class KaptAnnotationProcessor: AbstractProcessor() {

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        TODO("Not yet implemented")
    }
}