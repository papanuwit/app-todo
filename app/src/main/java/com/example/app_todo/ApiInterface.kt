package com.example.app_todo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
val BASE_URL = "http://localhost:3000/"
interface ApiInterface {

    @GET("todoList")
    fun getData(): Call<List<MyDataItem>>

    companion object{
     operator   fun invoke():ApiInterface{
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

        }
    }
}