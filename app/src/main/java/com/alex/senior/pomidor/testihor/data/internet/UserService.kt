package com.alex.senior.pomidor.testihor.data.internet

import com.alex.senior.pomidor.testihor.data.internet.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("?inc=name,picture,location, phone, dob&results=10")
    fun getUsers(): Call<ResponseModel>
}