package com.example.diethealth

/**
 * This class create ingredient objects, which shows the rate of calories, vitamina, vitaminC, zinc, calcium and folate per gram of the ingredient. The parameters are used to ccalculate the amount of each nutrient in the ingredient.
 *
 * @author Joshua Hill
 * @author Jaidon Hill
 * @author Owen Pan
 *
 * @property name - this si the name of the ingredient
 * @property calorieRate - this is the amount of calories per gram of the ingredient
 * @property vitaminARate - this is the amount of vitamin A per gram of the ingredient
 * @property vitaminCRate - this is the amount of vitaminC per gram of the ingredient
 * @property zincRate - this is the amount of zinc per gram of the ingredient
 * @property calciumRate - this is the amount of calcium per gram of the ingredient
 * @property folateRate - this is the amount of folate per gram of the ingredient
 * @property amount - this is the amount of grams of the ingredient
 *
 * Updated 01-12-2022
 */
class Ingredient(name: String, calorieRate: Double, vitaminARate: Double, vitaminCRate: Double, zincRate: Double, calciumRate: Double, folateRate: Double, amount: Double = 1.0) {

    val name: String
    val calorieRate: Double
    val vitaminARate: Double
    val vitaminCRate: Double
    val zincRate: Double
    val calciumRate: Double
    val folateRate: Double
    var amount: Double

    /**
     * @constructor
     */
    init{
        this.name = name
        this.calorieRate = calorieRate
        this.vitaminARate = vitaminARate
        this.vitaminCRate = vitaminCRate
        this.zincRate = zincRate
        this.calciumRate = calciumRate
        this.folateRate = folateRate
        this.amount = amount
    }

    /**
     * Returns the total amount of calories in the ingredient
     *
     * @returns will return the amount of calories as a Double
     */
    fun calories(): Double{
        return amount*calorieRate
    }

    /**
     * Returns the total amount of vitamin A in the ingredient
     *
     * @returns will return the amount of vitamin A as a Double
     */
    fun vitaminA(): Double{
        return amount*vitaminARate
    }

    /**
     * Returns the total amount of vitamin C in the ingredient
     *
     * @returns will return the amount of vitamin C as a Double
     */
    fun vitaminC(): Double{
        return amount*vitaminCRate
    }

    /**
     * Returns the total amount of zinc in the ingredient
     *
     * @returns will return the amount of zinc as a Double
     */
    fun zinc(): Double{
        return amount*zincRate
    }

    /**
     * Returns the total amount of calcium in the ingredient
     *
     * @returns will return the amount of calcium as a Double
     */
    fun calcium(): Double{
        return amount*calciumRate
    }

    /**
     * Returns the total amount of folate in the ingredient
     *
     * @returns will return the amount of folate as a Double
     */
    fun folate(): Double{
        return amount*folateRate
    }
}