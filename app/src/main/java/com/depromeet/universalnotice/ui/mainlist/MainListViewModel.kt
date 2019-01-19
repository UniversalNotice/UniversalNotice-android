package com.depromeet.universalnotice.ui.mainlist

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.model.Alarm
import com.depromeet.universalnotice.model.Category
import com.depromeet.universalnotice.model.Level
import com.depromeet.universalnotice.repository.MainListRepository
import com.depromeet.universalnotice.util.SingleLiveEvent
import java.time.LocalTime

class MainListViewModel(
    private val repository: MainListRepository
) : ViewModel(), View.OnClickListener {

    private val _alarmList: MutableLiveData<List<Alarm>>
    val alarmList: LiveData<List<Alarm>>
        get() = _alarmList

    private lateinit var mainListAdapter: MainListAdapter

    private val _createAlarm = SingleLiveEvent<Any>()
    val createAlarm: LiveData<Any>
        get() = _createAlarm

    private val _isEmpty = MutableLiveData<Int>()
    val isEmpty: LiveData<Int>
        get() = _isEmpty


    init {
        mainListAdapter = MainListAdapter(this)
        _alarmList = MutableLiveData()
        _isEmpty.postValue(View.INVISIBLE)
    }

    fun getAdapter(): MainListAdapter {
        return mainListAdapter
    }

    fun setListInAdapter(alarm: List<Alarm>) {
        mainListAdapter.setList(alarm)
        mainListAdapter.notifyDataSetChanged()
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun fetchList() {
//        //TODO : alarmlist 갱신.
        val time: LocalTime
        val time2: LocalTime
        time = LocalTime.of(10,20,30)
        time2 = LocalTime.of(20,30,0)
        var al = Alarm(Category.SLEEP, "알림", time, true, true, 5 ,time,time, "월 화 수", true, Level.HIGH,true,0)
        var al2 = Alarm(Category.TODO, "알리미", time2, true, false, 10 , time,time,"월 화 수 목 금", true,Level.LOW,false,0)
        var list = ArrayList<Alarm>()
        list.add(al)
        list.add(al)
        list.add(al2)
        _alarmList.value = list
    }

    fun getlist(): MutableLiveData<List<Alarm>> {
        return _alarmList
    }

    fun getItemAt(position: Int): Alarm? {
        return getlist().value?.get(position)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.mainlist_remove_btn -> {

                }
                R.id.mainlist_add_btn -> {
                    _createAlarm.call()
                }
            }
        }
    }

}
