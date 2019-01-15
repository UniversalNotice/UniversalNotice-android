package com.depromeet.universalnotice.ui.create

import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.databinding.adapters.SeekBarBindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.util.SingleLiveEvent
import java.util.*


class CreateAlarmViewModel : ViewModel(), View.OnClickListener, TextViewBindingAdapter.OnTextChanged,
    SeekBarBindingAdapter.OnProgressChanged {

    private val _dismiss = SingleLiveEvent<Any>() // 뒤로가기 버튼
    val dismiss: LiveData<Any>
        get() = _dismiss

    private val _category = MutableLiveData<Int>() // 카테고리 버튼
    val category: LiveData<Int>
        get() = _category

    private val _alarmName = MutableLiveData<String>() // 알림 이름
    val alarmName: LiveData<String>
        get() = _alarmName

    private val _isAlarm = MutableLiveData<Boolean>() // 목표시간 알림울림 설정
    val isAlarm: LiveData<Boolean>
        get() = _isAlarm

    private val _targetTimeClick = SingleLiveEvent<Any>()
    val targetTimeClick: LiveData<Any>
        get() = _targetTimeClick

    private val _targetTime = MutableLiveData<String>() // 목표 시간
    val targetTime: LiveData<String>
        get() = _targetTime

    private val _targetTime_ampm = MutableLiveData<String>() // 목표 시간
    val targetTime_ampm: LiveData<String>
        get() = _targetTime_ampm

    private val _alarmTiming = MutableLiveData<Int>() // 알람 이전,이후 버튼
    val alarmTiming: LiveData<Int>
        get() = _alarmTiming

    private val _alarmInterval = MutableLiveData<String>()
    val alarmInterval: LiveData<String>
        get() = _alarmInterval

    private val _intervalStartTime = MutableLiveData<String>()
    val intervalStartTime: LiveData<String>
        get() = _intervalStartTime

    private val _intervalStartTime_ampm = MutableLiveData<String>()
    val intervalStartTime_ampm: LiveData<String>
        get() = _intervalStartTime_ampm

    private val _intervalEndTime = MutableLiveData<String>()
    val intervalEndTime: LiveData<String>
        get() = _intervalEndTime

    private val _intervalEndTime_ampm = MutableLiveData<String>()
    val intervalEndTime_ampm: LiveData<String>
        get() = _intervalEndTime_ampm

    private val _intervalStartClick = SingleLiveEvent<Any>()
    val intervalStartClick: LiveData<Any>
        get() = _intervalStartClick

    private val _intervalEndClick = SingleLiveEvent<Any>()
    val intervalEndClick: LiveData<Any>
        get() = _intervalEndClick

    private val _day_of_the_week = MutableLiveData<List<Boolean>>()
    private val daysList = ArrayList<Boolean>(Arrays.asList(false, false, false, false, false, false, false))
    val day_of_the_week: LiveData<List<Boolean>>
        get() = _day_of_the_week

    private val _repeatType = MutableLiveData<Int>() // 알람 이전,이후 버튼
    val repeatType: LiveData<Int>
        get() = _repeatType

    private val _isSpecificAlarm = MutableLiveData<Boolean>() // 목표시간 알림울림 설정
    val isSpecificAlarm: LiveData<Boolean>
        get() = _isSpecificAlarm

    private val _datePickerClick = SingleLiveEvent<Any>()
    val datePickerClick : LiveData<Any>
        get() = _datePickerClick

    private val _specificDayText  = MutableLiveData<String>()
    val specificDayText: LiveData<String>
        get() = _specificDayText

    private val _alarmStrength = MutableLiveData<Int>() // 카테고리 버튼
    val alarmStrength: LiveData<Int>
        get() = _alarmStrength

    // TODO: api 에 따른 model값 변수 생성 ( 시작구간, 끝 구간, 알림 간격, 반복 요일, 반복설정 버튼, 특정일 알림, 강도 설정)

    init {
        _category.postValue(1)
        _isAlarm.postValue(false)
        _alarmTiming.postValue(1)
        _targetTime.postValue("00:00")
        _targetTime_ampm.postValue("am")
        _alarmInterval.postValue("5분")
        _intervalStartTime.postValue("00:00")
        _intervalStartTime_ampm.postValue("am")
        _intervalEndTime.postValue("00:00")
        _intervalEndTime_ampm.postValue("am")
        _day_of_the_week.postValue(daysList)
        _repeatType.postValue(1)
        _isSpecificAlarm.postValue(false)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        _specificDayText.postValue(""+year+" 년   "+(month+1)+" 월   "+day+" 일")
        _alarmStrength.postValue(1)
    }

    fun setTargetTime(time: String) {
        _targetTime.postValue(time)
    }

    fun setTargetTimeAmPm(ampm: String) {
        _targetTime_ampm.postValue(ampm)
    }

    fun setIntervalStartTime(time: String) {
        _intervalStartTime.postValue(time)
    }

    fun setIntervalStartTimeAmPm(ampm: String) {
        _intervalStartTime_ampm.postValue(ampm)
    }

    fun setIntervalEndTime(time: String) {
        _intervalEndTime.postValue(time)
    }

    fun setIntervalEndTimeAmPm(ampm: String) {
        _intervalEndTime_ampm.postValue(ampm)
    }

    fun setSpecificDate(date : String){
        _specificDayText.postValue(date)
    }


    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.create_cancel_btn -> _dismiss.call()
                R.id.create_save_btn -> Log.d(
                    "@@@ModelData//",
                    "category:" + _category.value + " alarmName:" + _alarmName.value + " isAlarm:" + _isAlarm.value + " alarmTiming:" + _alarmTiming.value + " targetTime:" + _targetTime.value + " alarminterval:" + _alarmInterval.value
                )
                R.id.create_category_btn1 -> _category.postValue(1)
                R.id.create_category_btn2 -> _category.postValue(2)
                R.id.create_category_btn3 -> _category.postValue(3)
                R.id.create_target_time_text,R.id.create_target_time_btn -> _isAlarm.postValue(!(isAlarm.value)!!)
                R.id.create_target_time_before -> _alarmTiming.postValue(1)
                R.id.create_target_time_after -> _alarmTiming.postValue(2)
                R.id.create_target_time, R.id.create_target_time_ampm -> _targetTimeClick.call()
                R.id.crete_time_interval_starttime, R.id.create_time_interval_starttime_ampm -> _intervalStartClick.call()
                R.id.crete_time_interval_endtime, R.id.create_time_interval_endtime_ampm -> _intervalEndClick.call()
                //
                R.id.create_repeat_monday -> {
                    daysList[0] = (!daysList[0])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_tuesday -> {
                    daysList[1] = (!daysList[1])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_wednesday -> {
                    daysList[2] = (!daysList[2])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_thursday -> {
                    daysList[3] = (!daysList[3])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_friday -> {
                    daysList[4] = (!daysList[4])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_saturday -> {
                    daysList[5] = (!daysList[5])
                    _day_of_the_week.postValue(daysList)
                }
                R.id.create_repeat_sunday -> {
                    daysList[6] = (!daysList[6])
                    _day_of_the_week.postValue(daysList)
                }
                //
                R.id.create_repeat_week_btn -> _repeatType.postValue(1)
                R.id.create_repeat_onetime_btn -> _repeatType.postValue(2)
                R.id.create_repeat_specific_day_text,R.id.create_repeat_specific_day_img -> _isSpecificAlarm.postValue(!(_isSpecificAlarm.value)!!)
                R.id.create_repeat_specific_day_date -> _datePickerClick.call()
                R.id.create_strength_btn_1 -> _alarmStrength.postValue(1)
                R.id.create_strength_btn_2 -> _alarmStrength.postValue(2)
                R.id.create_strength_btn_3 -> _alarmStrength.postValue(3)
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _alarmName.postValue(s.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val stepSize = 5
        val mProgress = (progress * stepSize)
        _alarmInterval.postValue(mProgress.toString() + "분")
    }

}