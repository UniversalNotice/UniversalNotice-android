package com.depromeet.universalnotice.di

import com.depromeet.universalnotice.repository.MainListRepository
import com.depromeet.universalnotice.repository.MainListRepositoryImpl
import com.depromeet.universalnotice.ui.mainlist.MainListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val mainListModule = module {

    factory {
        MainListRepositoryImpl(get()) as MainListRepository
    }

    viewModel {
        MainListViewModel(get())
    }
}