package com.example.restaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Listener.ItemTouchHelperAdapter
import com.example.Listener.MyButtonClickListener
import com.example.restaurant.databinding.ItemCartLayoutBinding
import com.example.restaurant.model.Cart
import java.util.*
import kotlin.collections.ArrayList

class CartAdapter : ListAdapter<Cart, CartAdapter.VH>(CartDiffUtil()), ItemTouchHelperAdapter {

    var onItemClick : ((Cart) -> Unit)? = null

    inner class VH(var binding: ItemCartLayoutBinding, var context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(cart: Cart) {
            binding.tvCount.text = cart.count.toString()
            Glide.with(context).load(cart.photo).into(binding.ivMeal)
            binding.tvMealName.text = cart.name
            binding.tvGhs.text = cart.GHS

            onItemClick?.invoke(cart)
            binding.ivAdd.setOnClickListener {
                cart.count++
                binding.tvCount.text = cart.count.toString()
            }
            binding.ivSubtract.setOnClickListener {
                if(cart.count > 0) {
                    cart.count--
                    binding.tvCount.text = cart.count.toString()
                }
            }
        }
    }

    class CartDiffUtil : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.equals(newItem)
        }
    }

    override fun submitList(list: MutableList<Cart>?) {
        super.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCartLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onItemDismiss(position: Int) {
        notifyItemRemoved(position)
    }


}