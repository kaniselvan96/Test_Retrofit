package com.example.test_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL ="https://jsonplaceholder.typicode.com/"

    val instance: SimpleApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        retrofit.create(SimpleApi::class.java)
    }
}