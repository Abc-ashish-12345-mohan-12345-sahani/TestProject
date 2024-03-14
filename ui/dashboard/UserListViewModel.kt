package com.example.mytestapplication.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapplication.helper.ApiState
import com.example.mytestapplication.helper.AuthRepository
import com.example.mytestapplication.helper.UserdDataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    val _users = MutableLiveData<ApiState<UserdDataClass>>()
    val userResult: LiveData<ApiState<UserdDataClass>> = _users

    fun getUserData() {
        viewModelScope.launch {
            val response = authRepository.getUserdata()
            withContext(Dispatchers.Main){
                _users.postValue(response)
            }
        }
    }
}