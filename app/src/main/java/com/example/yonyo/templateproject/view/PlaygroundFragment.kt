package com.example.yonyo.templateproject.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yonyo.templateproject.R
import com.example.yonyo.templateproject.model.Mango
import com.example.yonyo.templateproject.playground.KotlinBox
import com.example.yonyo.templateproject.playground.JavaBox
import com.example.yonyo.templateproject.playground.RedBox
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.fragment_playground.*
import java.util.*

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

        recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter : FastItemAdapter<Mango> = FastItemAdapter()
        recycler_view.adapter = adapter

        val mango : List<Mango> = loadMangoes()
        adapter.add(mango)

        val test = HashMap<Key, Any>()
        test.put(Key("Senin"), "tanggal 1")
        test.put(Key("Selasa"), "tanggal 2")
        test[Key("Rabu")] = "tanggal 3"

        println("Get value from hashmap : "+test.get(Key("Senin")))

        val kotlinBox: KotlinBox<RedBox> = KotlinBox()
        kotlinBox.response = RedBox()

        val javaBox: JavaBox<RedBox> = JavaBox()
        javaBox.response = RedBox()

        val str = "100"
        val result = str.let {
            print(this) // Receiver
            print(it) // Argument
            42 // Block return value
        }

        println("Result :  $result")

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

    private fun loadMangoes() : List<Mango>{
        val mango = arrayListOf<Mango>()
        mango.add(Mango("mangga merah", "warna merah"))
        mango.add(Mango("mangga kuning", "warna kuning"))
        mango.add(Mango("mangg hijau", "warna hijau"))
        return mango
    }

}