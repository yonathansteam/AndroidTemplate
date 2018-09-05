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
import com.example.yonyo.templateproject.util.unwrap
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


        val str = "100"
        val result = str.let {
            print(this) // Receiver
            print(it) // Argument
            42 // Block return value
        }

        println("Result :  $result")

        val nullString: String? = null
        var nonNullString: String? = "not null"


        unwrap(nullString){
            println("First value : $it")
        } otherwise{
            println("First value otherwise")
        }

        unwrap(nonNullString){
            println("Second value : $it")
        }otherwise{
            println("Second valut otherwise ")
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