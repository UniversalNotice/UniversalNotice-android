package com.depromeet.universalnotice

import android.app.Application
import android.util.Log
import androidx.annotation.NonNull
import com.depromeet.universalnotice.common.PreferencesManager
import com.depromeet.universalnotice.di.appModules
import com.google.firebase.iid.FirebaseInstanceId
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    @NonNull
    private var myApplication : MyApplication? = null

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)

        myApplication = this
        //        sAnalytics = GoogleAnalytics.getInstance(this);
        setPreferences()
    }

    private fun setPreferences() {
        PreferencesManager.setManager(this)
        var fcmToken = PreferencesManager.getFcmToken()
        var uuid =  PreferencesManager.getUuid()


        if (fcmToken?.isEmpty()!!) {
//            PreferencesManager.setFcmToken(FirebaseInstanceId.getInstance().token!!)
            FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
                PreferencesManager.setFcmToken(it.token)
            }
            fcmToken = PreferencesManager.getFcmToken()
        }
        if(uuid?.isEmpty()!!){
            PreferencesManager.setUuid()
            uuid = PreferencesManager.getUuid()
        }

        Log.d("FcmToken_",fcmToken)
        Log.d("UUID_",uuid)
    }
}