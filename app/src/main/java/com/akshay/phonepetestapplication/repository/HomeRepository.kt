package com.akshay.phonepetestapplication.repository

import com.akshay.phonepetestapplication.entities.MovieData
import com.akshay.phonepetestapplication.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getMovieList(): Flow<NetworkResult<MovieData>>

}