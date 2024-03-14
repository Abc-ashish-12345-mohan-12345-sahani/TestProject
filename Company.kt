package com.example.mytestapplication

import com.google.gson.annotations.SerializedName

data class Company(@SerializedName("address")
                   val address: Address,
                   @SerializedName("name")
                   val name: String = "",
                   @SerializedName("department")
                   val department: String = "",
                   @SerializedName("title")
                   val title: String = "")