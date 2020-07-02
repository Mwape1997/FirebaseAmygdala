package com.ocd.amygdala.ui.fragment.home


import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.ocd.amygdala.app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.emergencyButton.setOnClickListener { view: View -> view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEmergency())}
        binding.button3.setOnClickListener { view: View -> view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFeed())}
        binding.imageView1.setOnClickListener { view: View -> view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToExampleExercise())}
        binding.logout.setOnClickListener { signOUt(it)  }



        return binding.root
    }

    private fun signOUt(view: View) {
        binding.apply {

            FirebaseAuth.getInstance().signOut()
            view.findNavController().navigate(HomeFragmentDirections.actionLogout())


        }
        // Hide the keyboard.

    }



}
