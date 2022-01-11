package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import com.example.diethealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigation bar on main page
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.performClick()
        navigationBarHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
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
        navigationBarProgress.setOnClickListener{
            val intent = Intent(this, Progress::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        //database variables
        //var database = FirebaseDatabase.getInstance()

        database = Firebase.database.reference
       //var dataReference = database.getReference("userInfo")

        var user = User()
        val genders = resources.getStringArray(R.array.gender_array)
        var genderSpinner = binding.genderSpinner
        var genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)
        genderSpinner.adapter = genderAdapter

        val activityLevels = resources.getStringArray(R.array.activity_array)
        var activitySpinner = binding.activitySpinner
        var activityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, activityLevels)
        activitySpinner.adapter = activityAdapter

        binding.submitButton.setOnClickListener{
            if (binding.ageEdittext.text.isNullOrBlank() == false && binding.nameEdittext.text.isNullOrBlank() == false && binding.weightEdittext.text.isNullOrBlank() == false && binding.heightEdittext.text.isNullOrBlank() == false) {
                user.age = binding.ageEdittext.text.toString().toDouble()
                user.name = binding.nameEdittext.text.toString()
                user.weight = binding.weightEdittext.text.toString().toDouble()
                user.height = binding.heightEdittext.text.toString().toDouble()
                user.gender = genderSpinner.selectedItem.toString()
                var aaa = activitySpinner.selectedItem.toString()
                if (aaa == "Low Activity") {
                    user.activityLevel = 1.2
                } else if (aaa == "Low-Medium Activity") {
                    user.activityLevel = 1.375
                } else if (aaa == "Medium Activity") {
                    user.activityLevel = 1.55
                } else if (aaa == "High-Medium Activity") {
                    user.activityLevel = 1.725
                } else {
                    user.activityLevel = 1.9
                }
                binding.testTextview.text = user.gender.toString()
                //adding user to database
                //dataReference.child(user.name).push().setValue(user)
                database.child("test").child(user.name).setValue(user)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
//eee