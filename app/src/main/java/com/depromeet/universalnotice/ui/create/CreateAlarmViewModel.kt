package com.depromeet.universalnotice.ui.create

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.util.SingleLiveEvent

class CreateAlarmViewModel : ViewModel(), View.OnClickListener{

    private val _dismiss = SingleLiveEvent<Any>()
    val dismiss: LiveData<Any>
        get() = _dismiss

    private val _category = MutableLiveData<Int>()
    val category: LiveData<Int>
        get() = _category

    // TODO: api 에 따른 model값 변수 생성.


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