package com.example.restaurant.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.restaurant.R
import com.example.restaurant.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private val binding by lazy { FragmentHistoryBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.ivArrowBackHistory.setOnClickListener{
            findNavController().navigate(R.id.homeFragment)
        }

        binding.bStartOrdering.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

}