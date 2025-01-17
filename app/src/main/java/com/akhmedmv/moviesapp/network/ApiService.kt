package com.akhmedmv.moviesapp.network

import com.akhmedmv.moviesapp.data.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("shows")
    suspend fun getAllMovies() : Response<List<Movies>>
}