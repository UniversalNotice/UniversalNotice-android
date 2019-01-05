package com.depromeet.universalnotice

import com.depromeet.universalnotice.ui.intro.IntroViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val introModule = module {
    viewModel {
        (introTextArray : Array<String>) -> IntroViewModel(introTextArray)
    }
}

val appModules = listOf(introModule)