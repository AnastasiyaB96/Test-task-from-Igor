package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class Coordinates(@SerializedName("latitude")
                       val latitude: String = "",
                       @SerializedName("longitude")
                       val longitude: String = "")