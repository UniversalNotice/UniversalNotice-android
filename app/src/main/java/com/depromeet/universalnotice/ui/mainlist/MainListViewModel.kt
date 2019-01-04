package com.depromeet.universalnotice.ui.mainlist

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.MainActivity
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.model.Alarm
import kotlinx.android.synthetic.main.fragment_mainlist.view.*

class MainListViewModel : ViewModel(),View.OnClickListener{


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

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.mainlist_remove_btn -> {

                }
                R.id.mainlist_add_btn -> {

                }
            }
        }
    }

}
