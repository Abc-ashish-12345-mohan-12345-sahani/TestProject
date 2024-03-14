package com.example.mytestapplication.helper

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface APIServices {

    @GET("/users/")
    suspend fun getUserData(): Response<UserdDataClass>
}