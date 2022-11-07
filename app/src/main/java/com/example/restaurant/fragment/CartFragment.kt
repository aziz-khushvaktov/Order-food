package com.example.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.Listener.MyButton
import com.example.Listener.MyButtonClickListener
import com.example.helper.MySwipeHelper
import com.example.restaurant.R
import com.example.restaurant.adapter.CartAdapter
import com.example.restaurant.databinding.FragmentCartBinding
import com.example.restaurant.model.Cart
import com.example.restaurant.utils.Utils.toast

class CartFragment : Fragment() {

    private val binding by lazy { FragmentCartBinding.inflate(layoutInflater) }
    private val cartAdapter by lazy { CartAdapter() }
    private var carts = ArrayList<Cart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.ivArrowBackCart.setOnClickListener { findNavController().navigate(R.id.homeFragment) }

        cartAdapter.submitList(listOfCarts())

        val itemTouch = object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
            ): Int {
                val swipeFlags = ItemTouchHelper.END
                return makeMovementFlags(0, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                cartAdapter.onItemDismiss(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouch)
        itemTouchHelper.attachToRecyclerView(binding.rvCart)

        object : MySwipeHelper(requireActivity(), binding.rvCart, 150) {
            override fun instantiateMyButton(
                viewHolder: RecyclerView.ViewHolder,
                buffer: MutableList<MyButton>,
            ) {
                // Add button
                buffer.add(MyButton(requireActivity(), R.drawable.im_favourite_white2,
                    resources.getColor(R.color.light_background_grey),
                    object : MyButtonClickListener {
                        override fun onClick(position: Int) {
                            toast(requireActivity(), "DELETE ID: $position")
                        }

                    }))

                buffer.add(MyButton(requireActivity(), R.drawable.im_favourite_white,
                    resources.getColor(R.color.light_background_grey),
                    object : MyButtonClickListener {
                        override fun onClick(position: Int) {
                            toast(requireActivity(), "UPDATE ID: $position")
                        }

                    }))
            }
        }

        binding.rvCart.setHasFixedSize(true)
        binding.rvCart.adapter = cartAdapter

        cartAdapter.onItemClick = {

        }
    }

    private fun listOfCarts(): ArrayList<Cart> {
        carts.add(Cart(1,
            R.drawable.im_meal2,
            resources.getString(R.string.str_tomato_veggie),
            "8.00",
            0))
        carts.add(Cart(2,
            R.drawable.food1,
            resources.getString(R.string.str_veggie_tomato_mix),
            "20.00",
            0))
        carts.add(Cart(1,
            R.drawable.im_meal2,
            resources.getString(R.string.str_tomato_veggie),
            "8.00",
            0))
        carts.add(Cart(2,
            R.drawable.food1,
            resources.getString(R.string.str_veggie_tomato_mix),
            "20.00",
            0))
        carts.add(Cart(1,
            R.drawable.im_meal2,
            resources.getString(R.string.str_tomato_veggie),
            "8.00",
            0))
        carts.add(Cart(2,
            R.drawable.food1,
            resources.getString(R.string.str_veggie_tomato_mix),
            "20.00",
            0))
        carts.add(Cart(1,
            R.drawable.im_meal2,
            resources.getString(R.string.str_tomato_veggie),
            "8.00",
            0))
        carts.add(Cart(2,
            R.drawable.food1,
            resources.getString(R.string.str_veggie_tomato_mix),
            "20.00",
            0))
        carts.add(Cart(1,
            R.drawable.im_meal2,
            resources.getString(R.string.str_tomato_veggie),
            "8.00",
            0))
        carts.add(Cart(2,
            R.drawable.food1,
            resources.getString(R.string.str_veggie_tomato_mix),
            "20.00",
            0))
        return carts
    }

}