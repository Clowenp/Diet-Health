package com.example.diethealth
/**
 * An object which has an image, title(name of recipe), and description to be used in recyclerview (scrollable list)
 *
 * @author Jaidon & Joshua & Owen
 *
 * Updated 12-Jan-2022:
 *
 * @property recipeImage - image of dish (stored as R.drawable. which stores as int)
 * @property recipeTitle - name of dish
 * @property recipeDescription - description which has ingredients, kcal, vit a, vit c, zinc, calcium and folate
 */
data class RecyclerRecipe(var recipeImage : Int, var recipeTitle : String, var recipeDescription : String)
