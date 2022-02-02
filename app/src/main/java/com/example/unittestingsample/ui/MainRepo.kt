package com.example.unittestingsample.ui

import android.content.Context
import com.example.unittestingsample.R
import com.example.unittestingsample.retrofit.RetrofitInterface
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class MainRepo @Inject constructor(
    private val retrofitInterface: RetrofitInterface,
    @ApplicationContext
    private val appContext: Context
) {

    suspend fun fetchData(): String {
        return try {
            val response = retrofitInterface.getData()
            response.title
        } catch (throwable: Throwable) {
            when(throwable){
                is HttpException ->
                    return throwable.message()
                else ->
                    return appContext.getString(R.string.error_occurred)
            }

        }
    }
}