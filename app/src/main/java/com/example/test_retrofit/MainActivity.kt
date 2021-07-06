package com.example.test_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

//    private lateinit var recyclerAdapter: RecyclerAdapter
//    private var linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = linearLayoutManager
//
//        getMyData()


        val fragmentA = FragmentA()
        val fragmentB = FragmentB()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentA)
                .commit()

        bt_fragmentA.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA).commit()
        }

        bt_fragmentB.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentB).commit()
        }

    }

//    private fun getMyData(){
//
//        val simpleApi = SimpleApi.create().getData()
//        simpleApi.enqueue(object : Callback<List<DataModelItem>?> {
//            override fun onResponse(call: Call<List<DataModelItem>?>, response: Response<List<DataModelItem>?>) {
//                val responseBody = response.body()!!
//                recyclerAdapter = RecyclerAdapter(responseBody)
//                recyclerView.adapter = recyclerAdapter
//            }
//
//            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
//                println("Error: Failed 1234")
//            }
//        })
//
//    }
}