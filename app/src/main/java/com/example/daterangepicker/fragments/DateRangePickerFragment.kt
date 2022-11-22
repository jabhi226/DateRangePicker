package com.example.daterangepicker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daterangepicker.R
import com.example.daterangepicker.databinding.FragmentDateRangePickerBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker

class DateRangePickerFragment : Fragment() {

    private var _binding: FragmentDateRangePickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDateRangePickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openDateRangePicker()
        binding.dateRangePicker.setOnClickListener {
            openDateRangePicker()
        }
    }

    private fun openDateRangePicker() {
        val constraintBuilder = CalendarConstraints.Builder()
        constraintBuilder.setValidator(DateValidatorPointBackward.now())

        val builder = MaterialDatePicker.Builder.dateRangePicker()
        builder.setTheme(R.style.DateRangePicker_CustomTheme)
        builder.setCalendarConstraints(constraintBuilder.build())

        val datePicker = builder.build()
        datePicker.show(childFragmentManager, "")
    }

}