package com.depromeet.universalnotice.api

import io.reactivex.Single
import okhttp3.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi{

    @POST("user/update")
    fun postUserToken(
        @Query("pushToken")token:String,
        @Query("uuid")uuid:String
    ):Single<Response>

}