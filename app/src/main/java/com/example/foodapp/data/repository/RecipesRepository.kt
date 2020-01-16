package com.example.foodapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.data.vo.Recipe
import com.example.movieapp.data.api.APIClient
import com.example.movieapp.data.api.APIInterface
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecipesRepository(private val apiClient : APIInterface, private val compositeDisposable : CompositeDisposable) {

    private val _recipesList = MutableLiveData<List<Recipe>>()
    val recipesList : LiveData<List<Recipe>>
        get() = _recipesList

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState : LiveData<NetworkState>
        get() = _networkState


    fun fetchRecipes(query : String) {
        _networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(apiClient.getRecipes(query).subscribeOn(Schedulers.io()).subscribe(
            {
                _recipesList.postValue(it)
                _networkState.postValue(NetworkState.LOADED)
            },
            {
                _networkState.postValue(NetworkState.ERROR)
                Log.e("RecipesRepository", it.message)
            }
        ))

    }

}