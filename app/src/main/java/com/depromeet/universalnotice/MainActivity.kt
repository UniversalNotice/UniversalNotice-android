package com.depromeet.universalnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.depromeet.universalnotice.ui.mainlist.MainListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(FRAGMENT_ID,
            MainListFragment()
        ).commit()
    }

    companion object {
        private const val FRAGMENT_ID = R.id.main_container
    }
}
