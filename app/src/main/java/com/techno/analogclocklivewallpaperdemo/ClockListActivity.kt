package com.techno.analogclocklivewallpaperdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import com.techno.analogclocklivewallpaperdemo.adapter.CategoryAdapter
import com.techno.analogclocklivewallpaperdemo.databinding.ActivityClockListBinding
import kotlinx.android.synthetic.main.activity_clock_list.*
import kotlinx.android.synthetic.main.activity_main.*

class ClockListActivity : AppCompatActivity() {
    private var cList = ArrayList<CategoryModel>()
    private val adapter: CategoryAdapter by lazy { CategoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityClockListBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_clock_list
            )


        binding.layoutHeader.tvDepartment.text = "Categories"
        binding.layoutHeader.ivBack.setOnClickListener() {
            finish()
        }

        binding.rvCategory.itemAnimator = DefaultItemAnimator()
        binding.rvCategory.adapter = adapter

        val item = CategoryModel()
        item.categoryName = "Love"
        cList.add(item)

        val item1 = CategoryModel()
        item1.categoryName = "Nature"
        cList.add(item1)

        val item2 = CategoryModel()
        item2.categoryName = "Fancy"
        cList.add(item2)

        adapter.addData(cList)

        /*adapter.onItemClick = {
            startActivity(Intent(this, MoreAppActivity::class.java).putExtra("name", ))
        }*/

        adapter.onItemClick = { position, item ->
            startActivity(
                Intent(this, MoreAppActivity::class.java).putExtra(
                    "name",
                    item.categoryName
                )
            )
        }
    }
}