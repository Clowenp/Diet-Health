package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.diethealth.databinding.ActivityMainBinding
import com.example.diethealth.databinding.ActivityRecipesBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * This class runs the recipes activity on creation
 *
 * @author Joshua Hill
 * @author Owen Pan
 * @author Jaidon Hill
 *
 *
 * Updated 01-12-2022
 */
class Recipes : AppCompatActivity() {
    private lateinit var binding: ActivityRecipesBinding

    /**
     * Runs on activity creation
     *
     * @param savedInstanceState - if there was a previous version of the activity saved, it can run it form that point
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
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
            val intent = Intent(this, Calendars::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }
        val navigationBarRecipes = findViewById<BottomNavigationItemView>(R.id.recipes_navigation)
        navigationBarRecipes.performClick()
        navigationBarRecipes.setOnClickListener{
            val intent = Intent(this, Recipes::class.java)
            startActivity(intent)
        }
        val navigationBarProgress = findViewById<BottomNavigationItemView>(R.id.progress_navigation)
        navigationBarProgress.setOnClickListener{
            val intent = Intent(this, Progress::class.java)
            overridePendingTransition(0,0)
            startActivity(intent)
        }

        //databse variables
        var database = FirebaseDatabase.getInstance()
        //sending data to recipe branch in databse
        var dataReference = database.getReference("recipes")

        //spinner variables
        var ingredientSpinner = binding.ingredientSpinner
        //getting list of ingredient names from strings.xml
        val ingredientArray = resources.getStringArray(R.array.ingredient_array)
        var ingredientAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ingredientArray)
        ingredientSpinner.adapter = ingredientAdapter

        //misc variables
        //setting default value for addedIngredient
        var addedIngredient : Ingredient = loadIngredientList()[0]
        var ingredientList = mutableListOf<Ingredient>()
        var recipeList = mutableListOf<Recipe>()

        //image variables
        val ingredientImage : ImageView = binding.ingredientImageView


        //runs when addIngredientButton is pressed
        binding.addIngredientButton.setOnClickListener{
            //only running if user fills out amountEditText field
            if(binding.amountEditText.text.isNullOrBlank() == false){
                var selectedIngredient = ingredientSpinner.selectedItem.toString()
                //changing the value of addedIngredient depending on the ingredient selected on ingredientSpinner
                when(selectedIngredient){
                    "Large Egg" -> addedIngredient = loadIngredientList()[0]
                    "Whole Wheat Bread" -> addedIngredient = loadIngredientList()[1]
                    "Cooked Broccoli" -> addedIngredient = loadIngredientList()[2]
                    "Chicken Breast" -> addedIngredient = loadIngredientList()[3]
                    "Apple" -> addedIngredient = loadIngredientList()[4]
                    "Fasting" -> addedIngredient = loadIngredientList()[5]
                    "Oatmeal" -> addedIngredient = loadIngredientList()[6]
                    "Raw Spinach" -> addedIngredient = loadIngredientList()[7]
                    "Sweet Potato" -> addedIngredient = loadIngredientList()[8]
                    "White Rice" -> addedIngredient = loadIngredientList()[9]
                    "Brown Rice" -> addedIngredient = loadIngredientList()[10]
                    "Lentils" -> addedIngredient = loadIngredientList()[11]
                }

                //changing the image depending on the ingredient selected on ingredientSpinner
                var ingredientDrawable = when(selectedIngredient){
                    "Large Egg" -> R.drawable.egg
                    "Whole Wheat Bread" -> R.drawable.bread
                    "Cooked Broccoli" -> R.drawable.broccoli
                    "Chicken Breast" -> R.drawable.chicken
                    "Apple" -> R.drawable.apple
                    "Fasting" -> R.drawable.fasting
                    "Oatmeal" -> R.drawable.oatmeal
                    "Raw Spinach" -> R.drawable.spinach
                    "Sweet Potato" -> R.drawable.sweet_potato
                    "White Rice" -> R.drawable.white_rice
                    "Brown Rice" -> R.drawable.brown_rice
                    else -> R.drawable.lentils
                }
                ingredientImage.setImageResource(ingredientDrawable)

                //changing the amount parameter of the addedIngredient object depening on what
                addedIngredient.amount = binding.amountEditText.text.toString().toDouble()
                ingredientList.add(addedIngredient)
                Toast.makeText(applicationContext, "${addedIngredient.amount} grams of ${addedIngredient.name} added", Toast.LENGTH_SHORT).show()

            } else {
                //bringing up toast msg if amount of ingredients arent written by user
                Toast.makeText(applicationContext, "fill out all fields!", Toast.LENGTH_SHORT).show()

            }


        }

        //runs when clearRecipeButton is clicked
        binding.clearRecipeButton.setOnClickListener{
            //clearing ingredientList, and amountEditText field
            ingredientList = mutableListOf<Ingredient>()
            binding.amountEditText.text = null
            Toast.makeText(applicationContext, "Recipe Cleared!", Toast.LENGTH_SHORT).show()

        }

        //runs when finishRecipeButton is clocked
        binding.finishRecipeButton.setOnClickListener{
            //making it only run when all fields are filled out
            if(binding.amountEditText.text.isNullOrBlank() == false && binding.recipeNameEditText.text.isNullOrBlank() == false){
                //making the recipe object based on the selccted ingredients
                var finishedRecipe = Recipe(ingredientList, binding.recipeNameEditText.text.toString())
                //pushing the finished recipe to the databse under the recipe branch, making a node with the name of the recipe and child branches with the parameters of the recipe object
                dataReference.child(finishedRecipe.name).push().setValue(finishedRecipe)
                //reseting/clearing textfields and variables
                addedIngredient = loadIngredientList()[0]
                binding.amountEditText.text = null
                binding.recipeNameEditText.text = null
                Toast.makeText(applicationContext, "Recipe Saved to Database!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "fill out all fields!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    /**
     * Returns the list of ingredients in the app
     *
     * @returns will return the list of ingredients as a list of ingredient
     */
    fun loadIngredientList(): List<Ingredient>{
        return listOf<Ingredient>(
            Ingredient("Large Egg", 1.6, 5.2, 0.0, 0.01, 0.5, 0.4),
            Ingredient("Whole Wheat Bread", 2.5, 0.02, 0.0, 0.01, 1.6, 0.4),
            Ingredient("Cooked Broccoli", 0.35, 15.5, 0.6, 0.0, 0.4, 1.1),
            Ingredient("Chicken Breast",1.7, 0.3, 0.0, 0.01, 0.2, 0.04),
            Ingredient("Apple",0.52, 0.54, 0.05, 0.00, 0.06, 0.03),
            Ingredient("Fasting", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
            Ingredient("Oatmeal",3.79, 0.0, 0.0, 0.04, 0.52, 0.32),
            Ingredient("Raw Spinach",0.23, 93.77, 0.28, 0.01, 0.99, 1.94),
            Ingredient("Sweet Potato",0.9, 192.18, 0.20, 0.0, 0.38, 0.01),
            Ingredient("White Rice",1.3, 0.0, 0.0, 0.01, 0.1, 0.43),
            Ingredient("Brown Rice",1.23, 0.0, 0.0, 0.01, 0.0, 0.01),
            Ingredient("Lentils",1.16, 0.08, 0.01, 0.01, 0.19, 1.81)



        )
    }
}