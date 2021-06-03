package com.example.test_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts")
    fun getData(): Call<List<DataModelItem>>
}