package com.example.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.restaurant.R
import com.example.restaurant.databinding.FragmentFavouriteBinding
import com.example.restaurant.utils.Utils.toast

class FavouriteFragment : Fragment() {

    private val binding by lazy { FragmentFavouriteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.ivArrowBackOrder.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        binding.bStartOrdering.setOnClickListener{
            findNavController().navigate(R.id.homeFragment)
        }
    }
}