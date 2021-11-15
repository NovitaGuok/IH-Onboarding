package com.example.ihonboarding.feature.login.data_source.local

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.ihonboarding.util.USER_PREF_NAME
import javax.inject.Inject

class SessionManager @Inject constructor(private val context: Context) : AuthLocalDataSource {
    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    private val pref = EncryptedSharedPreferences.create(
        USER_PREF_NAME,
        mainKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun getToken(): String? {
        return pref.getString("token", "")
    }

    override fun getExpiresAt(): String? {
        return pref.getString("exp", "")
    }

    override fun saveSession(token: String, expAt: String) {
        return pref.edit {
            putString("token", token)
            putString("exp", expAt)
        }
    }

    override fun deleteSession() {
        return pref.all.clear()
    }

}