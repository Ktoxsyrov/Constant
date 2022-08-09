package com.example.constant.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.constant.model.MoviesList
import com.example.constant.repository.Repository

class MainViewModel: ViewModel() {

    private var moviesList = MutableLiveData<MoviesList>()

    fun getMovies(): LiveData<MoviesList>{
        moviesList = Repository.makeApiCall()
        return moviesList
    }
}