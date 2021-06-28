package com.example.test_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_a.*
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
//
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = linearLayoutManager
//
//        getMyData()

        val transition = supportFragmentManager.beginTransaction()

        val fragmentA = FragmentA()
        transition.replace(R.id.fragment_container, fragmentA).commit()

        bt_fragmentA.setOnClickListener{
            transition.replace(R.id.fragment_container, fragmentA).commit()
        }

        val fragmentB = FragmentB()
        bt_fragmentB.setOnClickListener {
           transition.replace(R.id.fragment_container, fragmentB).commit()
        }


//    private fun getMyData(){
//        val retrofitBuilder = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .build()
//                .create(SimpleApi::class.java)
//
//        val retrofitData = retrofitBuilder.getData()
//
//        retrofitData.enqueue(object : Callback<List<DataModelItem>?> {
//            override fun onResponse(call: Call<List<DataModelItem>?>, response: Response<List<DataModelItem>?>) {
//                val responseBody = response.body()!!
//                println("Data: $responseBody")
//
//                recyclerAdapter = RecyclerAdapter(baseContext, responseBody)
//                recyclerAdapter.notifyDataSetChanged()
//                recyclerView.adapter = recyclerAdapter
//
//            }
//
//            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
//               println("Error: Failed 1234")
//            }
//        })
//
    }
}