package com.example.orientator2000.ui

import com.example.orientator2000.ui.login.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private final val BASE_URL = "http://demo3161256.mockable.io/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    fun createUserAPI(): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}