package com.techno.analogclocklivewallpaperdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techno.analogclocklivewallpaperdemo.CategoryModel
import com.techno.analogclocklivewallpaperdemo.R
import kotlinx.android.synthetic.main.lay_item.view.*
import kotlinx.android.synthetic.main.row_category.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private var categories: ArrayList<CategoryModel> = ArrayList()
    var onItemClick: ((position: Int, item: CategoryModel) -> Unit)? = null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            val item = categories[adapterPosition]
            itemView.tv_category.text = item.categoryName
            itemView.setOnClickListener {
                onItemClick?.invoke(adapterPosition, item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_category, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind()

    fun addData(categoryName: ArrayList<CategoryModel>) {
        this.categories = categoryName
      notifyDataSetChanged()
    }
}