package com.beok.edgeeffectfactoryexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(
    parent: ViewGroup,
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(layoutResourceID, parent, false)
) {

    private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    fun bind(item: Any?) {
        if (item == null) return
        binding.setVariable(bindingID, item)
        binding.executePendingBindings()
    }
}
