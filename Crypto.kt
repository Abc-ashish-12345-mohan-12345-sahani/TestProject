package com.example.mytestapplication

import com.google.gson.annotations.SerializedName

data class Crypto(@SerializedName("wallet")
                  val wallet: String = "",
                  @SerializedName("coin")
                  val coin: String = "",
                  @SerializedName("network")
                  val network: String = "")