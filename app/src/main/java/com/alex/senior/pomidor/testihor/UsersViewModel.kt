package com.alex.senior.pomidor.testihor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.senior.pomidor.testihor.fragment.users.RepositoryUsers
import com.alex.senior.pomidor.testihor.room.EntityUser

class UsersViewModel : ViewModel() {
    //при нажатии на элемент списка сюда будут поступать данные о юзере на которого нажали
    val userPickedLiveData: MutableLiveData<EntityUser> = MutableLiveData(EntityUser("", "", "", "", ""))
    fun onUserClicked(user: EntityUser) {
        userPickedLiveData.postValue(user)
    }

    fun downloadNewUsers() {
        RepositoryUsers.downloadNewUsers()
    }

    fun getAllUsers(): LiveData <List<EntityUser>>{
        return RepositoryUsers.getAllUsersR()
    }
}