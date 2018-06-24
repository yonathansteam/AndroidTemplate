package com.example.yonyo.templateproject.view.Notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.yonyo.templateproject.R
import kotlinx.android.synthetic.main.activity_notes_list.*

class NotesListActivityKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        val layoutManager = LinearLayoutManager(this)
        rv_notes_list.layoutManager = layoutManager


    }
}
