package com.depromeet.universalnotice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.depromeet.universalnotice.ui.intro.IntroMainFragment

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        supportFragmentManager.beginTransaction().replace(FRAGMENT_ID,
            IntroMainFragment()
        ).commit()
    }

    companion object {
        private const val FRAGMENT_ID = R.id.intro_container
    }
}