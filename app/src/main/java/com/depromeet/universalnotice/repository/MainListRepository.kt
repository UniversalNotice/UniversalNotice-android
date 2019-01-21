package com.depromeet.universalnotice.repository

import com.depromeet.universalnotice.api.Api
import io.reactivex.Single
import okhttp3.Response

interface MainListRepository{

    fun postUserToken(token:String,uuid:String) : Single<Response>
}

class MainListRepositoryImpl(private val api: Api) : MainListRepository{
    override fun postUserToken(token: String, uuid: String): Single<Response> {
        return api.postUserToken(token,uuid)
    }
}