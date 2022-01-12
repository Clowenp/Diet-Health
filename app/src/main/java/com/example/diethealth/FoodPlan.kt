package com.example.diethealth

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.diethealth.databinding.ActivityFoodPlanBinding

/**
 * This class runs the foodplan activity on creation
 *
 * @author Owen Pan
 * @author Joshua Hill
 * @author Jaidon Hill
 *
 *
 * Updated 01-12-2022
 */
class FoodPlan : AppCompatActivity() {
    private lateinit var binding: ActivityFoodPlanBinding

    /**
     * Runs on activity creation
     *
     * @param savedInstanceState - if there was a previous version of the activity saved, it can run it form that point
     */
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
        //making it default empty, since loadRecipes()[6] is fasting, thus to intiilize this variable and keep it empty i set the initial value to the empty fast recipe, which is done for the other addedRecipeValues as well
        var addedBreakfastRecipe = loadRecipes()[6]

        var spinnerSnackOne = binding.spinnerSnackOne
        spinnerSnackOne.adapter = recipeAdapter
        var addedSnackOneRecipe = loadRecipes()[6]

        var spinnerLunch = binding.spinnerLunch
        spinnerLunch.adapter = recipeAdapter
        var addedLunchRecipe = loadRecipes()[6]

        var spinnerSnackTwo = binding.spinnerSnackTwo
        spinnerSnackTwo.adapter = recipeAdapter
        var addedSnackTwoRecipe = loadRecipes()[6]

        var spinnerDinner = binding.spinnerDinner
        spinnerDinner.adapter = recipeAdapter
        var addedDinnerRecipe = loadRecipes()[6]



        //determining the month & day depending on the intent variable
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

        //runs when addBreakfast button is hit
        binding.addBreakfast.setOnClickListener {
            //determining which recipe user wants to add depending on which recipe they chose on the breakfast spinner
            var selectedBreakfastRecipe = spinnerBreakfast.selectedItem.toString()
            addedBreakfastRecipe = when(selectedBreakfastRecipe){
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
        //runs when addSnack button is hit
        binding.addSnack.setOnClickListener {

            //determining which recipe user wants to add depending on which recipe they chose on the snack one spinner
            var selectedSnackOneRecipe = spinnerSnackOne.selectedItem.toString()
            addedSnackOneRecipe = when(selectedSnackOneRecipe){
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
        //runs when addLunch button is hit
        binding.addLunch.setOnClickListener {

            //determining which recipe user wants to add depending on which recipe they chose on the lunch spinner
            var selectedLunchRecipe = spinnerLunch.selectedItem.toString()
            addedLunchRecipe = when(selectedLunchRecipe){
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
        //runs when addSNackTwo button is hit
        binding.addSnackTwo.setOnClickListener {

            //determining which recipe user wants to add depending on which recipe they chose on the snack two spinner
            var selectedSnackTwoRecipe = spinnerSnackTwo.selectedItem.toString()
            addedSnackTwoRecipe = when(selectedSnackTwoRecipe){
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
        //runs when addDinner button is hit
        binding.addDinner.setOnClickListener {

            //determining which recipe user wants to add depending on which recipe they chose on the dinner spinner
            var selectedDinnerRecipe = spinnerDinner.selectedItem.toString()
            addedDinnerRecipe = when(selectedDinnerRecipe){
                "Chicken Fried Rice" -> loadRecipes()[0]
                "Egg Fried Rice" -> loadRecipes()[1]
                "Broccoli and Sweet Potato" -> loadRecipes()[2]
                "Apple Oatmeal" -> loadRecipes()[3]
                "Lentil Salad" -> loadRecipes()[4]
                "Chicken Sandwich" -> loadRecipes()[5]
                else -> loadRecipes()[6]
            }

            Toast.makeText(applicationContext,"Dinner added",Toast.LENGTH_SHORT).show()
        }

        //runs when the calculateButton is hit
        binding.calculateButton.setOnClickListener{
            //determining the toal daily nutritional info depeniiing on which recipes the user chose
            var dailyCalories: Double = addedBreakfastRecipe.getCalories() + addedSnackOneRecipe.getCalories() + addedLunchRecipe.getCalories() + addedSnackTwoRecipe.getCalories() + addedDinnerRecipe.getCalories()
            var dailyVitaminA: Double = addedBreakfastRecipe.getVitaminA() + addedSnackOneRecipe.getVitaminA() + addedLunchRecipe.getVitaminA() + addedSnackTwoRecipe.getVitaminA() + addedDinnerRecipe.getVitaminA()
            var dailyVitaminC: Double = addedBreakfastRecipe.getVitaminC() + addedSnackOneRecipe.getVitaminC() + addedLunchRecipe.getVitaminC() + addedSnackTwoRecipe.getVitaminC() + addedDinnerRecipe.getVitaminC()
            var dailyZinc: Double = addedBreakfastRecipe.getZinc() + addedSnackOneRecipe.getZinc() + addedLunchRecipe.getZinc() + addedSnackTwoRecipe.getZinc() + addedDinnerRecipe.getZinc()
            var dailyCalcium: Double = addedBreakfastRecipe.getCalcium() + addedSnackOneRecipe.getCalcium() + addedLunchRecipe.getCalcium() + addedSnackTwoRecipe.getCalcium() + addedDinnerRecipe.getCalcium()
            var dailyFolate: Double = addedBreakfastRecipe.getFolate() + addedSnackOneRecipe.getFolate() + addedLunchRecipe.getFolate() + addedSnackTwoRecipe.getFolate() + addedDinnerRecipe.getFolate()

            //formatting the information to be used in a textview
            var dailyCaloriesString = dailyCalories.toString() + " kcal"
            binding.dailyCalories.text = dailyCaloriesString

            var dailyVitaminAString = dailyVitaminA.toString() + " IU"
            binding.dailyVitaminA.text = dailyVitaminAString

            var dailyVitaminCString = dailyVitaminC.toString() + " mg"
            binding.dailyVitaminC.text = dailyVitaminCString

            var dailyZincString = dailyZinc.toString() + " mg"
            binding.dailyZinc.text = dailyZincString

            var dailyCalciumString = dailyCalcium.toString() + " mg"
            binding.dailyCalcium.text = dailyCalciumString

            var dailyFolateString = dailyFolate.toString() + " mcg"
            binding.dailyFolate.text = dailyFolateString
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