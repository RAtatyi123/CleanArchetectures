package com.example.cleanarchetecture.data.storage.sharedPrefs

import android.content.Context
import com.example.cleanarchetecture.data.storage.UserStorage
import com.example.cleanarchetecture.data.storage.models.User


private const val SHARED_PREF_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstname"
private const val KEY_LAST_NAME = "lastname"
private const val DEFAULT_LAST_NAME = "Default Last Name"
private const val DEFAULT_FIRST_NAME = "Default first Name"

class SharedPrefUserStorage(context: Context): UserStorage {


    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstname).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastname).apply()
        return true
    }

    override fun getName(): User {
        val firstname = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastname = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return User(firstname = firstname, lastname = lastname)
    }
}

