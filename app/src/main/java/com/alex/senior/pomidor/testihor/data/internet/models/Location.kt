package com.alex.senior.pomidor.testihor.data.internet.models

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("country")
                    val country: String = "",
                    @SerializedName("city")
                    val city: String = "",
                    @SerializedName("street")
                    val street: Street,
                    @SerializedName("timezone")
                    val timezone: Timezone,
                    @SerializedName("postcode")
                    val postcode: String = "",
                    @SerializedName("coordinates")
                    val coordinates: Coordinates,
                    @SerializedName("state")
                    val state: String = "")