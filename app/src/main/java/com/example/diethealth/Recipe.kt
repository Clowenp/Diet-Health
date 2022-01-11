package com.example.diethealth

class Recipe(ingredients: List<Ingredient>, name: String = "Recipe") {
    val ingredients: List<Ingredient>
    val name: String

    init{
        this.ingredients = ingredients
        this.name = name
    }

    fun getInfo(): String{
        var nameList = mutableListOf<String>()
        for(i in ingredients.indices){
            nameList.add(ingredients[i].name)

        }
        return this.name + nameList
    }


}