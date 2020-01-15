package com.example.foodapp.data.vo


import com.google.gson.annotations.SerializedName

data class Recipe(
    val id: Int,
    val image: String,
    @SerializedName("readyInMinutes")
    val readyTime: Int,
    val title: String
)