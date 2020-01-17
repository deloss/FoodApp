package com.example.movieapp.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "38278c755amshe5f41e2a7230c56p1fecd1jsn3eea0decfe12"
const val HOST_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com"

object APIClient {

    fun getClient() : APIInterface {
        val requestInterceptor = Interceptor {
            chain ->

            val url = chain.request().url().newBuilder().addQueryParameter("x-rapidapi-key", API_KEY).addQueryParameter("x-rapidapi-host", HOST_URL).build()

            val request = chain.request().newBuilder().url(url).build()

            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder().addInterceptor(requestInterceptor).connectTimeout(60, TimeUnit.SECONDS).build()

        return Retrofit.Builder().client(okHttpClient).baseUrl(HOST_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(
            GsonConverterFactory.create()).build().create(APIInterface::class.java)
    }


}

