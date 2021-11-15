package com.example.ihonboarding.presentation.viewmodel.login

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

    private val _emailValidator = mutableStateOf(false)
    val emailValidator get() = _emailValidator

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
                _state.value = Resource.Error(null, "error")
            }
        }
    }

    fun isUsernameValid(): Boolean {
        return if (_username.value.isEmpty() || _username.value.isNullOrBlank()) {
            _emailValidator.value = true
            false
        }
        else {
            _emailValidator.value = false
            true
        }
    }

    fun isPasswordValid(): Boolean {
        return if (_password.value.isEmpty() || _password.value.isNullOrBlank()) {
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
}