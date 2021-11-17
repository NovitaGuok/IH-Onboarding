package com.example.ihonboarding.presentation.viewmodel.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.use_case.LoginUseCase
import com.example.ihonboarding.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _state: MutableState<Resource<Token>> = mutableStateOf(Resource.Loading())
    val state: State<Resource<Token>> get() = _state

    private val _username = mutableStateOf("")
    val username get() = _username

    private val _password = mutableStateOf("")
    val password get() = _password

    private val _usernameValidator = mutableStateOf(false)
    val usernameValidator get() = _usernameValidator

    private val _passwordValidator = mutableStateOf(false)
    val passwordValidator get() = _passwordValidator

    fun setUsername(username: String) {
        _username.value = username
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun login() {
        _state.value = Resource.Loading()
        viewModelScope.launch {
            runCatching {
                loginUseCase.invoke(_username.value, _password.value)
            }.onSuccess {
                _state.value = Resource.Success(data = it)
            }.onFailure {
                _state.value = Resource.Error(null, it.toString())
                Log.d("lvw", it.toString())
            }
        }
    }

    private fun isUsernameValid(): Boolean {
        return if (_username.value.isEmpty()) {
            _usernameValidator.value = true
            false
        }

        else {
            _usernameValidator.value = false
            true
        }
    }

    private fun isPasswordValid(): Boolean {
        return if (_password.value.isEmpty()) {
            _passwordValidator.value = true
            false
        }
        else {
            _passwordValidator.value = false
            true
        }
    }

    fun checkValidity(): Boolean {
        if (!isUsernameValid()) return false
        if (!isPasswordValid()) return false

        return true
    }

    fun resetState() {
        _state.value = Resource.Init()
    }
}