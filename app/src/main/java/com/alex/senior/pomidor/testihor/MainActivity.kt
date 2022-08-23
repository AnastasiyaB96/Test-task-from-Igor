package com.alex.senior.pomidor.testihor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alex.senior.pomidor.testihor.fragment.users.RepositoryUsers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RepositoryUsers.initDatabase(this)
    }
}