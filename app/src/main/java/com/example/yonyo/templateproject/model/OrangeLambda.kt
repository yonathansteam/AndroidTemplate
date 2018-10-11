package com.example.yonyo.templateproject.model

class OrangeLambda {

    var name: (() -> String) = {""}
    var consumerName: ((String) -> Unit)? = null

    fun triggerLambda(){
        name = { "5" }
        name.invoke()
    }

    fun testConsumer(){
        consumerName?.invoke("")
    }

}