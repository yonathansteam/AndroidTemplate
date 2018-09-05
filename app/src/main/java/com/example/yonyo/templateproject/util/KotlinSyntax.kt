package com.example.yonyo.templateproject.util

import com.example.yonyo.templateproject.playground.JavaBox
import com.example.yonyo.templateproject.playground.KotlinBox
import com.example.yonyo.templateproject.playground.RedBox

class KotlinSyntax {

    val kotlinBox: KotlinBox<RedBox> = KotlinBox()

    val javaBox: JavaBox<RedBox> = JavaBox()

    fun addInstance(){
        kotlinBox.response = RedBox()
        javaBox.response = RedBox()

    }

    fun test(){
        addInstance()

        with(kotlinBox.response){
            this?.color
        }

        kotlinBox.response?.run {
            this.color
        }

        kotlinBox.response.let {

        }

        kotlinBox.let {
            println("Response Kotlin : "+it.response?.color)
        }

        javaBox.let {
            println("Response java : "+it.response.color)
        }
    }

}