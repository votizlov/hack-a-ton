package com.example.orientator2000.ui.login

import android.telecom.Call

interface UserAPI {
    @GET("/auth/login")
fun search(@Body user: User): Call<User>

}