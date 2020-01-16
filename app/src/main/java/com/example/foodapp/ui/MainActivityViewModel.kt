package com.example.foodapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repository.NetworkState
import com.example.foodapp.data.repository.RecipesRepository
import com.example.foodapp.data.vo.Recipe
import com.example.movieapp.data.api.APIClient
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel : ViewModel() {

    private val repository = RecipesRepository(APIClient.getClient(), CompositeDisposable())

    fun getRecipeList(query : String) {
        repository.fetchRecipes(query)
    }

    val recipeList = repository.recipesList
    val networkState = repository.networkState

}