package com.example.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.restaurant.R
import com.example.restaurant.adapter.HomeVPAdapter
import com.example.restaurant.databinding.DrawerMenuBinding
import com.example.restaurant.databinding.FragmentHomeBinding
import com.example.restaurant.utils.Constants.slidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder

class HomeFragment : Fragment(R.layout.drawer_menu) {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val bindingDrawer by lazy { DrawerMenuBinding.inflate(layoutInflater) }

    private lateinit var homeVPAdapter: HomeVPAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        initViews()
        return binding.root
    }

    private fun initViews() {
        homeVPAdapter = HomeVPAdapter(getTabLayoutTitles(), childFragmentManager)
        addFragmentsToAdapter()

        slidingRootNavigation()
        manageDrawerMenu()

        binding.apply {
            vpHome.adapter = homeVPAdapter
            tabLHome.setupWithViewPager(vpHome)

        }
        binding.ivSettings.setOnClickListener {
            slidingRootNav.openMenu()
        }

        binding.ivOrder.setOnClickListener {
            findNavController().navigate(R.id.cartFragment)
        }
    }

    private fun slidingRootNavigation() {
        slidingRootNav = SlidingRootNavBuilder(requireActivity())
            .withDragDistance(180)
            .withRootViewScale(0.75f)
            .withRootViewElevation(25)
            .withMenuOpened(false)
            .withMenuLocked(true)
            .withMenuLayout(R.layout.drawer_menu)
            .withMenuView(bindingDrawer.root)
            .withContentClickableWhenMenuOpened(false)
            .withMenuLayout(R.layout.drawer_menu)
            .inject()

        slidingRootNav.closeMenu()
    }

    private fun manageDrawerMenu() {
        bindingDrawer.apply {
            llProfile.setOnClickListener {
                slidingRootNav.closeMenu()
                tvProfile.setTextColor(resources.getColor(R.color._blue))
                tvOrder.setTextColor(resources.getColor(R.color.white))
                tvOrderPromo.setTextColor(resources.getColor(R.color.white))
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color.white))
                tvSecurity.setTextColor(resources.getColor(R.color.white))
                tvSignOut.setTextColor(resources.getColor(R.color.white))
            }

            llOrders.setOnClickListener {
                slidingRootNav.closeMenu()
                tvOrder.setTextColor(resources.getColor(R.color._blue))
                tvProfile.setTextColor(resources.getColor(R.color.white))
                tvOrderPromo.setTextColor(resources.getColor(R.color.white))
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color.white))
                tvSecurity.setTextColor(resources.getColor(R.color.white))
                tvSignOut.setTextColor(resources.getColor(R.color.white))
            }

            llOfferPromo.setOnClickListener {
                slidingRootNav.closeMenu()
                tvOrderPromo.setTextColor(resources.getColor(R.color._blue))
                tvProfile.setTextColor(resources.getColor(R.color.white))
                tvOrder.setTextColor(resources.getColor(R.color.white))
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color.white))
                tvSecurity.setTextColor(resources.getColor(R.color.white))
                tvSignOut.setTextColor(resources.getColor(R.color.white))
            }

            llPrivacyPolicy.setOnClickListener {
                slidingRootNav.closeMenu()
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color._blue))
                tvProfile.setTextColor(resources.getColor(R.color.white))
                tvOrder.setTextColor(resources.getColor(R.color.white))
                tvOrderPromo.setTextColor(resources.getColor(R.color.white))
                tvSecurity.setTextColor(resources.getColor(R.color.white))
                tvSignOut.setTextColor(resources.getColor(R.color.white))
            }

            llSecurity.setOnClickListener {
                slidingRootNav.closeMenu()
                tvSecurity.setTextColor(resources.getColor(R.color._blue))
                tvProfile.setTextColor(resources.getColor(R.color.white))
                tvOrder.setTextColor(resources.getColor(R.color.white))
                tvOrderPromo.setTextColor(resources.getColor(R.color.white))
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color.white))
                tvSignOut.setTextColor(resources.getColor(R.color.white))
            }

            llSignOut.setOnClickListener {
                slidingRootNav.closeMenu()
                tvSignOut.setTextColor(resources.getColor(R.color.white))
                tvProfile.setTextColor(resources.getColor(R.color.white))
                tvOrder.setTextColor(resources.getColor(R.color.white))
                tvOrderPromo.setTextColor(resources.getColor(R.color.white))
                tvPrivacyPolicy.setTextColor(resources.getColor(R.color.white))
                tvSecurity.setTextColor(resources.getColor(R.color.white))

                //findNavController(R.id.nav_graph)
            }
        }
    }

    private fun getTabLayoutTitles(): ArrayList<String> {
        val titles = ArrayList<String>()
        titles.add(resources.getString(R.string.str_foods))
        titles.add(resources.getString(R.string.str_drinks))
        titles.add(resources.getString(R.string.str_snacks))
        titles.add(resources.getString(R.string.str_sauces))
        return titles
    }

    private fun addFragmentsToAdapter() {
        homeVPAdapter.addFragment(FoodFragment())
        homeVPAdapter.addFragment(DrinksFragment())
        homeVPAdapter.addFragment(SnacksFragment())
        homeVPAdapter.addFragment(SaucesFragment())
    }


}