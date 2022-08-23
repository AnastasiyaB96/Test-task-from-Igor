package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class Picture(@SerializedName("thumbnail")
                   val thumbnail: String = "",
                   @SerializedName("large")
                   val large: String = "",
                   @SerializedName("medium")
                   val medium: String = "")