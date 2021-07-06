package com.example.test_retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_a.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLStreamHandlerFactory

class FragmentA : Fragment() {

    private lateinit var viewModel: FragmentViewModel
    private lateinit var factory: FragmentViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = SimpleApi()
        val repository = Repository(api)

        factory = FragmentViewModelFactory(repository)

        viewModel= ViewModelProvider(this, factory).get(FragmentViewModel::class.java)
        viewModel.getMyData()
        viewModel.responses.observe(viewLifecycleOwner, Observer { responses ->
            recyclerView_A.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RecyclerAdapter(responses)
            }
        })
    }

}