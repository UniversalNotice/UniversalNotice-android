package com.depromeet.universalnotice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.airbnb.lottie.LottieAnimationView


class SplashActivity : AppCompatActivity(){
    private var mDelayHandler: Handler? = null
    private val SPLASH_DISPLAY_LENGTH:Long= 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_splash)

        val animationView = findViewById<LottieAnimationView>(R.id.splash_anim)
        animationView.playAnimation()

        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DISPLAY_LENGTH)
    }

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}