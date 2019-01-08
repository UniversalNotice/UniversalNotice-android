package com.depromeet.universalnotice.ui.create

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.util.SingleLiveEvent
import java.sql.Date
import java.sql.Time

class CreateAlarmViewModel : ViewModel(), View.OnClickListener{

    private val _dismiss = SingleLiveEvent<Any>() // 뒤로가기 버튼
    val dismiss: LiveData<Any>
        get() = _dismiss

    private val _category = MutableLiveData<Int>() // 카테고리 버튼
    val category: LiveData<Int>
        get() = _category

    private val _alarmName = MutableLiveData<String>() // 알림 이름
    val alarmName : LiveData<String>
        get() = _alarmName

    private val _isAlarm = MutableLiveData<Boolean>() // 목표시간 알림울림 설정
    val isAlarm : LiveData<Boolean>
        get() = _isAlarm

    private val _targetTime = MutableLiveData<Time>() // 목표 시간
    val targetTime : LiveData<Time>
        get() = _targetTime

    private val _alarmTiming = MutableLiveData<Int>() // 알람 이전,이후 버튼
    val alarmTiming : LiveData<Int>
        get() = _alarmTiming

    // TODO: api 에 따른 model값 변수 생성 ( 시작구간, 끝 구간, 알림 간격, 반복 요일, 반복설정 버튼, 특정일 알림, 강도 설정)



    fun init(){
        _category.postValue(1)
    }


    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.create_cancel_btn -> _dismiss.call()
                R.id.create_category_btn1 -> _category.postValue(1)
                R.id.create_category_btn2 -> _category.postValue(2)
                R.id.create_category_btn3 -> _category.postValue(3)
            }
        }
    }
}