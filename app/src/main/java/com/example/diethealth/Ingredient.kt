package com.example.diethealth
////vitamin a, vitamin c, zinc, calcium, pholate
class Ingredient(name: String, calorieRate: Double, vitaminARate: Double, vitaminCRate: Double, zincRate: Double, calciumRate: Double, pholateRate: Double, amount: Double = 1.0) {

    val name: String
    val calorieRate: Double
    val vitaminARate: Double
    val vitaminCRate: Double
    val zincRate: Double
    val calciumRate: Double
    val pholateRate: Double
    var amount: Double

    init{
        this.name = name
        this.calorieRate = calorieRate
        this.vitaminARate = vitaminARate
        this.vitaminCRate = vitaminCRate
        this.zincRate = zincRate
        this.calciumRate = calciumRate
        this.pholateRate = pholateRate
        this.amount = amount
    }

    fun calories(): Double{
        return amount*calorieRate
    }

    fun vitaminA(): Double{
        return amount*vitaminARate
    }

    fun vitaminC(): Double{
        return amount*vitaminCRate
    }

    fun zinc(): Double{
        return amount*zincRate
    }

    fun calcium(): Double{
        return amount*calciumRate
    }

    fun pholate(): Double{
        return amount*pholateRate
    }
}