package com.example.diethealth

class Recipe(ingredients : List<Ingredient>, name : String = "Recipe") {
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

    fun getCalories(): Double{
        var totalCalories: Double = 0.0
        for(i in ingredients.indices){
            totalCalories += ingredients[i].calories()
        }
        return totalCalories
    }

    fun getVitaminA(): Double{
        var totalVitaminA: Double = 0.0
        for(i in ingredients.indices){
            totalVitaminA += ingredients[i].vitaminA()
        }
        return totalVitaminA
    }

    fun getVitaminC(): Double{
        var totalVitaminC: Double = 0.0
        for(i in ingredients.indices){
            totalVitaminC += ingredients[i].vitaminC()
        }
        return totalVitaminC
    }

    fun getZinc(): Double{
        var totalZinc: Double = 0.0
        for(i in ingredients.indices){
            totalZinc += ingredients[i].zinc()
        }
        return totalZinc
    }

    fun getCalcium(): Double{
        var totalCalcium: Double = 0.0
        for(i in ingredients.indices){
            totalCalcium += ingredients[i].calcium()
        }
        return totalCalcium
    }

    fun getFolate(): Double{
        var totalFolate: Double = 0.0
        for(i in ingredients.indices){
            totalFolate += ingredients[i].folate()
        }
        return totalFolate
    }


}