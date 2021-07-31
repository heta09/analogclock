package com.techno.analogclocklivewallpaperdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.techno.analogclocklivewallpaperdemo.databinding.ActivityMoreAppBinding
import com.techno.analogclocklivewallpaperdemo.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_splash
            )

        binding.tvStart.setOnClickListener(){
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}