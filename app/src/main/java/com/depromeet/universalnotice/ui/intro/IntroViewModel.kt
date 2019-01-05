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
    private val _introText: MutableLiveData<String> = MutableLiveData()
    private val _allowButton: MutableLiveData<Int> = MutableLiveData()

    val pageChange: LiveData<Int> get() = _pageChange
    val introText: LiveData<String> get() = _introText
    val allowButton: LiveData<Int> get() = _allowButton
    val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            _pageChange.postValue(position)
            _introText.postValue(introTextArray[position])
            _allowButton.postValue(if (position == 4) View.VISIBLE else View.GONE )
        }
    }

    init {
        _introText.postValue(introTextArray[0])
        _allowButton.postValue(View.GONE)
    }
}