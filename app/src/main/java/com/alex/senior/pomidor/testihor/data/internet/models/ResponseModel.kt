package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(@SerializedName("results")
                         val results: List<ResultsItem>?,
                         @SerializedName("info")
                         val info: Info)