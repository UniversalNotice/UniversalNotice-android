package com.depromeet.universalnotice.model

import java.time.LocalTime

data class Alarm(
    val category: Category, // 알람 종류 (이미지)
    val title: String, // 이름
//    val time: String, // 시간
//    val ampm: String, //오전,오후
    val time : LocalTime,
    val isAlarm: Boolean, // 알림인지 푸시인지
    val beforehand: Boolean, // 이전, 이후
    val interval: Int, // 간격
    val pushStartTime : LocalTime,
    val pushEndTime : LocalTime,
    val dayOfWeek: String, // 요일
    val repeated: Boolean, // true = 매주 , false = 한번
    val level : Level,
    val isEnable: Boolean, // 알람 on..off
    val userId : Int //유저아이디
)

enum class Category {
    SLEEP, TODO, PLAN
}

enum class DayOfWeek {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

enum class Level {
    HIGH, MIDDLE, LOW
}