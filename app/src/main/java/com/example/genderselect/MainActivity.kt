// MainActivity.kt
package com.example.genderselect

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var btnSubmit: View
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        radioGroup = findViewById(R.id.radioGroup)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvResult = findViewById(R.id.tvResult)

        btnSubmit.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId != -1) {
                val radioButton = findViewById<RadioButton>(selectedId)
                val gender = radioButton.text.toString()

                // Display the result on the screen
                tvResult.text = "Selected Gender: $gender"

                // Log the result in the console
                Log.d("GenderSelectionApp", "Selected Gender: $gender")
            } else {
                // Handle the case where no gender is selected
                tvResult.text = "Please select a gender."
            }
        }
    }
}