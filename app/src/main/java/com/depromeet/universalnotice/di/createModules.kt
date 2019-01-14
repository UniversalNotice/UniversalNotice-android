package com.depromeet.universalnotice.di

import com.depromeet.universalnotice.repository.CreateRepository
import com.depromeet.universalnotice.repository.CreateRepositoryImpl
import com.depromeet.universalnotice.ui.create.CreateAlarmViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val createModule = module {

    factory {
        CreateRepositoryImpl(get()) as CreateRepository
    }

    viewModel {
        CreateAlarmViewModel()
    }
}