package com.example.diethealth

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
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

        //spinner variables
        val recipeArray = resources.getStringArray(R.array.recipe_array)
        var recipeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, recipeArray)

        var spinnerBreakfast = binding.spinnerBreakfast
        spinnerBreakfast.adapter = recipeAdapter

        var spinnerSnackOne = binding.spinnerSnackOne
        spinnerSnackOne.adapter = recipeAdapter

        var spinnerLunch = binding.spinnerLunch
        spinnerLunch.adapter = recipeAdapter

        var spinnerSnackTwo = binding.spinnerSnackTwo
        spinnerSnackTwo.adapter = recipeAdapter

        var spinnerDinner = binding.spinnerDinner
        spinnerDinner.adapter = recipeAdapter




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

            var selectedBreakfastRecipe = spinnerBreakfast.selectedItem.toString()
            var addedBreakfastRecipe = when(selectedBreakfastRecipe){
                "Chicken Fried Rice" -> loadRecipes()[0]
                "Egg Fried Rice" -> loadRecipes()[1]
                "Broccoli and Sweet Potato" -> loadRecipes()[2]
                "Apple Oatmeal" -> loadRecipes()[3]
                "Lentil Salad" -> loadRecipes()[4]
                "Chicken Sandwich" -> loadRecipes()[5]
                else -> loadRecipes()[6]
            }

            Toast.makeText(applicationContext,"Breakfast added",Toast.LENGTH_SHORT).show()
        }
        binding.addSnack.setOnClickListener {

            var selectedSnackOneRecipe = spinnerSnackOne.selectedItem.toString()
            var addedSnackOneRecipe = when(selectedSnackOneRecipe){
                "Chicken Fried Rice" -> loadRecipes()[0]
                "Egg Fried Rice" -> loadRecipes()[1]
                "Broccoli and Sweet Potato" -> loadRecipes()[2]
                "Apple Oatmeal" -> loadRecipes()[3]
                "Lentil Salad" -> loadRecipes()[4]
                "Chicken Sandwich" -> loadRecipes()[5]
                else -> loadRecipes()[6]
            }

            Toast.makeText(applicationContext,"Snack added",Toast.LENGTH_SHORT).show()
        }
        binding.addLunch.setOnClickListener {

            var selectedLunchRecipe = spinnerLunch.selectedItem.toString()
            var addedLunchRecipe = when(selectedLunchRecipe){
                "Chicken Fried Rice" -> loadRecipes()[0]
                "Egg Fried Rice" -> loadRecipes()[1]
                "Broccoli and Sweet Potato" -> loadRecipes()[2]
                "Apple Oatmeal" -> loadRecipes()[3]
                "Lentil Salad" -> loadRecipes()[4]
                "Chicken Sandwich" -> loadRecipes()[5]
                else -> loadRecipes()[6]
            }

            Toast.makeText(applicationContext,"Lunch added",Toast.LENGTH_SHORT).show()
        }
        binding.addSnackTwo.setOnClickListener {
            Toast.makeText(applicationContext,"Snack added",Toast.LENGTH_SHORT).show()
        }
        binding.addDinner.setOnClickListener {
            Toast.makeText(applicationContext,"Dinner added",Toast.LENGTH_SHORT).show()
        }

    }
}

fun loadRecipes(): List<Recipe>{
    val r1 = listOf<Ingredient>(Ingredient("Chicken Breast",1.7, 0.3, 0.0, 0.01, 0.2, 0.04, 100.0), Ingredient("White Rice",1.3, 0.0, 0.0, 0.01, 0.1, 0.43, 300.0))
    val r2 = listOf<Ingredient>(Ingredient("Large Egg", 1.6, 5.2, 0.0, 0.01, 0.5, 0.4, 100.0), Ingredient("Brown Rice",1.23, 0.0, 0.0, 0.01, 0.0, 0.01, 300.0))
    val r3 = listOf<Ingredient>(Ingredient("Cooked Broccoli", 0.35, 15.5, 0.6, 0.0, 0.4, 1.1, 400.0), Ingredient("Sweet Potato",0.9, 192.18, 0.20, 0.0, 0.38, 0.01, 200.0))
    val r4 = listOf<Ingredient>(Ingredient("Apple",0.52, 0.54, 0.05, 0.00, 0.06, 0.03, 100.0), Ingredient("Oatmeal",3.79, 0.0, 0.0, 0.04, 0.52, 0.32, 200.0))
    val r5 = listOf<Ingredient>(Ingredient("Lentils",1.16, 0.08, 0.01, 0.01, 0.19, 1.81, 100.0), Ingredient("Raw Spinach",0.23, 93.77, 0.28, 0.01, 0.99, 1.94, 300.0))
    val r6 = listOf<Ingredient>(Ingredient("Chicken Breast",1.7, 0.3, 0.0, 0.01, 0.2, 0.04, 200.0),  Ingredient("Whole Wheat Bread", 2.5, 0.02, 0.0, 0.01, 1.6, 0.4, 100.0))
    val r7 = listOf<Ingredient>(Ingredient("Fasting", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0))

    return listOf<Recipe>(
        Recipe(r1,"Chicken Fried Rice"),
        Recipe(r2,"Egg Fried Rice"),
        Recipe(r3,"Broccoli and Sweet Potato"),
        Recipe(r4,"Apple Oatmeal"),
        Recipe(r5,"Lentil Salad"),
        Recipe(r6,"Chicken Sandwich"),
        Recipe(r7, "Fast")
    )

}