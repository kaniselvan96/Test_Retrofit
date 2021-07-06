package com.example.test_retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts")
    suspend fun getData(): Response<List<DataModelItem>>

    companion object {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"

       operator fun invoke() : SimpleApi {
            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(SimpleApi::class.java)

        }
    }
}