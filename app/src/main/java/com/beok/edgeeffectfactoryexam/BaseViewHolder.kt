package com.beok.edgeeffectfactoryexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
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
    private var currentVelocity = 0f
    val translationY: SpringAnimation = SpringAnimation(itemView, SpringAnimation.TRANSLATION_Y)
        .setSpring(
            SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_LOW)
        )

    fun bind(item: Any?) {
        if (item == null) return
        binding.setVariable(bindingID, item)
        binding.executePendingBindings()
    }
}
