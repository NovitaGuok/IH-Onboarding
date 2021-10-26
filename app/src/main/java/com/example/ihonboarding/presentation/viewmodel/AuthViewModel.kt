package com.example.ihonboarding.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.example.ihonboarding.R
import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import com.example.ihonboarding.domain.model.AuthCredentials
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.domain.model.ResponseType
import com.example.ihonboarding.domain.model.StateResponse
import com.example.ihonboarding.repository.auth.AuthRepository
import com.example.ihonboarding.util.Event
import com.example.ihonboarding.util.Resources
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @Assisted private val SavedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _authCredentials = MutableLiveData<AuthCredentials>()
    val authCredentials: LiveData<AuthCredentials> get() = _authCredentials

    private val _authResult = MutableLiveData<Event<Resources<AuthToken>>>()
    val authResult: LiveData<Event<Resources<AuthToken>>> get() = _authResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authResult.postValue(Event(Resources.loading(null)))
            authRepository.login(
                AuthLoginRequest(email = email, password = password)
            ).collect { _authResult.postValue(Event(it)) }
        }
    }

    fun checkPreviousAuthUser() {
        viewModelScope.launch {
            _authResult.postValue(Event(Resources.loading(null)))
            authRepository.checkPrevAuthUser().collect { _authResult.postValue(Event(it)) }
        }
    }

    fun setLoginFields(email: String?, password: String?) {
        _authCredentials.value = AuthCredentials(email = email, password = password)
    }

    fun isLoginValid(email: String?, password: String?): Boolean {
        if (email.isNullOrEmpty() || email.isNullOrBlank() || password.isNullOrEmpty() || password.isNullOrBlank()) {
            postError(context.getString(R.string.err_blank_email_password))
            return false
        }
        return true
    }

    fun postError(errorMsg: String) {
        _authResult.postValue(
            Event(
                Resources.error(
                    errorMsg,
                    AuthToken(
                        errorResponse = StateResponse(
                            message = errorMsg,
                            errorResponseType = ResponseType.Dialog
                        )
                    )
                )
            )
        )
    }
}