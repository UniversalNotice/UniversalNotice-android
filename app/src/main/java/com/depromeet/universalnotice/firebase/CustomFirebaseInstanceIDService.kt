//package com.depromeet.universalnotice.firebase
//
//import android.util.Log
//import com.google.firebase.iid.FirebaseInstanceIdService
//import com.google.firebase.iid.FirebaseInstanceId
//
//
//
//class CustomFirebaseInstanceIDService: FirebaseInstanceIdService(){
//
//    override fun onTokenRefresh() {
//        // Get updated InstanceID token.
//        val refreshedToken = FirebaseInstanceId.getInstance().token
//        Log.d("RefreshedToken::", "Refreshed token: " + refreshedToken!!)
//    }
//}