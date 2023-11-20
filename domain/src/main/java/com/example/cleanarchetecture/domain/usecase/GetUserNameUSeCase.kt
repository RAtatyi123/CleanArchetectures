package com.example.cleanarchetecture.domain.usecase
import com.example.cleanarchetecture.domain.models.UserName
import com.example.cleanarchetecture.domain.repository.UserRepository

class GetUserNameUSeCase(private  val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}
