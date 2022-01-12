package com.example.diethealth

/**
 * This class create recipe objects, wich holds the ingredients and name of the recipe, and you can calculate the nutritional info of the recipes
 *
 * @author Joshua Hill
 * @author Jaidon Hill
 * @author Owen Pan
 *
 * @property ingredients - This is the list of the ingredients in the recipe
 * @property name - this is the name of the recipe
 *
 * Updated 01-12-2022
 */
class Recipe(ingredients : List<Ingredient>, name : String = "Recipe") {
    val ingredients: List<Ingredient>
    val name: String

    /**
     * @constructor
     */
    init{
        this.ingredients = ingredients
        this.name = name
    }

    /**
     * Returns the name and list of ingredients parameters of the recipe object
     *
     * @returns will return the name as a string and the ingredients as a list of strings
     */
    fun getInfo(): String{
        var nameList = mutableListOf<String>()
        for(i in ingredients.indices){
            nameList.add(ingredients[i].name)

        }
        return "Name: ${this.name} Ingredients: " + nameList
    }

    /**
     * Returns the total amount of calories in the recipe
     *
     * @returns will return the amount of calories as a Double
     */
    fun getCalories(): Double{
        var totalCalories: Double = 0.0
        for(i in ingredients.indices){
            totalCalories += ingredients[i].calories()
        }
        return totalCalories
    }


    /**
     * Returns the total amount of Vitamin A in the recipe
     *
     * @returns will return the amount of vitamin A as a Double
     */
    fun getVitaminA(): Double{
        var totalVitaminA: Double = 0.0
        for(i in ingredients.indices){
            totalVitaminA += ingredients[i].vitaminA()
        }
        return totalVitaminA
    }

    /**
     * Returns the total amount of vitamin c in the recipe
     *
     * @returns will return the amount of vitamin c as a Double
     */
    fun getVitaminC(): Double{
        var totalVitaminC: Double = 0.0
        for(i in ingredients.indices){
            totalVitaminC += ingredients[i].vitaminC()
        }
        return totalVitaminC
    }

    /**
     * Returns the total amount of zinc in the recipe
     *
     * @returns will return the amount of zinc as a Double
     */
    fun getZinc(): Double{
        var totalZinc: Double = 0.0
        for(i in ingredients.indices){
            totalZinc += ingredients[i].zinc()
        }
        return totalZinc
    }

    /**
     * Returns the total amount of calcium in the recipe
     *
     * @returns will return the amount of calcium as a Double
     */
    fun getCalcium(): Double{
        var totalCalcium: Double = 0.0
        for(i in ingredients.indices){
            totalCalcium += ingredients[i].calcium()
        }
        return totalCalcium
    }

    /**
     * Returns the total amount of folate in the recipe
     *
     * @returns will return the amount of folate as a Double
     */
    fun getFolate(): Double{
        var totalFolate: Double = 0.0
        for(i in ingredients.indices){
            totalFolate += ingredients[i].folate()
        }
        return totalFolate
    }


}