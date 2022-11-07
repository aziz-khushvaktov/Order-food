package com.example.restaurant.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurant.R
import com.example.restaurant.adapter.FoodAdapter
import com.example.restaurant.databinding.FragmentFoodBinding
import com.example.restaurant.model.Food

class FoodFragment : Fragment() {

    private val binding by lazy { FragmentFoodBinding.inflate(layoutInflater) }
    private val foodAdapter by lazy { FoodAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            rvMenu.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            foodAdapter.submitList(foodList())
            rvMenu.adapter = foodAdapter
        }
    }

    private fun foodList(): ArrayList<Food>{
        val list = ArrayList<Food>()

        list.add(Food(1,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        list.add(Food(2,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        list.add(Food(3,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        list.add(Food(4,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        list.add(Food(5,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        list.add(Food(6,R.drawable.food1,resources.getString(R.string.str_veggie_tomato_mix),"N1.900"))
        return list
    }

}