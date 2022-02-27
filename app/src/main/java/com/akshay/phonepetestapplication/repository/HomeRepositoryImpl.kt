package com.akshay.phonepetestapplication.repository

import com.akshay.phonepetestapplication.entities.MovieData
import com.akshay.phonepetestapplication.network.BaseApiResponse
import com.akshay.phonepetestapplication.network.NetworkResult
import com.akshay.phonepetestapplication.network.api.MoviesContentAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val moviesContentAPI: MoviesContentAPI,
) : HomeRepository, BaseApiResponse() {
    override suspend fun getMovieList(): Flow<NetworkResult<MovieData>> = flow {
        emit(
            safeApiCall {
                moviesContentAPI.getMoviesData(
                )
            }
        )
    }.flowOn(Dispatchers.IO)

}