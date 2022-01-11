package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.diethealth.databinding.ActivityMainBinding
import com.example.diethealth.databinding.ActivityRecipesBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Recipes : AppCompatActivity() {
    private lateinit var binding: ActivityRecipesBinding

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
            val intent = Intent(this, Calendar::class.java)
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


        var database = FirebaseDatabase.getInstance()
        var dataReference = database.getReference("recipes")

        //spinner
        var ingredientSpinner = binding.ingredientSpinner
        val ingredientArray = resources.getStringArray(R.array.ingredient_array)
        var ingredientAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ingredientArray)
        ingredientSpinner.adapter = ingredientAdapter
        //creating the objects of the ingredient options

        //testing out making recipe
        //show recyclerview of ingredients, then give person ability to choose amount, then they click button to add it to recipe, then they have another button to save recipe?
        var addedIngredient : Ingredient = loadIngredientList()[0]
        var ingredientList = mutableListOf<Ingredient>()
        var recipeList = mutableListOf<Recipe>()


        binding.addIngredientButton.setOnClickListener{
            var selectedIngredient = ingredientSpinner.selectedItem.toString()
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
            addedIngredient.amount = binding.amountEditText.text.toString().toDouble()
            ingredientList.add(addedIngredient)
            Toast.makeText(applicationContext, "${addedIngredient.amount} grams of ${addedIngredient.name} added", Toast.LENGTH_SHORT).show()

        }

        binding.clearRecipeButton.setOnClickListener{
            ingredientList = mutableListOf<Ingredient>()
            binding.amountEditText.text = null
            Toast.makeText(applicationContext, "Recipe Cleared!", Toast.LENGTH_SHORT).show()

        }

        binding.finishRecipeButton.setOnClickListener{
            var finishedRecipe = Recipe(ingredientList, binding.recipeNameEditText.text.toString())
            dataReference.child(finishedRecipe.name).push().setValue(finishedRecipe)
            addedIngredient = loadIngredientList()[0]
            binding.amountEditText.text = null
            binding.recipeNameEditText.text = null
            Toast.makeText(applicationContext, "Recipe: ${binding.recipeNameEditText.toString()} Saved!", Toast.LENGTH_SHORT).show()
        }

    }

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