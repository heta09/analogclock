package com.techno.analogclocklivewallpaperdemo

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.techno.analogclocklivewallpaperdemo.adapter.MoreAdapter
import com.techno.analogclocklivewallpaperdemo.databinding.ActivityClockListBinding
import com.techno.analogclocklivewallpaperdemo.databinding.ActivityMoreAppBinding
import kotlinx.android.synthetic.main.activity_more_app.*

class MoreAppActivity : AppCompatActivity() {
    private val adapter: MoreAdapter by lazy { MoreAdapter() }
    var categoryName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMoreAppBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_more_app
            )

        categoryName = intent.getStringExtra("name").toString()

        binding.layoutHeader.tvDepartment.text = categoryName
        binding.layoutHeader.ivBack.setOnClickListener() {
            finish()
        }

        rvList.adapter = adapter
        val alData = ArrayList<Int>().apply {
            add(R.drawable.dialer_one)
            add(R.drawable.dialer_two)
        }
        adapter.addData(alData)
        ivPreview.setImageResource(R.drawable.dialer_one)
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