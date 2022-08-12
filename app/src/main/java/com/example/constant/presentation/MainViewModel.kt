package com.example.constant.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constant.model.MoviesList
import com.example.constant.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var moviesList = MutableLiveData<MoviesList>()

    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            moviesList.postValue(Repository.makeApiCall())
        }
    }


}