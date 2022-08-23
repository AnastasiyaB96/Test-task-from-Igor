package com.alex.senior.pomidor.testihor.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao()
interface DaoUsers {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(entityUser: List<EntityUser>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOneUser(user: EntityUser): Long

    @Delete
    fun deleteUser(user: EntityUser)

    @Query("SELECT * FROM ${EntityUser.TABLE_NAME}")
    fun getAll(): LiveData<List<EntityUser>>
}


