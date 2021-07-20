package com.techno.analogclocklivewallpaperdemo

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.techno.analogclocklivewallpaperdemo.adapter.DialerPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private var currentItem: Int = 0
    private lateinit var adapter: DialerPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alData = ArrayList<Int>().apply {
            add(R.drawable.dialer_one)
            add(R.drawable.dialer_two)
        }
        adapter = DialerPagerAdapter(alData)

        viewPager.adapter = adapter

        adapter.onItemClick = { position ->
            selectedPosition = position
            val intent = Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER
            )
            intent.putExtra(
                WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                ComponentName(this, ClockWallpaperService::class.java)
            )
            startActivity(intent)
        }
        indicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(this)
        ivLeft.setOnClickListener {
            viewPager.setCurrentItem(currentItem - 1, true)
        }
        ivRight.setOnClickListener {
            viewPager.setCurrentItem(currentItem + 1, true)
        }

        tvMoreApps.setOnClickListener {
            startActivity(Intent(this, ClockListActivity::class.java))
        }

        tvDisableWallpaper.setOnClickListener{
            val myWallpaperManager = WallpaperManager.getInstance(
                applicationContext
            )
            try {
                myWallpaperManager.clear()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        }
    }

    companion object {
        var selectedPosition = 0
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        currentItem = position
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

}