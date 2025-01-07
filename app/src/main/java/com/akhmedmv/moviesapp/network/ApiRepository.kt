package com.akhmedmv.moviesapp.network

import com.akhmedmv.moviesapp.data.Movies
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMovies(): Response<List<Movies>> = apiService.getAllMovies()

}