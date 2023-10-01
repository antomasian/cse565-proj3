package com.example.cse565_proj3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cse565_proj3.databinding.FragmentInterestsBinding

class InterestsFragment : Fragment() {
    private var _binding: FragmentInterestsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInterestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            ListItem("Sports", R.drawable.sports, false),
            ListItem("Nightlife", R.drawable.nightlife, false),
            ListItem("Hiking", R.drawable.hiking, false),
            ListItem("Dating", R.drawable.dating, false),
            ListItem("Board Games", R.drawable.boardgames, false),
            ListItem("Video Games", R.drawable.videogames, false),
            ListItem("Nature", R.drawable.nature, false),
            ListItem("Music", R.drawable.music, false),
            ListItem("Travel", R.drawable.travel, false),
            ListItem("Food & Dining", R.drawable.dining, false),
            )

        val adapter = InterestsArrayAdapter(requireContext(), data)
        binding.listView.adapter = adapter

        binding.finishButton.setOnClickListener {
            requireActivity().finish()
        }

    }
}

data class ListItem(val text: String, var image: Int, var isChecked: Boolean)
