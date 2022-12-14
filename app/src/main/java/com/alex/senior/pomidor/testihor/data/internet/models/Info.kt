package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class Info(@SerializedName("seed")
                val seed: String = "",
                @SerializedName("page")
                val page: Int = 0,
                @SerializedName("results")
                val results: Int = 0,
                @SerializedName("version")
                val version: String = "")