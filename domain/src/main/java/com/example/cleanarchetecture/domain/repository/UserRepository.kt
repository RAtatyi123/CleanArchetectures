package com.example.cleanarchetecture.domain.repository

import com.example.cleanarchetecture.domain.models.SaveUserNameParam
import com.example.cleanarchetecture.domain.models.UserName
//реализация через интерфейс UserRepository для data слоя
interface UserRepository {
    fun saveName (savename: SaveUserNameParam) : Boolean
    fun getName(): UserName
}