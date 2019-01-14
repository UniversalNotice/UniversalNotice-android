package com.depromeet.universalnotice.repository

import com.depromeet.universalnotice.api.UserApi

interface CreateRepository{

}

class CreateRepositoryImpl(private val api: UserApi) : CreateRepository{

}