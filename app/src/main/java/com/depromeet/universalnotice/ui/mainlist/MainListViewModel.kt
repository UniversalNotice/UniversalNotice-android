package com.depromeet.universalnotice.ui.mainlist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.model.Alarm
import com.depromeet.universalnotice.repository.MainListRepository
import com.depromeet.universalnotice.util.SingleLiveEvent

class MainListViewModel(
    private val repository: MainListRepository
) : ViewModel(), View.OnClickListener {

    private lateinit var _alarmList: MutableLiveData<List<Alarm>>
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

    fun fetchList() {
//        //TODO : alarmlist 갱신.
        var al = Alarm(1, "알림", "08:00", "AM", true, "이전", "5분", "월 화 수", true, true)
        var al2 = Alarm(1, "알리미", "10:00", "AM", true, "이후", "5분", "월 화 수 목 금", true,false)
        var list = ArrayList<Alarm>()
        list.add(al)
        list.add(al)
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
