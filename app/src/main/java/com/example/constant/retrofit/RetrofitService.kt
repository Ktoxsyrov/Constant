package com.example.constant.retrofit

import com.example.constant.model.MoviesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
        @GET("films.json")
        fun getMovieList(): Call<MoviesList>

        companion object{
                val BASE_URL = "https://raw.githubusercontent.com/constanta-android-dev/intership-wellcome-task/main/"
                fun create(): RetrofitService {
                        val retrofit = Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .baseUrl(BASE_URL)
                                .build()
                        return retrofit.create(RetrofitService::class.java)
                }
        }
}