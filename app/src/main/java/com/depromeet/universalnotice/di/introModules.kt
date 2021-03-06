package com.depromeet.universalnotice.di

import com.depromeet.universalnotice.IntroRepository
import com.depromeet.universalnotice.ui.intro.IntroViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val introModule = module {
    viewModel { (introTextArray: Array<String>, introRepo: IntroRepository) ->
        IntroViewModel(introTextArray, introRepo)
    }
}