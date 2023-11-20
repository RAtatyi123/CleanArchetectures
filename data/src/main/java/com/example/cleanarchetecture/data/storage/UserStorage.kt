package com.example.cleanarchetecture.data.storage

import com.example.cleanarchetecture.data.storage.models.User


interface UserStorage {

    fun save(saveUserNameParam: User): Boolean

    fun getName(): User

}