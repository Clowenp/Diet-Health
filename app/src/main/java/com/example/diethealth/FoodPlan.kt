package com.example.diethealth

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diethealth.databinding.ActivityCalendarBinding
import com.example.diethealth.databinding.ActivityFoodPlanBinding

class FoodPlan : AppCompatActivity() {
    private lateinit var binding: ActivityFoodPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //backwards action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        //get intent information from Calendar
        val intent =getIntent()
        val year = intent.getStringExtra("year")

        val month = when(intent.getStringExtra("month")){
            "0" -> "January"
            "1" -> "February"
            "2" -> "March"
            "3" -> "April"
            "4" -> "May"
            "5" -> "June"
            "6" -> "July"
            "7" -> "August"
            "8" -> "September"
            "9" -> "October"
            "10" -> "November"
            else -> "December"
        }

        val day = intent.getStringExtra("day")

        binding.foodPlanDate.setText("$month $day, $year")

        binding.addBreakfast.setOnClickListener {

        }

    }
}