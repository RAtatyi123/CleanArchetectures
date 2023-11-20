package com.example.cleanarchetecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchetecture.domain.models.SaveUserNameParam
import com.example.cleanarchetecture.domain.models.UserName
import com.example.cleanarchetecture.domain.usecase.GetUserNameUSeCase
import com.example.cleanarchetecture.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserNameUSeCase: GetUserNameUSeCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ): ViewModel() {

    var resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM created")
        super.onCleared()
    }





    fun save(text : String){
        val params = SaveUserNameParam(name = text, lastname = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $resultData"
    }
    fun load() {
        val userName: UserName = getUserNameUSeCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }

}