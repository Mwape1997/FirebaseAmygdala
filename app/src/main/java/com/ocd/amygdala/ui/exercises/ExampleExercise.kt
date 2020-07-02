package com.ocd.amygdala.ui.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ocd.amygdala.app.R

import com.ocd.amygdala.app.databinding.FragmentExampleExerciseBinding

class ExampleExercise : Fragment() {
    private lateinit var binding: FragmentExampleExerciseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExampleExerciseBinding.inflate(inflater, container, false)


        return binding.root
    }
}