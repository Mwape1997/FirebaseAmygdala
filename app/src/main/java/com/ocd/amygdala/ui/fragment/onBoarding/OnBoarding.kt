package com.ocd.amygdala.ui.fragment.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ocd.amygdala.adapter.SliderAdapter
import com.ocd.amygdala.utils.Prefs
import com.ocd.amygdala.app.databinding.FragmentOnBoardingBinding
import kotlinx.android.synthetic.main.fragment_on_boarding.*

//onboading fragment for the onboarding screen
class OnBoarding : Fragment() {
    private var sliderAdapter: SliderAdapter =
        SliderAdapter()
    private lateinit var viewModel: OnBoardingViewModel
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(OnBoardingViewModel::class.java)
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        binding.onBoardingViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.dataSet.observe(viewLifecycleOwner, Observer {
            viewPager2.adapter = sliderAdapter
            sliderAdapter.setItems(it)
            TabLayoutMediator(
                indicator,
                viewPager2,
                object : TabLayoutMediator.TabConfigurationStrategy {
                    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                        viewPager2.setCurrentItem(tab.position, true)
                    }
                }).attach()
        })
        viewModel.startNavigation.observe(viewLifecycleOwner, Observer {
            if (it) {
                this.findNavController()
                    .navigate(OnBoardingDirections.actionOnBoardingToAuthFragment())
                Prefs.getInstance(context!!)!!.finishedOnboading = false
                viewModel.doneNavigation()
            }
        })
        binding.viewPager2.registerOnPageChangeCallback(viewModel.pagerCallBack)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager2.unregisterOnPageChangeCallback(viewModel.pagerCallBack)
    }
}