package com.example.diethealth

class User(name : String = "User", weight : Double = 1.0, height : Double = 1.0, age : Double = 1.0, gender : String = "Male", activityLevel : Double = 1.0){
    var name : String
    var weight : Double
    var height : Double
    var age : Double
    var gender : String
    var activityLevel : Double

    init {
        this.name = name
        this.weight = weight
        this.height = height
        this.age = age
        this.gender = gender
        this.activityLevel = activityLevel
    }

    fun metabolicRate() : Double {
        if (this.gender == "Female") {
            return((655 + (1.9*this.height) + (9.5*this.weight) - (4.7 * this.age))*this.activityLevel)
        } else {
            return((66.5 + (5*this.height) + (13.7*this.weight) - (6.8*this.age))*this.activityLevel)
        }
    }

    fun dailyVitaminAIntake() : Int {
        if (this.age < 0.6) {
            return 400
        } else if (this.age < 1.1) {
            return 500
        } else if (this.age < 4.0) {
            return 300
        } else if (this.age < 9.0) {
            return 400
        } else if (this.age < 14.0) {
            return 600
        } else if (this.gender == "Male") {
            return 900
        } else {
            return 700
        }
    }

    fun dailyVitaminCIntake() : Int {
        if (this.age < 0.6) {
            return 40
        } else if (this.age < 1.1) {
            return 50
        } else if (this.age < 4.0) {
            return 15
        } else if (this.age < 9.0) {
            return 25
        } else if (this.age < 14.0) {
            return 45
        } else if (this.gender == "Male") {
            if (this.age < 19.0) {
                return 75
            } else {
                return 90
            }
        } else if(this.age < 19.0) {
            return 65
        } else {
            return 75
        }
    }

    fun dailyZincIntake() : Int {
        if (this.age < 0.6) {
            return 2
        } else if (this.age < 1.1) {
            return 3
        } else if (this.age < 4.0) {
            return 3
        } else if (this.age < 9.0) {
            return 5
        } else if (this.age < 14.0) {
            return 8
        } else if (this.gender == "Male") {
            return 11
        } else if (this.age < 19.0) {
            return 9
        } else {
            return 8
        }
    }

    fun dailyCalciumIntake() : Int {
        if (this.age < 0.6) {
            return 200
        } else if (this.age < 1.1) {
            return 260
        } else if (this.age < 4.0) {
            return 700
        } else if (this.age < 9.0) {
            return 1000
        } else if (this.age < 19.0) {
            return 1300
        } else if (this.age < 51.0) {
            return 1000
        } else if (this.gender == "Female") {
            return 1200
        } else if (this.age < 71.0) {
            return 1000
        } else{
            return 1200
        }
    }

    fun dailyFolateIntake() : Int {
        if (this.age < 0.6) {
            return 65
        } else if (this.age < 1.1) {
            return 80
        } else if (this.age < 4.0) {
            return 150
        } else if (this.age < 9.0) {
            return 200
        } else if (this.age < 14.0) {
            return 300
        } else{
            return 400
        }
    }
}