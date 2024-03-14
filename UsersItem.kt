package com.example.mytestapplication

import com.google.gson.annotations.SerializedName

data class UsersItem(@SerializedName("lastName")
                     val lastName: String = "",
                     @SerializedName("gender")
                     val gender: String = "",
                     @SerializedName("university")
                     val university: String = "",
                     @SerializedName("maidenName")
                     val maidenName: String = "",
                     @SerializedName("ein")
                     val ein: String = "",
                     @SerializedName("ssn")
                     val ssn: String = "",
                     @SerializedName("bloodGroup")
                     val bloodGroup: String = "",
                     @SerializedName("password")
                     val password: String = "",
                     @SerializedName("hair")
                     val hair: Hair,
                     @SerializedName("bank")
                     val bank: Bank,
                     @SerializedName("eyeColor")
                     val eyeColor: String = "",
                     @SerializedName("company")
                     val company: Company,
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("email")
                     val email: String = "",
                     @SerializedName("height")
                     val height: Int = 0,
                     @SerializedName("image")
                     val image: String = "",
                     @SerializedName("address")
                     val address: Address,
                     @SerializedName("ip")
                     val ip: String = "",
                     @SerializedName("weight")
                     val weight: Double = 0.0,
                     @SerializedName("userAgent")
                     val userAgent: String = "",
                     @SerializedName("birthDate")
                     val birthDate: String = "",
                     @SerializedName("crypto")
                     val crypto: Crypto,
                     @SerializedName("firstName")
                     val firstName: String = "",
                     @SerializedName("macAddress")
                     val macAddress: String = "",
                     @SerializedName("phone")
                     val phone: String = "",
                     @SerializedName("domain")
                     val domain: String = "",
                     @SerializedName("age")
                     val age: Int = 0,
                     @SerializedName("username")
                     val username: String = "")