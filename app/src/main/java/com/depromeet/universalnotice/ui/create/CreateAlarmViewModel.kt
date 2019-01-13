package com.depromeet.universalnotice.ui.create

import android.util.Log
import android.view.View
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.util.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.sql.Date
import java.sql.Time

class CreateAlarmViewModel : ViewModel(), View.OnClickListener,TextViewBindingAdapter.OnTextChanged{

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

    private val _targetTimeClick = SingleLiveEvent<Any>()
    val targetTimeClick: LiveData<Any>
    get() = _targetTimeClick

    private val _targetTime = MutableLiveData<Time>() // 목표 시간
    val targetTime : LiveData<Time>
        get() = _targetTime

    private val _alarmTiming = MutableLiveData<Int>() // 알람 이전,이후 버튼
    val alarmTiming : LiveData<Int>
        get() = _alarmTiming

    // TODO: api 에 따른 model값 변수 생성 ( 시작구간, 끝 구간, 알림 간격, 반복 요일, 반복설정 버튼, 특정일 알림, 강도 설정)

    init {
        _category.postValue(1)
        _isAlarm.postValue(false)
        _alarmTiming.postValue(1)
    }


    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.create_cancel_btn -> _dismiss.call()
                R.id.create_save_btn -> Log.d("@@@ModelData//","category:"+_category.value+" alarmName:"+_alarmName.value+" isAlarm:"+_isAlarm.value+" alarmTiming:"+_alarmTiming.value)
                R.id.create_category_btn1 -> _category.postValue(1)
                R.id.create_category_btn2 -> _category.postValue(2)
                R.id.create_category_btn3 -> _category.postValue(3)
                R.id.create_target_time_text -> if (_isAlarm.value!!) _isAlarm.postValue(false) else _isAlarm.postValue(true)
                R.id.create_target_time_btn -> if (_isAlarm.value!!) _isAlarm.postValue(false) else _isAlarm.postValue(true)
                R.id.create_target_time_before -> _alarmTiming.postValue(1)
                R.id.create_target_time_after -> _alarmTiming.postValue(2)
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _alarmName.postValue(s.toString())
    }


}