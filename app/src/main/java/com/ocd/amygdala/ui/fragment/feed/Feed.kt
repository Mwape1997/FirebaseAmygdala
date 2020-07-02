package com.ocd.amygdala.ui.fragment.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ocd.amygdala.app.databinding.FragmentFeedBinding

import com.ocd.amygdala.data.FeedModelDepre
import kotlinx.android.synthetic.main.fragment_feed.*

private lateinit var binding: FragmentFeedBinding

class Feed : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        binding.newPost = FeedModelDepre("Mwape", "This is my post")
        /*
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addName(it)
        }*/

        binding.createPost.setOnClickListener { addName(it) }

        return binding.root
    }

    private fun addName(view: View) {
        /* val editText = findViewById<EditText>(R.id.nickame_edit);
         val textViewName = findViewById<TextView>(R.id.nickname);*/

        binding.apply {
            //binding.nickname.text = binding.nickameEdit.text
            newPost?.post = editText.text.toString()
            invalidateAll()
            binding.editText.visibility = View.GONE
            binding.createPost.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }
    }

}
