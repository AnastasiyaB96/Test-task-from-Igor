package com.alex.senior.pomidor.testihor.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alex.senior.pomidor.testihor.room.EntityUser.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class EntityUser(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "dateBirth")
    val dateBirth: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    companion object {
        const val TABLE_NAME = "users_table"
    }
}