package com.example.cleanarchetecture.data.repository

import com.example.cleanarchetecture.data.storage.models.User
import com.example.cleanarchetecture.data.storage.UserStorage
import com.example.cleanarchetecture.domain.models.SaveUserNameParam
import com.example.cleanarchetecture.domain.models.UserName
import com.example.cleanarchetecture.domain.repository.UserRepository

private const val SHARED_PREF_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstname"
private const val KEY_LAST_NAME = "lastname"
private const val DEFAULT_NAME = "Default Last Name"


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

         val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.getName()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstname, lastName = user.lastname)
    }
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstname = saveParam.name, lastname = saveParam.lastname)
    }

}