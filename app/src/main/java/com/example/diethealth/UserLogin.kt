package com.example.diethealth


/**
 * This class creates object which stores the login info for the users of the app
 *
 * @author Joshua Hill
 * @author Owen Pan
 * @author Jaidon Hill
 *
 * @property username - This is the username of the user
 * @property password - this is the password of the user
 * @property name - this is the name of the user
 * @property email - this is the email of the user
 *
 * Updated 01-12-2022
 */
class UserLogin(username: String, password: String, name: String, email: String) {
    val username: String
    private val password: String
    private val name: String
    private val email: String

    /**
     * @constructor
     */
    init{
        this.username = username
        this.password = password
        this.name = name
        this.email = email
    }

    /**
     * Returns the username of the user
     *
     * @returns will return the username as a String
     */
    fun usernameGet(): String{
        return username
    }

    /**
     * Returns the password of the user
     *
     * @returns will return the password as a String
     */
    private fun getPassword(): String{
        return password
    }

    /**
     * Returns the name of the user
     *
     * @returns will return the name as a String
     */
    private fun getName(): String{
        return name
    }

    /**
     * Returns the email of the user
     *
     * @returns will return the email as a String
     */
    private fun getEmail(): String{
        return email
    }
}