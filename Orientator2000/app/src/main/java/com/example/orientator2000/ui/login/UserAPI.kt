package com.example.orientator2000.ui.login

import android.telecom.Call
import com.example.orientator2000.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @POST("/auth/login")
    fun search(@Body user: User): Call<User>

}