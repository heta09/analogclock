package com.techno.analogclocklivewallpaperdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import com.techno.analogclocklivewallpaperdemo.adapter.WallpaperAdapter
import com.techno.analogclocklivewallpaperdemo.databinding.ActivityWallpaperBinding

class WallpaperActivity : AppCompatActivity() {

    private val adapter: WallpaperAdapter by lazy { WallpaperAdapter() }
    private var wList = ArrayList<WallpaperModel>()
    var clockDial = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWallpaperBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_wallpaper
            )
        //clockDial = intent.getIntArrayExtra("clockDial")
        binding.rvWallpaper.itemAnimator = DefaultItemAnimator()
        binding.rvWallpaper.adapter = adapter

        val item = WallpaperModel()
        item.wallpaper = R.drawable.ic_launcher_background
        wList.add(item)

        val item1 = WallpaperModel()
        item1.wallpaper = R.drawable.ic_launcher_background
        wList.add(item1)

        val item2 = WallpaperModel()
        item2.wallpaper = R.drawable.ic_launcher_background
        wList.add(item2)

        adapter.addData(wList)
    }
}