// MainActivity.kt
package com.example.genderselect

import android.app.Activity
import android.graphics.Color
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

                // Log the result in the console
                Log.d("GenderSelectionApp", "Selected Gender: $gender")

                // Display the result on the screen with colored text
                if (gender.equals("Male", true)) {
                    tvResult.text = "Selected Gender: $gender"
                    tvResult.setTextColor(Color.BLUE)
                } else if (gender.equals("Female", true)) {
                    tvResult.text = "Selected Gender: $gender"
                    tvResult.setTextColor(Color.parseColor("#FF4081")) // Pink color
                }
            } else {
                // Handle the case where no gender is selected
                tvResult.text = "Please select a gender."
                tvResult.setTextColor(Color.BLACK) // Reset text color
            }
        }
    }
}
