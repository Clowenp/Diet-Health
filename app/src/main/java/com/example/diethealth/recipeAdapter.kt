package com.example.diethealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

/**
 * Helps to put data into recyclerview
 *
 * @author Jaidon & Joshua & Owen
 *
 * Updated 12-Jan-2022:
 *
 * @property recipeList - List of items(recyclerrecipe) in the recyclerview
 */
class RecipeAdapter(val recipeList : ArrayList<RecyclerRecipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>(){





    /**
     * Helps to create ViewHolder
     *
     * @param parent - How to format the data (recyclerview)
     * @param viewType - Type of view (picture, text, etc)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecipeViewHolder {


        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecipeViewHolder(itemView)
    }

    /**
     * Helps create each individual card for each item in the recipelist
     *
     * @param holder - Helps make it that there is an individual card for each item
     * @param position - Which item in the recipe list
     */
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        val currentItem = recipeList[position]
        holder.recipeImage.setImageResource(currentItem.recipeImage)
        holder.recipeTitle.text = currentItem.recipeTitle
        holder.recipeDescription.text = currentItem.recipeDescription

    }

    /**
     * returns the amount of items in the recyclerview
     */
    override fun getItemCount(): Int {
        return recipeList.size
    }

    /**
     * Allows to edit each card/row
     *
     * @author Jaidon & Joshua & Owen
     *
     * Updated 12-Jan-2022:
     *
     * @property itemView - a row/card
     */
    class RecipeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val recipeImage : ShapeableImageView = itemView.findViewById(R.id.recipe_image)
        val recipeTitle : TextView = itemView.findViewById(R.id.recipeTitle)
        val recipeDescription : TextView = itemView.findViewById(R.id.recipe_description)

    }
}