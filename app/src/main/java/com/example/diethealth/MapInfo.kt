package com.example.diethealth


/**
 * This class create to store CalendarInfo objects and match it to their dates. This would be stored
 * in database to allow us to easily determine if the object has been created or not. Not currently
 * used because of non-function firebase
 *
 * @author Owen Pan
 * @author Jaidon Hill
 * @author Joshua Hill
 *
 * @property map - this mutable map matches the string, which is the date that the plan was selected
 * and the CalendarInfo object for that date
 *
 * Updated 01-12-2022
 */
class MapInfo(){
    var map: MutableMap<String,CalendarInfo>

    /**
     * @constructor
     */
    init{
        this.map = mutableMapOf("2004317" to CalendarInfo("2004","3","17"))
    }

    /**
     * adds the date to the map so that it is known that a calenderInfo
     * object was created for that date
     *
     * @param year - year of the date as an Integer
     * @param month - month of the date as an Integer
     * @param day - day of the date as an Integer
     */
    fun addDate (year: Int, month: Int, day: Int){
        val date = "$year/$month/$day"
        map.put(date,CalendarInfo(year.toString(),month.toString(), day.toString()))
    }

    /**
     * finds if a calendarInfo object has been created for given date
     *
     * @param year - year of the date as an Integer
     * @param month - month of the date as an Integer
     * @param day - day of the date as an Integer
     *
     * @returns true if no object exists and return false if object already exists
     */
    fun findDate (year: Int, month:Int, day:Int): Boolean{
        val date = "$year/$month/$day"
        return map[date]==null
    }

}