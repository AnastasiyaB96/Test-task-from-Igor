package com.alex.senior.pomidor.testihor.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [EntityUser::class],
    version = UsersDatabase.USERS_DB_VERSION
)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): DaoUsers

    companion object {
        const val USERS_DB_VERSION = 1
        private var INSTANCE: UsersDatabase? = null

        fun getDatabase(context: Context): UsersDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UsersDatabase::class.java,
                "_users"
            ).build().also { INSTANCE = it }
        }
    }
}
