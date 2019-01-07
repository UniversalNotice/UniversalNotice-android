package com.depromeet.universalnotice.ui.intro

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class IntroViewModel(private val introTextArray: Array<String>) : ViewModel(), AnkoLogger {
    private val _pageChange: MutableLiveData<Int> = MutableLiveData()

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

    init {
    }

    fun getIntroText(position: Int) = introTextArray[position]
}