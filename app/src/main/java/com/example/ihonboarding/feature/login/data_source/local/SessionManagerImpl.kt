package com.example.ihonboarding.feature.login.data_source.local

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.ihonboarding.util.Constant.Companion.PREF_EXP
import com.example.ihonboarding.util.Constant.Companion.PREF_NAME
import com.example.ihonboarding.util.Constant.Companion.PREF_TOKEN
import javax.inject.Inject

class SessionManagerImpl @Inject constructor(private val context: Context) : SessionManager {

    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
    private val prefs = EncryptedSharedPreferences.create(
        PREF_NAME,
        mainKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun getToken(): String? {
        return prefs.getString(PREF_TOKEN, "")
    }

    override fun getExp(): String? {
        return prefs.getString(PREF_EXP, "")
    }

    override fun saveSession(token: String, expiredAt: String) {
        return prefs.edit {
            putString("tpken", token)
            putString("exp", expiredAt)
        }
    }

    override fun deleteSession() {
        return prefs.all.clear()
    }
}