package com.example.mytestapplication.helper

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    fun getRetrofitInstance(
        networkConnectionInterceptor: NetworkConnectionInterceptor, baseUrl: String
    ): Retrofit {
        val client = okHTTPClient(networkConnectionInterceptor)
        return Retrofit.Builder().client(client).baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
    }

    private fun okHTTPClient(networkConnectionInterceptor: NetworkConnectionInterceptor): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS).addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).addInterceptor(networkConnectionInterceptor).build()
    }
}