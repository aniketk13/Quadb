package com.example.quadb

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.example.api.Movies
import com.example.api.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG="HomeViewModel"
class HomeViewModel : ViewModel() {
    private val _movies:MutableLiveData<List<Movies>> = MutableLiveData()
    val movies:LiveData<List<Movies>>
    get() = _movies

fun getMovies(query:String="all"){
    viewModelScope.launch {
            val fetchedmovies=RetrofitInstance.api.getMovies(query)
            _movies.value=fetchedmovies
    }
}
}