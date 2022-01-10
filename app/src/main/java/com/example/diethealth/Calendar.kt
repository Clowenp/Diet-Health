package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diethealth.databinding.ActivityCalendarBinding
import com.example.diethealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class Calendar : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
// navigation bar on calendar page
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarCalendar = findViewById<BottomNavigationItemView>(R.id.calendar_navigation)
        navigationBarCalendar.performClick()
        navigationBarCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        val navigationBarRecipes = findViewById<BottomNavigationItemView>(R.id.recipes_navigation)
        navigationBarRecipes.setOnClickListener{
            val intent = Intent(this, Recipes::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarProgress = findViewById<BottomNavigationItemView>(R.id.progress_navigation)
        navigationBarProgress.setOnClickListener{
            val intent = Intent(this, Progress::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }

    }
}