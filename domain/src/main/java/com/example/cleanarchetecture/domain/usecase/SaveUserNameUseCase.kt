package com.example.cleanarchetecture.domain.usecase

import com.example.cleanarchetecture.domain.models.SaveUserNameParam
import com.example.cleanarchetecture.domain.models.UserName
import com.example.cleanarchetecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val oldusername = userRepository.getName()
        if (oldusername.firstName == param.name) {
            return true
        }
        val result: Boolean = userRepository.saveName(savename = param)
        return result
    }
}