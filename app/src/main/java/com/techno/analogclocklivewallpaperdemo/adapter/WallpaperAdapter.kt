package com.techno.analogclocklivewallpaperdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.techno.analogclocklivewallpaperdemo.R
import com.techno.analogclocklivewallpaperdemo.WallpaperModel
import kotlinx.android.synthetic.main.lay_item.view.*
import kotlinx.android.synthetic.main.lay_item.view.ivDialer
import kotlinx.android.synthetic.main.row_wallpaper.view.*

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
    private var wallpaperData: ArrayList<WallpaperModel> = ArrayList()
    var onItemClick: ((item: Int, position: Int) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
            itemView.iv_wallpaper.setImageResource(wallpaperData[adapterPosition].wallpaper)

            itemView.cb_check.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                wallpaperData[adapterPosition].isCheck = isChecked
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_wallpaper, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView()
    }

    override fun getItemCount(): Int = wallpaperData.size

    fun addData(alData: ArrayList<WallpaperModel>) {
        this.wallpaperData = alData
        notifyDataSetChanged()
    }
}