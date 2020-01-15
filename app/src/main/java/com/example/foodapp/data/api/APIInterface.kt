package com.example.movieapp.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {

    @GET("recipes/search")
    fun getRecipes(query : String) : Single<Void> //Replace Void with return type

}