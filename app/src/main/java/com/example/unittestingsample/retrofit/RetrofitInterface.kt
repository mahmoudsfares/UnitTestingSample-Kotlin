package com.example.unittestingsample.retrofit

import com.example.unittestingsample.data.ResponseDTO
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("todos/1")
    suspend fun getData(): ResponseDTO
}