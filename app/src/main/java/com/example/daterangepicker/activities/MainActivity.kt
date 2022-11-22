package com.example.daterangepicker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.daterangepicker.R
import com.example.daterangepicker.fragments.DateRangePickerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentToBackStack(DateRangePickerFragment())
    }

    private fun addFragmentToBackStack(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.main_activity_frame, fragment, fragment::class.java.simpleName)
        ft.addToBackStack(this::class.java.simpleName)
        ft.commit()
    }
}