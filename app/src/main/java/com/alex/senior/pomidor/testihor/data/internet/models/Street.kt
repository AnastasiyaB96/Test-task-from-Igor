package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class Street(@SerializedName("number")
                  val number: Int = 0,
                  @SerializedName("name")
                  val name: String = "")