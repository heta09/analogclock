package com.techno.analogclocklivewallpaperdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import com.techno.analogclocklivewallpaperdemo.R


class DialerPagerAdapter(private val alData: ArrayList<Int>) : PagerAdapter() {

    var onItemClick: ((position: Int) -> Unit)? = null

    override fun getCount(): Int = alData.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.sliding_images_layout, container, false)
        val ivDialer = view.findViewById(R.id.image) as AppCompatImageView
        ivDialer.setImageResource(alData[position])
        container.addView(view)
        ivDialer.setOnClickListener {
            onItemClick?.invoke(position)
        }
        return view
    }
}