package com.example.mytestapplication.helper

import retrofit2.Response

class AuthRepository(networkConnectionInterceptor: NetworkConnectionInterceptor) : SafeApiCAll() {

    private val service = RetrofitInstance.getRetrofitInstance(
        networkConnectionInterceptor, Urls.BASE_URL
    ).create(APIServices::class.java)

    suspend fun getUserdata(
    ): ApiState<UserdDataClass> {
        return safeApiCall({
            service.getUserData()
        }, "Some Error Occurred")
    }
}