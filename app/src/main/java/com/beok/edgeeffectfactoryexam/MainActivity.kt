package com.beok.edgeeffectfactoryexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.beok.edgeeffectfactoryexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupUI()
    }

    private fun setupUI() {
        val dummyItemGroup = mutableListOf<Item>()
        repeat(30) {
            dummyItemGroup.add(Item(name = "TestTestTestTestTestTest"))
        }
        binding.rvMain.adapter = BaseAdapter(
            layoutResourceID = R.layout.holder_main,
            bindingID = BR.item,
            diffUtil = object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                    oldItem.name == newItem.name

                override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                    oldItem == newItem
            }
        ).apply {
            submitList(dummyItemGroup.toList())
        }
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }
}
