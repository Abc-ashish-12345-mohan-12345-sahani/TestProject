package com.example.mytestapplication

import com.google.gson.annotations.SerializedName

data class Address(@SerializedName("address")
                   val address: String = "",
                   @SerializedName("city")
                   val city: String = "",
                   @SerializedName("postalCode")
                   val postalCode: String = "",
                   @SerializedName("coordinates")
                   val coordinates: Coordinates,
                   @SerializedName("state")
                   val state: String = "")