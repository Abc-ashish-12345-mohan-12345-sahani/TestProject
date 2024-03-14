package com.example.mytestapplication

import com.google.gson.annotations.SerializedName

data class Bank(@SerializedName("iban")
                val iban: String = "",
                @SerializedName("cardExpire")
                val cardExpire: String = "",
                @SerializedName("cardType")
                val cardType: String = "",
                @SerializedName("currency")
                val currency: String = "",
                @SerializedName("cardNumber")
                val cardNumber: String = "")