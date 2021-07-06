package com.example.test_retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.*


class FragmentB : Fragment() {

    private lateinit var viewModel: FragmentViewModel
    private lateinit var factory: FragmentViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = SimpleApi()
        val repository = Repository(api)

        factory = FragmentViewModelFactory(repository)

        viewModel= ViewModelProvider(this, factory).get(FragmentViewModel::class.java)
        viewModel.getMyData()
        viewModel.responses.observe(viewLifecycleOwner, Observer { responses ->
            recyclerView_B.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RecyclerAdapter(responses)
            }
        })
    }

}