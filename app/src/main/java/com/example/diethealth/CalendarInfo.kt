package com.example.diethealth

/**
 * Calendar class with a method to save the date and chosen recipes.
 */
class CalendarInfo (year: String, month: String, day: String, /*none: Recipe*/){

    val year: String
    val month:String
    val day: String
    /*
    var breakfast: Recipe
    var lunch: Recipe
    var dinner: Recipe
    var snackOne: Recipe
    var snackTwo: Recipe
    */

    init{
        this.year = year
        this.month = month
        this.day = day
        /*
        this.breakfast = none
        this.lunch = none
        this.dinner = none
        this.snackOne = none
        this.snackTwo = none
         */
    }

    fun pickBreakfast(/* dish: Recipe */) {
        /* this.breakfast = dish */
    }
    fun pickLunch(/* dish: Recipe */) {
        /* this.lunch = dish */
    }
    fun pickDinner(/* dish: Recipe */) {
        /* this.dinner = dish */
    }
    fun pickSnackOne(/* dish: Recipe */) {
        /* this.snackOne = dish */
    }
    fun pickSnackTwo(/* dish: Recipe */) {
        /* this.snackTwo = dish */
    }
}