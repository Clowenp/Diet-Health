package com.example.diethealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class RecipeAdapter(val recipeList : ArrayList<RecyclerRecipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>(){







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {


        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        val currentItem = recipeList[position]
        holder.recipeImage.setImageResource(currentItem.recipeImage)
        holder.recipeTitle.text = currentItem.recipeTitle

    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class RecipeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val recipeImage : ShapeableImageView = itemView.findViewById(R.id.recipe_image)
        val recipeTitle : TextView = itemView.findViewById(R.id.recipeTitle)
        val recipeButton : Button = itemView.findViewById(R.id.click_button)

    }
}