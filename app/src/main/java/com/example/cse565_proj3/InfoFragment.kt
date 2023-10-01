package com.example.cse565_proj3

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.cse565_proj3.databinding.FragmentInfoBinding
import java.time.Duration
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    var name = ""
    var gender = ""
    var birthday = Date()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameET.doOnTextChanged { text, _, _, _ ->
            name = text.toString()
        }

        binding.datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, monthOfYear, dayOfMonth)
            birthday = calendar.time
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.maleOption -> gender = "Male"
                R.id.femaleOption -> gender = "Female"
                R.id.otherOption -> gender = "Other"
            }
        }

        binding.nextButton.setOnClickListener {
            clickNext()
        }
    }

    private fun clickNext() {
        println("name: $name, birthday: $birthday, isOver18: ${isOver18(birthday)}")
        binding.nameErrorIV.visibility = if (name.isEmpty()) View.VISIBLE else View.GONE
        binding.bdayErrorIV.visibility = if(!isOver18(birthday)) View.VISIBLE else View.GONE

        if (name.isEmpty() || !isOver18(birthday)) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Please make sure the following conditions are met:")
            builder.setMessage("Name cannot be empty.\nAge must be 18 years or older.")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val alert = builder.create()
            alert.show()
        } else {
            findNavController().navigate(R.id.action_InfoFragment_to_RatingFragment)
        }
    }

    private fun isOver18(birthday: Date): Boolean {
        val birthdayInstant = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

        val period = Period.between(birthdayInstant, LocalDate.now())
        val age = period.years
        println("age is $age")

        return age >= 18
    }

}