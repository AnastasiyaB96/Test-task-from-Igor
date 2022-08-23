package com.alex.senior.pomidor.testihor.data.internet.models

import com.alex.senior.pomidor.testihor.room.EntityUser
import com.google.gson.annotations.SerializedName

data class ResultsItem(
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("dob")
    val dob: Dob,
    @SerializedName("name")
    val name: Name,
    @SerializedName("location")
    val location: Location,
    @SerializedName("picture")
    val picture: Picture
) {
    fun toUser(): EntityUser {
        val _name = "${name.title} ${name.first} ${name.last}"
        val _address = "${location.country} ${location.city} ${location.street.name} ${location.street.number}"
        val _dob = dob.date
        val _picture = picture.large
        val _phone = "phone: $phone"
        return EntityUser(_name, _address, _dob, _picture, _phone)
    }
}
