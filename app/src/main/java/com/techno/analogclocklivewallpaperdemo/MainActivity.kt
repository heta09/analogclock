package com.techno.analogclocklivewallpaperdemo

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var wallpaper: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpaper = findViewById(R.id.btn_wallpaper)
        wallpaper.setOnClickListener(){
            val intent = Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER
            )
            intent.putExtra(
                WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                ComponentName(this, ClockWallpaperService::class.java)
            )
            startActivity(intent)
        }

    }
}