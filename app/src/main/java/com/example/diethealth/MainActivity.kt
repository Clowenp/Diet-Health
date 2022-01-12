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
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isInvisible
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Calendar
import java.text.DateFormat
import kotlin.math.roundToInt

/**
 * Class that runs main activity
 *
 * @author Jaidon & Joshua & Owen
 *
 * Updated 12-Jan-2022
 */
class MainActivity : AppCompatActivity() {

    // allows to use binding. instead of using searchById for View
    private lateinit var binding: ActivityMainBinding
//    private lateinit var database: DatabaseReference

//    private lateinit var ref: DatabaseReference

    /**
     * When activity is first opened, it runs
     *
     * @param savedInstanceState If there was a previous time where there was data in the activity that it can revert to
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var calendar = Calendar.getInstance()
        var currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime())

        binding.date.text = currentDate

        binding.greyBackground.isInvisible = true

//        val myRef = Firebase.database.reference

//        binding.button.setOnClickListener {
//            println(myRef.child("userInfo").get().toString())
//        }

//        ref = FirebaseDatabase.getInstance().getReference("recipes")
//        println("here")
//        ref.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                println("here1")
//                if(snapshot.exists()){
//                    for(i in snapshot.children){
//                         println(i.getValue().toString())
//                    }
//                }
//            }
//            override fun onCancelled(error: DatabaseError) {
//            }
//        })
//        println("here2")

//        var databaseTwo = FirebaseDatabase.getInstance().getReference().child("recipes")
//        binding.button.setOnClickListener {
//            println("here?")
//
//
//            var getdata = object: ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    var name = snapshot.getValue().toString()
//                    println("$name + PLEASE WORK")
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//            }
//            databaseTwo.addValueEventListener(getdata)
//            databaseTwo.addListenerForSingleValueEvent(getdata)
//        }

        // navigation bar on main page - creates an intent object which allows us to switch into
        // the new class when object is inputted
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.performClick()
        navigationBarHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val navigationBarCalendar = findViewById<BottomNavigationItemView>(R.id.calendar_navigation)
        navigationBarCalendar.setOnClickListener{
            val intent = Intent(this, Calendars::class.java)
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

        // database = Firebase.database.reference
        //var dataReference = database.getReference("userInfo")

        var user = User()
        // gets gender options from a string file
        val genders = resources.getStringArray(R.array.gender_array)
        var genderSpinner = binding.genderSpinner
        // allows to insert strings into gender spinner(dropdown list)
        var genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)
        genderSpinner.adapter = genderAdapter

        // gets activity level options from a string file
        val activityLevels = resources.getStringArray(R.array.activity_array)
        var activitySpinner = binding.activitySpinner
        // allows to use strings in the spinner
        var activityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, activityLevels)
        activitySpinner.adapter = activityAdapter

        val isChecked = binding.switch1.isChecked
        if(isChecked){
            //Make information private for others when recipe is created
        }else{
            //Make information public for others when recipe is created
        }


        // when the submit button is clicked
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
                binding.testTextview.text = user.gender

                if(user.gender=="Female"){
                    binding.imageView.setImageResource(R.drawable.female)
                }else{
                    binding.imageView.setImageResource(R.drawable.male)
                }

                binding.textView.text = "${user.name}'s Expected Daily Intake"
                binding.textView2.text = "Calories"
                binding.textView3.text = "Vitamin A"
                binding.textView4.text = "Vitamin C"
                binding.textView5.text = "Zinc"
                binding.textView6.text = "Calcium"
                binding.textView7.text = "Folate"


                val calories = user.metabolicRate().roundToInt()
                binding.textView8.text = "$calories kcal"

                val vitA = user.dailyVitaminAIntake()
                binding.textView9.text = "$vitA IU"

                val vitC = user.dailyVitaminCIntake()
                binding.textView10.text = "$vitC mg"

                val zinc = user.dailyZincIntake()
                binding.textView11.text = "$zinc mg"

                val calcium = user.dailyCalciumIntake()
                binding.textView12.text = "$calcium mg"

                val folate = user.dailyFolateIntake()
                binding.textView13.text = "$folate μg"

                binding.greyBackground.isInvisible = false

                //adding user to database
                //dataReference.child(user.name).push().setValue(user)
                // database.child("test").setValue(user)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                binding.greyBackground.isInvisible = true
            }
        }



    }


}