package com.example.diethealth

/**
 * This class create CalendarInfo objects, which store the Recipes that were added for that day
 * This allows users to track what recipes they saved from previous days
 * Lots of this class is commeneted out due to non-functioning web data which does not allow
 * for saves to occur
 *
 * @author Owen Pan
 * @author Jaidon Hill
 * @author Joshua Hill
 *
 * @property year - this is the name of the ingredient
 * @property month - this is the amount of calories per gram of the ingredient
 * @property String - this is the amount of vitamin A per gram of the ingredient
 *
 * Was to initially have a Recipe object as well but was discontinued due to non-functioning
 * web database.
 *
 * Updated 01-12-2022
 */
class CalendarInfo (year: String, month: String, day: String, /*none: Recipe*/){

    val year: String
    val month: String
    val day: String
    /*
    var breakfast: Recipe
    var lunch: Recipe
    var dinner: Recipe
    var snackOne: Recipe
    var snackTwo: Recipe
    */

    /**
     * @constructor
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
    /**
     * Sets the breakfast to whatever recipe or dish inputted by the user
     */
    fun pickBreakfast(/* dish: Recipe */) {
        /* this.breakfast = dish */
    }
    /**
     * Sets the lunch to whatever recipe or dish inputted by the user
     */
    fun pickLunch(/* dish: Recipe */) {
        /* this.lunch = dish */
    }

    /**
     * Sets the dinner to whatever recipe or dish inputted by the user
     */
    fun pickDinner(/* dish: Recipe */) {
        /* this.dinner = dish */
    }
    /**
     * Sets the snack to whatever recipe or dish inputted by the user
     */
    fun pickSnackOne(/* dish: Recipe */) {
        /* this.snackOne = dish */
    }
    /**
     * Sets the snack to whatever recipe or dish inputted by the user
     */
    fun pickSnackTwo(/* dish: Recipe */) {
        /* this.snackTwo = dish */
    }

    /**
     * Returns a string stating the month the recipe is (planned) for
     *
     * @returns the day of the month that the recipe was planned for
     */
    fun findMonth(): String{
        val monthString = when(this.month){
            "0" -> "January"
            "1" -> "February"
            "2" -> "March"
            "3" -> "April"
            "4" -> "May"
            "5" -> "June"
            "6" -> "July"
            "7" -> "August"
            "8" -> "September"
            "9" -> "October"
            "10" -> "November"
            else -> "December"
        }
        return monthString
    }
    /**
     * Returns a string stating the year the recipe is (planned) for
     *
     * @returns the day of the year that the recipe was planned for
     */
    fun findYear():String{
        return this.year
    }
    /**
     * Returns a string stating the day of month the recipe is (planned) for
     *
     * @returns the day of the month that the recipe was planned for
     */
    fun findDay():String{
        return this.day
    }
}