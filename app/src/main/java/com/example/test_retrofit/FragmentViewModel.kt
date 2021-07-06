package com.example.test_retrofit

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class FragmentViewModel(private val repository: Repository): ViewModel() {

    private lateinit var job: Job

    private val _responses = MutableLiveData<List<DataModelItem>>()
    val responses : LiveData<List<DataModelItem>>
        get() = _responses

    fun getMyData() {
        job = Coroutines.ioThenMain(
                {repository.getData()},
                {_responses.value  = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
