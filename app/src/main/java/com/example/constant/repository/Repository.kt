package com.example.constant.repository

import androidx.lifecycle.MutableLiveData
import com.example.constant.model.MoviesList
import com.example.constant.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    val moviesList = MutableLiveData<MoviesList>()
    fun makeApiCall(): MutableLiveData<MoviesList>{
        val retrofitService = RetrofitService.create().getMovieList()

        retrofitService.enqueue(object : Callback<MoviesList>
        {
            override fun onResponse(call: Call<MoviesList>, response: Response<MoviesList>) {
                if(response.body() != null) {
                    moviesList.value = response.body()
                }
            }
            override fun onFailure(call: Call<MoviesList>, t: Throwable) {

            }
        })
        return moviesList
    }
}