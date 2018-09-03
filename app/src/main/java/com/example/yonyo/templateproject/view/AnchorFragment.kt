package com.example.yonyo.templateproject.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yonyo.templateproject.R

class AnchorFragment : Fragment() {

    companion object {
        fun newInstance() : AnchorFragment{
            return AnchorFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_anchor, container, false)
    }
}