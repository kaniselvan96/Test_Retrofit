package com.example.test_retrofit

import retrofit2.Call

class Repository(private val api: SimpleApi) : SafeApiRequest() {

     suspend fun getData() = apiRequest { api.getData() }
}