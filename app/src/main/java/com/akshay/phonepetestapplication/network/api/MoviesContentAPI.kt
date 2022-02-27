package com.akshay.phonepetestapplication.network.api

import com.akshay.phonepetestapplication.entities.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET


interface MoviesContentAPI {

    //Note: API key shouldn't be here. Don't have time to put it somewhere safe
    @GET("/3/movie/now_playing?api_key=38a73d59546aa378980a88b645f487fc")
    suspend fun getMoviesData(
    ): Response<MovieData>

}