package com.depromeet.universalnotice.repository

import com.depromeet.universalnotice.api.Api

interface CreateRepository{

}

class CreateRepositoryImpl(private val api: Api) : CreateRepository{

}