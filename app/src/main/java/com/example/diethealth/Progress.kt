package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.diethealth.databinding.ActivityMainBinding
import com.example.diethealth.databinding.ActivityProgressBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Progress : AppCompatActivity() {
    private lateinit var binding: ActivityProgressBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigation bar on main page
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarCalendar = findViewById<BottomNavigationItemView>(R.id.calendar_navigation)
        navigationBarCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarRecipes = findViewById<BottomNavigationItemView>(R.id.recipes_navigation)
        navigationBarRecipes.setOnClickListener{
            val intent = Intent(this, Recipes::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarProgress = findViewById<BottomNavigationItemView>(R.id.progress_navigation)
        navigationBarProgress.performClick()
        navigationBarProgress.setOnClickListener{
            val intent = Intent(this, Progress::class.java)
            startActivity(intent)
        }

        binding.readButton.setOnClickListener {
            database = FirebaseDatabase.getInstance().getReference("recipes")
            //binding.readView.text = database.ref.toString()
            database.child("recipes").child("hhh").child("-Mt8o1CqrwFGoV9eSVHv").child("name:").get().addOnSuccessListener {
                binding.readView.text = it.toString()
            }
        }

    }
}