package com.example.restaurant.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurant.databinding.ItemFoodLayoutBinding
import com.example.restaurant.model.Food

class FoodAdapter : ListAdapter<Food, FoodAdapter.Vh>(MyDiffUtil()) {

    inner class Vh(var binding: ItemFoodLayoutBinding, var context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(food: Food) {
            binding.apply {
                llMain.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                Glide.with(context).load(food.image).into(ivFood)
                tvFoodName.text = food.name
                tvFoodPrice.text = food.price
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val food = getItem(position)
        holder.onBind(food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemFoodLayoutBinding.inflate(LayoutInflater.from(parent.context)), parent.context)
    }
}