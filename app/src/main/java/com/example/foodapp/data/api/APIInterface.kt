package com.example.movieapp.data.api

import com.example.foodapp.data.vo.Recipe
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {

    @GET("recipes/search")
    fun getRecipes(@Query("query") query : String) : Single<List<Recipe>>

}