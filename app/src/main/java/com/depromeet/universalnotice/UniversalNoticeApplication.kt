package com.depromeet.universalnotice

import android.app.Application
import androidx.annotation.NonNull
import com.depromeet.universalnotice.common.PreferencesManager
import com.depromeet.universalnotice.firebase.CustomFirebaseMessagingService
import com.google.firebase.iid.FirebaseInstanceId

class UniversalNoticeApplication : Application() {
    @NonNull
    private var universalNoticeApplication : UniversalNoticeApplication? = null

    override fun onCreate() {
        super.onCreate()
        universalNoticeApplication = this
        //        sAnalytics = GoogleAnalytics.getInstance(this);
        setPreferences()
    }

    fun setPreferences() {
        PreferencesManager.setManager(this)
        val fcmToken = PreferencesManager.getFcmToken()

        if (fcmToken?.isEmpty()!!) {
            PreferencesManager.setFcmToken(FirebaseInstanceId.getInstance().getToken()!!)
        }
    }

}