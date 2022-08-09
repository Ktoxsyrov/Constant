package com.example.constant.repository

import com.example.constant.model.MoviesList
import com.example.constant.retrofit.RetrofitService
import retrofit2.await

object Repository {

    suspend fun makeApiCall(): MoviesList{
        val retrofitService = RetrofitService.create().getMovieList()
        return retrofitService.await()
    }



}