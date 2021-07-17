package com.techno.analogclocklivewallpaperdemo

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techno.analogclocklivewallpaperdemo.adapter.MoreAdapter
import kotlinx.android.synthetic.main.activity_more_app.*

class MoreAppActivity : AppCompatActivity() {
    private val adapter: MoreAdapter by lazy { MoreAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_app)
        rvList.adapter = adapter
        val alData = ArrayList<Int>().apply {
            add(R.drawable.dialer_one)
            add(R.drawable.dialer_two)
        }
        adapter.addData(alData)
        ivPreview.setImageResource(alData[0])
        MainActivity.selectedPosition = 0
        adapter.onItemClick = { item, position ->
            ivPreview.setImageResource(item)
            MainActivity.selectedPosition = position
        }

        btnApply.setOnClickListener {
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