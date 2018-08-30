package com.example.yonyo.templateproject.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yonyo.templateproject.R
import com.example.yonyo.templateproject.playground.KotlinBox
import com.example.yonyo.templateproject.playground.JavaBox
import com.example.yonyo.templateproject.playground.RedBox

class PlaygroundFragment : Fragment(){

    companion object {
        fun newInstance() : PlaygroundFragment{
            return PlaygroundFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_playground, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kotlinBox: KotlinBox<RedBox> = KotlinBox()
        kotlinBox.response = RedBox()

        val javaBox: JavaBox<RedBox> = JavaBox()
        javaBox.response = RedBox()

        kotlinBox.let {
            println("Response Kotlin : "+it.response?.color)
        }

        javaBox.let {
            println("Response java : "+it.response.color)
        }

    }

}