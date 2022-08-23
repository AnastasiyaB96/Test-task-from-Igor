package com.alex.senior.pomidor.testihor.fragment.users

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.alex.senior.pomidor.testihor.data.internet.RetrofitClient
import com.alex.senior.pomidor.testihor.data.internet.UserService
import com.alex.senior.pomidor.testihor.data.internet.models.ResponseModel
import com.alex.senior.pomidor.testihor.room.EntityUser
import com.alex.senior.pomidor.testihor.room.UsersDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Repository это хранилище за которым прячется вся логика получения данных
object RepositoryUsers {
    private val usersService = RetrofitClient.retrofit.create(UserService::class.java)
    lateinit var database: UsersDatabase

    fun initDatabase(context: Context) {
        database = UsersDatabase.getDatabase(context)
    }

    fun downloadNewUsers() {
        usersService.getUsers().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val listUsers = response.body()?.results?.map { it.toUser() }!!
                GlobalScope.launch(Dispatchers.IO) {
                    database.usersDao().addUsers(listUsers)
                }

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.e(RepositoryUsers::class.java.simpleName, t.message ?: "unknown error")
            }
        })
    }

    fun getAllUsersR(): LiveData<List<EntityUser>> {
        return database.usersDao().getAll()
    }
}