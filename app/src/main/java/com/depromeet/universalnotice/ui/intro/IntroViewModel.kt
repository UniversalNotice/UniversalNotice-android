package com.depromeet.universalnotice.ui.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.depromeet.universalnotice.IntroRepository
import org.jetbrains.anko.AnkoLogger

class IntroViewModel(private val introTextArray: Array<String>, private val introRepo: IntroRepository) : ViewModel(), AnkoLogger {
    private val _pageChange: MutableLiveData<Int> = MutableLiveData()
    private val _activityToStart: MutableLiveData<Boolean> = MutableLiveData()

    val pageChange: LiveData<Int> get() = _pageChange
    val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            _pageChange.postValue(position)
        }
    }

    val activityToStart: LiveData<Boolean> get() = _activityToStart

    init {
        if (introRepo.isExecuted())
            startToActivity()
    }

    fun getIntroText(position: Int) = introTextArray[position]

    fun allowAlert() = startToActivity()

    private fun startToActivity() {
        _activityToStart.postValue(true)
        introRepo.setExecuted()
    }

}