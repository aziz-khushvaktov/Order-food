package com.example.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.restaurant.R
import com.example.restaurant.databinding.ActivityMainBinding
import com.example.restaurant.databinding.DrawerMenuBinding
import com.example.restaurant.utils.Constants.slidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }


    private fun initView() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> hideBottomNav()
                R.id.registerFragment -> hideBottomNav()
                R.id.loginFragment -> hideBottomNav()
                R.id.signUpFragment -> hideBottomNav()
                R.id.homeFragment -> { showBottomNav() }
                R.id.favouriteFragment -> hideBottomNav()
                R.id.profileFragment -> hideBottomNav()
                R.id.historyFragment -> hideBottomNav()
                R.id.cartFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun hideBottomNav() {
        binding.bottomNavigation.isVisible = false
    }

    private fun showBottomNav() {
        binding.bottomNavigation.isVisible = true
    }


}