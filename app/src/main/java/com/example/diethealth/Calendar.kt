package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diethealth.databinding.ActivityCalendarBinding
import com.example.diethealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import java.time.Year

class Calendar : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    var map = mutableMapOf("2004/3/17" to CalendarInfo("2004","3","17") )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        Somehow save the map information on some file and initialize it every time
         */

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            var date = "$year/$month/$dayOfMonth"

            binding.viewPlan.setOnClickListener{
                println(date)
                if(map[date]!=null){
                    println("Already created")
                }else{
                    println("First Time")
                    map.put(date, CalendarInfo(year.toString(),month.toString(),dayOfMonth.toString()))
                    println(date)
                }
                val intent = Intent(this, FoodPlan::class.java)
                intent.putExtra("year", year.toString())
                intent.putExtra("month", month.toString())
                intent.putExtra("day",dayOfMonth.toString())
                startActivity(intent)
            }

        }

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


class MapInfo(){
    var map: MutableMap<String,CalendarInfo>

    init{
        this.map = mutableMapOf("2004317" to CalendarInfo("2004","3","17"))
    }

    fun addDate (year: Int, month: Int, day: Int){
        val date = "$year/$month/$day"
        map.put(date,CalendarInfo(year.toString(),month.toString(), day.toString()))
    }

    fun findDate (year: Int, month:Int, day:Int): Boolean{
        val date = "$year/$month/$day"
        return map[date]==null
    }

}