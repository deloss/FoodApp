package com.example.foodapp.data.vo


import com.google.gson.annotations.SerializedName

data class Recipe(
    val id: Int,
    val image: String,
    val imageUrls: List<String>,
    val readyInMinutes: Int,
    val title: String
)