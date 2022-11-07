package com.example.restaurant.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManagerNonConfig
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.restaurant.R
import com.example.restaurant.adapter.RegisterAdapter
import com.example.restaurant.databinding.FragmentRegisterBinding
import kotlinx.coroutines.flow.combineTransform
import javax.xml.transform.Transformer

class RegisterFragment : Fragment() {

    private val binding by lazy { FragmentRegisterBinding.inflate(layoutInflater) }
    private lateinit var registerAdapter: RegisterAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        val titles = ArrayList<String>()
        titles.add(resources.getString(R.string.str_login))
        titles.add(resources.getString(R.string.str_signUp))
        registerAdapter = RegisterAdapter(titles,childFragmentManager)

        binding.apply {
            registerAdapter.addFragment(LoginFragment())
            registerAdapter.addFragment(SignUpFragment())
            viewPager.adapter = registerAdapter
            viewPager.currentItem = 0
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}