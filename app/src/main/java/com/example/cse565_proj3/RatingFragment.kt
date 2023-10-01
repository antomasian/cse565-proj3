package com.example.cse565_proj3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.cse565_proj3.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {
    private var _binding: FragmentRatingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRatingBinding.inflate(inflater, container, false)
        binding.nextButton.isEnabled = false
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_RatingFragment_to_InterestsFragment)
        }

        binding.editText.addTextChangedListener {
            binding.nextButton.isEnabled = it.toString().isNotEmpty()
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.yesRB -> binding.emailET.visibility = View.VISIBLE
                R.id.noRB -> binding.emailET.visibility = View.GONE
            }
        }

    }
}