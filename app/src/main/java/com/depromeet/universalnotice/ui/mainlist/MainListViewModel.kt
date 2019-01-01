package com.depromeet.universalnotice.ui.mainlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.model.Alarm

class MainListViewModel : ViewModel(){

    private lateinit var  alarm : Alarm
    private lateinit var alarmList: MutableLiveData<List<Alarm>>
    private lateinit var mainListAdapter: MainListAdapter


    fun init(){
        mainListAdapter = MainListAdapter(this)
    }

    fun getAdapter() : MainListAdapter{
        return mainListAdapter
    }

    fun setListInAdapter(alarm : List<Alarm>){
        mainListAdapter.setList(alarm)
        mainListAdapter.notifyDataSetChanged()
    }

    fun fetchList(){
//        //TODO : alarmlist 갱신.
    }

    fun getlist() :MutableLiveData<List<Alarm>>{
        return alarmList
    }

    fun getItemAt(position: Int):Alarm?{
        return getlist().value?.get(position)
    }



}
