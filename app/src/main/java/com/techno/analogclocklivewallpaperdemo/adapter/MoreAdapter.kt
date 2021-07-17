package com.techno.analogclocklivewallpaperdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techno.analogclocklivewallpaperdemo.R
import kotlinx.android.synthetic.main.lay_item.view.*

class MoreAdapter : RecyclerView.Adapter<MoreAdapter.ViewHolder>() {
    private var alData: ArrayList<Int> = ArrayList()
    var onItemClick: ((item: Int, position: Int) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
            itemView.ivDialer.setImageResource(alData[adapterPosition])
            itemView.setOnClickListener {
                onItemClick?.invoke(alData[adapterPosition], adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView()
    }

    override fun getItemCount(): Int = alData.size

    fun addData(alData: ArrayList<Int>) {
        this.alData = alData
        notifyDataSetChanged()
    }
}