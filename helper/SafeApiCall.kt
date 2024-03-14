package com.example.mytestapplication.helper

import org.json.JSONObject
import retrofit2.Response

open class SafeApiCAll {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): ApiState<T> {

        return try {
            val response = call.invoke()
            if (response.isSuccessful)
                ApiState.Success(response.body()!!)
            else
                ApiState.ApiError(
                    errorResponse(
                        JSONObject(
                            response.errorBody()?.string() ?: ""
                        )
                    )
                )
        } catch (e: Exception) {
            ApiState.Error(Exception("$errorMessage: ${e.message}"))
        }
    }

    suspend fun <T : Any> identitySafeApiCall(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): ApiState<T> {

        return try {
            val response = call.invoke()
            if (response.isSuccessful)
                ApiState.Success(response.body()!!)
            else
                ApiState.ApiError(response.errorBody()?.string() ?: "")
        } catch (e: Exception) {
            ApiState.Error(Exception("$errorMessage: ${e.message}"))
        }
    }

    private fun errorResponse(obj: JSONObject): String {
        return obj.optString("message")
    }
}