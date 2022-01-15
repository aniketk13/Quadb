package com.example.quadb

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.MovieDetail
import com.example.api.Movies
import com.example.api.RetrofitInstance
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _movie: MutableLiveData<MovieDetail> = MutableLiveData()
    val movie: LiveData<MovieDetail>
        get() = _movie
    fun getSelectedMovie(movieId: Int) {
        viewModelScope.launch {
            val url="shows/$movieId"
            val movie=RetrofitInstance.api.getSelectedMovie(url)
            _movie.value=movie
        }
    }
}