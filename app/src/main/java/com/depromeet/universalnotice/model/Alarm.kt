package com.depromeet.universalnotice.model

data class Alarm(
    val category: Int, // 알람 종류 (이미지)
    val title: String, // 이름
    val time: String, // 시간
    val ampm: String,
    val isAlarm : Boolean, // 알림인지 푸시인지
    val time_interval_type : String, // 이전, 이후
    val time_interval: String, // 간격
    val dayOfTheWeek: String, // 요일
    val repeitition: Boolean, // true = 매주 , false = 한번
    val isEnable : Boolean // 알람 on..off
)

