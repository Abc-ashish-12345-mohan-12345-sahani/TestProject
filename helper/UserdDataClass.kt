package com.example.mytestapplication.helper

import com.example.mytestapplication.UsersItem
import com.google.gson.annotations.SerializedName

data class UserdDataClass(@SerializedName("total")
                          val total: Int = 0,
                          @SerializedName("limit")
                          val limit: Int = 0,
                          @SerializedName("skip")
                          val skip: Int = 0,
                          @SerializedName("users")
                          val users: List<UsersItem>?)