package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.diethealth.databinding.ActivityMainBinding
import com.example.diethealth.databinding.ActivityRecipesBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView

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
        binding.ingredientButton.setOnClickListener{

            var selectedIngredient = ingredientSpinner.selectedItem.toString()
            when(selectedIngredient){
                "Large Egg" -> addedIngredient = loadIngredientList()[0]
                "Whole Wheat Bread" -> addedIngredient = loadIngredientList()[1]
                "Cooked Broccoli" -> addedIngredient = loadIngredientList()[2]
                "Chicken Breast" -> addedIngredient = loadIngredientList()[3]
            }
        }

        binding.addIngredientButton.setOnClickListener{
            addedIngredient.amount = binding.amountEditText.text.toString().toDouble()
            ingredientList.add(addedIngredient)

        }

    }

    fun loadIngredientList(): List<Ingredient>{
        return listOf<Ingredient>(
            Ingredient("Large Egg", "number", 78.0, 260.0, 0.0, 0.5, 25.0, 22.0),
            Ingredient("Whole Wheat Bread", "slices", 91.0, 1.1, 0.0, 0.6, 58.0, 15.1),
            Ingredient("Cooked Broccoli", "cups", 34.0, 1501.6, 63.0, 0.4, 38.8, 104.8),
            Ingredient("Chicken Breast", "cups", 424.6, 71.2, 0.0, 3.0, 36.8, 9.8)


        )
    }
}