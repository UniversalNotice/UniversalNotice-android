package com.depromeet.universalnotice.ui.mainlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.model.Alarm

class MainListViewModel : ViewModel(){

//    private lateinit var  alarm : Alarm
    private lateinit var alarmList: MutableLiveData<List<Alarm>>
    private lateinit var mainListAdapter: MainListAdapter


    fun init(){
        mainListAdapter = MainListAdapter(this)
        alarmList = MutableLiveData()
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
        var al= Alarm(1,"알림","08:00","AM",true,"이전","5분","월 화 수",true,true)
        var al2= Alarm(1,"알리미","10:00","AM",true,"이후","5분","월 화 수 목 금",true,true)
        var list= ArrayList<Alarm>()
        list.add(al)
        list.add(al2)
        alarmList.value = list
    }

    fun getlist() :MutableLiveData<List<Alarm>>{
        return alarmList
    }

    fun getItemAt(position: Int):Alarm?{
        return getlist().value?.get(position)
    }

    operator fun invoke(viewModel: MainListViewModel) {

    }


}
