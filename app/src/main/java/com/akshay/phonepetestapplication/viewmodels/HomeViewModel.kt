package com.akshay.phonepetestapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.akshay.phonepetestapplication.entities.MovieData
import com.akshay.phonepetestapplication.network.NetworkResult
import com.akshay.phonepetestapplication.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : BaseViewModel() {

    private val _movieList = MutableLiveData<MovieData>()
    val movieList: LiveData<MovieData> = _movieList

    init {
        viewModelScope.launch {
            loadMovies()
        }
    }


    private suspend fun loadMovies() {
        homeRepository.getMovieList().collect {
            when (it) {
                is NetworkResult.Success -> {
                    _movieList.value = it.data!!
                }
            }

        }
    }


}