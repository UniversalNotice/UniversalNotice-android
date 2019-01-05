package com.depromeet.universalnotice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.depromeet.universalnotice.databinding.ActivityIntroBinding
import com.depromeet.universalnotice.ui.intro.IntroPagerAdapter
import com.depromeet.universalnotice.ui.intro.IntroViewModel
import kotlinx.android.synthetic.main.activity_intro.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class IntroActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityIntroBinding>(this, R.layout.activity_intro)
    }

    private val viewModel by viewModel<IntroViewModel>{parametersOf(resources.getStringArray(R.array.intro_text_array))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.adapter = IntroPagerAdapter(supportFragmentManager)
        binding.vm = viewModel

        indicator.createDotPanel(5, R.drawable.ic_indicator, R.drawable.ic_indicator_dark, 0)

        viewModel.pageChange.observe(this, Observer {
            indicator.selectDot(it)
        })

    }
}