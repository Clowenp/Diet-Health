package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diethealth.databinding.ActivityCalendarsBinding
import com.example.diethealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import java.time.Year

/**
 * This class runs the Calendars activity on creation. shows the calendar and each day of the year,
 * allowing users to navigate to a certain day and add their daily food plans
 *
 * @author Owen Pan
 * @author Joshua Hill
 * @author Jaidon Hill
 *
 *
 * Updated 01-12-2022
 */
class Calendars : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarsBinding

    //Map Variable that matches CalendarInfo objects to check if calendar info was created for that
    //day (was to be stored in database to allow for the reopening of olde rplans
    var map = mutableMapOf("2004/3/17" to CalendarInfo("2004","3","17") )

    /**
     * Runs on activity creation
     *
     * @param savedInstanceState - if there was a previous version of the activity saved, it can run it form that point
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //Calendar view displayed on calendar page, creates calendarInfo object if first time
        //accessing that day
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
            val intent = Intent(this, Calendars::class.java)
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
