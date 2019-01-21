package com.depromeet.universalnotice

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

class IntroRepository(context: Context) {
    private val preference by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun isExecuted() = preference.getBoolean("executed", false)

    fun setExecuted() = preference.edit {
        putBoolean("executed", true)
    }

}