package kiwi.app.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SmoothiesService {
    // TODO: CHANGE THIS WHEN U GET DOMAIN
    private val BASE_URL = "http://10.0.2.2:8080"

    fun getSmoothiesService(): SmoothiesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SmoothiesApi::class.java)
    }
}