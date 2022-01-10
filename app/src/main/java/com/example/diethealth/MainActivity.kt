package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diethealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
            } else { user.activityLevel = 1.9 }
            binding.testTextview.text = user.gender.toString()
        }

    }
}

class User(name : String = "User", weight : Double = 1.0, height : Double = 1.0, age : Double = 1.0, gender : String = "Male", activityLevel : Double = 1.0){
    var name : String
    var weight : Double
    var height : Double
    var age : Double
    var gender : String
    var activityLevel : Double

    init {
        this.name = name
        this.weight = weight
        this.height = height
        this.age = age
        this.gender = gender
        this.activityLevel = activityLevel
    }

    fun metabolicRate() : Double {
        if (this.gender == "Female") {
            return((655 + (1.9*this.height) + (9.5*this.weight) - (4.7 * this.age))*this.activityLevel)
        } else {
            return((66.5 + (5*this.height) + (13.7*this.weight) - (6.8*this.age))*this.activityLevel)
        }

    }

    fun dailyVitaminAIntake() : Int {
        if (this.age < 0.6) {
            return 400
        }
        if (this.age < 1.1) {
            return 500
        }

        if (this.age < 4.0) {
            return 300
        }
        if (this.age < 9.0) {
            return 400
        }
        if (this.age < 14.0) {
            return 600
        }

        if (this.gender == "Male") {
            return 900
        }

        return 700
    }

    fun dailyVitaminCIntake() : Int {
        if (this.age < 0.6) {
            return 40
        }
        if (this.age < 1.1) {
            return 50
        }

        if (this.age < 4.0) {
            return 15
        }
        if (this.age < 9.0) {
            return 25
        }
        if (this.age < 14.0) {
            return 45
        }

        if (this.gender == "Male") {
            if (this.age < 19.0) {
                return 75
            } else {
                return 90
            }
        }
        if (this.age < 19.0) {
            return 65
        }
        return 75
    }

    fun dailyZincIntake() : Int {
        if (this.age < 0.6) {
            return 2
        }
        if (this.age < 1.1) {
            return 3
        }

        if (this.age < 4.0) {
            return 3
        }
        if (this.age < 9.0) {
            return 5
        }
        if (this.age < 14.0) {
            return 8
        }

        if (this.gender == "Male") {
            return 11
        }
        if (this.age < 19.0) {
            return 9
        }
        return 8
    }

    fun dailyCalciumIntake() : Int {
        if (this.age < 0.6) {
            return 200
        }
        if (this.age < 1.1) {
            return 260
        }

        if (this.age < 4.0) {
            return 700
        }
        if (this.age < 9.0) {
            return 1000
        }
        if (this.age < 19.0) {
            return 1300
        }
        if (this.age < 51.0) {
            return 1000
        }

        if (this.gender == "Female") {
            return 1200
        }
        if (this.age < 71.0) {
            return 1000
        }
        return 1200
    }
    fun dailyFolateIntake() : Int {
        if (this.age < 0.6) {
            return 65
        }
        if (this.age < 1.1) {
            return 80
        }

        if (this.age < 4.0) {
            return 150
        }
        if (this.age < 9.0) {
            return 200
        }
        if (this.age < 14.0) {
            return 300
        }
        return 400
    }
}