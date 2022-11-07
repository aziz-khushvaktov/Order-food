package com.example.restaurant.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.restaurant.R
import com.example.restaurant.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private val binding by lazy { FragmentSignUpBinding.inflate(layoutInflater) }

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
        binding.apply {
            bRegister.setOnClickListener {
                findNavController().navigate(R.id.main_nav_graph)
            }
        }
    }

}