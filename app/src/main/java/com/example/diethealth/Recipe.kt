package com.example.diethealth

class Recipe(ingredients: List<Ingredient>, name: String = "Recipe") {
    val ingredients: List<Ingredient>
    val name: String

    init{
        this.ingredients = ingredients
        this.name = name
    }


}