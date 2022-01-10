package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // navigation bar and main page
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.setOnClickListener{
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
        val navigationBarCalendar = findViewById<BottomNavigationItemView>(R.id.calendar_navigation)
        navigationBarCalendar.setOnClickListener{
            val Intent = Intent(this, Calendar::class.java)
            startActivity(Intent)
        }
        val navigationBarRecipes = findViewById<BottomNavigationItemView>(R.id.recipes_navigation)
        navigationBarRecipes.setOnClickListener{
            val Intent = Intent(this, Recipes::class.java)
            startActivity(Intent)
        }
        val navigationBarProgress = findViewById<BottomNavigationItemView>(R.id.progress_navigation)
        navigationBarProgress.setOnClickListener{
            val Intent = Intent(this, Progress::class.java)
            startActivity(Intent)
        }


        //Default Buttons
        val homeActivityButton = findViewById<Button>(R.id.home_button)
        homeActivityButton.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        val calendarActivityButton = findViewById<Button>(R.id.calendar_button)
        calendarActivityButton.setOnClickListener {
            val Intent = Intent(this, Calendar::class.java)
            startActivity(Intent)
        }

        val recipesActivityButton = findViewById<Button>(R.id.recipes_button)
        recipesActivityButton.setOnClickListener {
            val Intent = Intent(this, Recipes::class.java)
            startActivity(Intent)
        }

        val progressActivityButton = findViewById<Button>(R.id.progress_button)
        progressActivityButton.setOnClickListener {
            val Intent = Intent(this, Progress::class.java)
            startActivity(Intent)
        }
    }
}