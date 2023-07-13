package com.example.moviesapp.network

import com.example.moviesapp.model.Movie
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {
    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>

    companion object{
        var apiService: ApiService? = null
        fun getInstance() : ApiService{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!

            }
        }
    }
