package com.example.mytestapplication.helper

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable())
            throw NoInternetException("No Internet")

        val response: Response?

        try {
            response = chain.proceed(chain.request())
        } catch (e: Exception) {
            throw NoInternetException("No Internet")
        }

         return response
    }

    private fun isInternetAvailable (): Boolean {
       val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}

class NoInternetException(e: String) : IOException(e)