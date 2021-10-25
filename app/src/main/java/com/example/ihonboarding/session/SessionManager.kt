package com.example.ihonboarding.session

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.domain.model.AuthToken
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(private val authTokenDao: AuthTokenDao) {
    private val _cachedToken = MutableLiveData<AuthToken?>()
    val cachedToken: LiveData<AuthToken?> get() = _cachedToken

    fun login(newValue: AuthToken) {
        Timber.d("auth: setting new value")
        setValue(newValue)
    }

    fun logout() {
        Timber.d("logout: nullifying the token")
        CoroutineScope(Dispatchers.IO).launch {
            var errorMsg: String? = null
            try {
                _cachedToken.value!!.id?.let {
                    authTokenDao.nullifyToken(it)
                } ?: throw CancellationException("Token error. Logging out user.")
            } catch (e: CancellationException) {
                Timber.e("logout: ${e.message}")
                errorMsg = e.message
            } catch (e: Exception) {
                Timber.e("logout: ${e.message}")
                errorMsg = errorMsg + "\n" + e.message
            } finally {
                errorMsg?.let {
                    Timber.e("logout: $errorMsg")
                }
                Timber.d("logout: final")
                setValue(null)
            }
        }
    }

    private fun setValue(newValue: AuthToken?) {
        CoroutineScope(Dispatchers.Main).launch {
            if (_cachedToken.value != newValue) _cachedToken.value = newValue
        }
    }
}