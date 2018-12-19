package com.depromeet.universalnotice.model

data class Alarm(
    val title: String,
    val time: String,
    val time_interval: String,
    val isEnable : Boolean
//    val week
)

