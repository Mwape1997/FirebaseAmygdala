package com.ocd.amygdala.ui.emergency

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ocd.amygdala.app.R
import com.ocd.amygdala.app.databinding.FragmentEmergencyBinding

class Emergency : Fragment() {
    private lateinit var binding: FragmentEmergencyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmergencyBinding.inflate(inflater, container, false)


        return binding.root
    }
}
