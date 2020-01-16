package com.example.foodapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.foodapp.R
import com.example.foodapp.data.repository.RecipesRepository
import com.example.movieapp.data.api.APIClient
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = getViewModel()
        viewModel.getRecipeList("burger")
        viewModel.recipeList.observe(this, Observer {
            for (i in 0 until it.size) {
                println(it[3])
            }
        })



    }

    private fun getViewModel() : MainActivityViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel() as T
            }

        })[MainActivityViewModel::class.java]
    }
}
