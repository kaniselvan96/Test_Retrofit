package com.example.test_retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_a.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentA : Fragment() {
    private var recyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var linearLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManager= LinearLayoutManager(activity)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(SimpleApi::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<DataModelItem>?> {
            override fun onResponse(call: Call<List<DataModelItem>?>, response: Response<List<DataModelItem>?>) {
                val responseBody = response.body()!!
                println("Data: $responseBody")

                recyclerAdapter = RecyclerAdapter(responseBody)
                recyclerView.adapter = recyclerAdapter

            }

            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
                println("Error: Failed 1234")
            }
        })

    }
}