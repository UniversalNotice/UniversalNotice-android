package com.depromeet.universalnotice.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.provider.Settings
import android.telephony.TelephonyManager
import java.io.UnsupportedEncodingException
import java.lang.RuntimeException
import java.nio.charset.Charset
import java.util.*

class PreferencesManager{
    companion object {

        private lateinit var context:Context
        private val BASE_STORE_PROPERTY_NAME = "pre"
        private val FCM_TOKEN_PROPERTY_NAME = "FCM_TOKEN"
        private val DEVICE_UUID = "UUID"
        private val CACHE_DEVICE_ID = "CacheDeviceID"
        private var pref: SharedPreferences? = null

        fun setManager(context: Context) {
            this.context = context
            if (pref == null) {
                pref = context.getSharedPreferences(
                    BASE_STORE_PROPERTY_NAME,
                    MODE_PRIVATE
                )
            }
        }

        fun getFcmToken(): String? {
            return pref?.getString(FCM_TOKEN_PROPERTY_NAME, "")
        }

        fun setFcmToken(token: String) {
            val editor = pref?.edit()
            editor?.putString(FCM_TOKEN_PROPERTY_NAME, token)
            editor?.apply()
        }

        fun getUuid():String?{
            return pref?.getString(DEVICE_UUID,"")
        }

        fun setUuid(){
            val uuid = generateUuid()
            val editor = pref?.edit()
            editor?.putString(DEVICE_UUID,uuid)
            editor?.apply()
        }

        @SuppressLint("MissingPermission")
        fun generateUuid(): String? {
            val deviceUUID : UUID
            val cacheDeviceID = pref?.getString(CACHE_DEVICE_ID,"")
            if(cacheDeviceID!=""){
                deviceUUID = UUID.fromString(cacheDeviceID)
            }
            else{
                val androidUniqueID = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
                try {
                    if(androidUniqueID != ""){
                        deviceUUID = UUID.nameUUIDFromBytes(androidUniqueID.toByteArray(Charsets.UTF_8))
                    }
                    else{
                        val anotherUniqueID = (context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).getDeviceId()
                        if( anotherUniqueID != null){
                            deviceUUID = UUID.nameUUIDFromBytes(anotherUniqueID.toByteArray(Charsets.UTF_8))
                        }
                        else{
                            deviceUUID = UUID.randomUUID()
                        }
                    }
                }catch (e:UnsupportedEncodingException){
                    throw RuntimeException(e)
                }
            }
            pref!!.edit().putString(CACHE_DEVICE_ID,deviceUUID.toString()).apply()
            return deviceUUID.toString()
        }

    }
}