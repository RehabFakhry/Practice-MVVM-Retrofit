package com.example.util

import com.example.model.JokeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//responsible about endPoint...
interface JokeApiService{

    @GET("joke/Any")
    fun getRandomJoke() : Single<JokeResponse>
}

//responsible about api and only write once..
// responsible about getting api response by using retrofit2 and write code instead of you...
object API{
    private const val BASE_URL = "https://v2.jokeapi.dev/"
    //object retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val apiService = retrofit.create(JokeApiService::class.java)!!
}
