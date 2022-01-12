package com.example.diethealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diethealth.databinding.ActivityMainBinding
import com.example.diethealth.databinding.ActivityProgressBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.io.File
import java.io.FileInputStream
import java.io.InputStream



class Progress : AppCompatActivity() {
    lateinit var binding: ActivityProgressBinding
    lateinit var database: DatabaseReference
    lateinit var recipeRecyclerView : RecyclerView
    lateinit var recipeArrayList : ArrayList<RecyclerRecipe>
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigation bar on main page
        val navigationBarHome = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        navigationBarHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            overridePendingTransition(0, 0)
            startActivity(intent)
        }
        val navigationBarCalendar = findViewById<BottomNavigationItemView>(R.id.calendar_navigation)
        navigationBarCalendar.setOnClickListener {
            val intent = Intent(this, Calendars::class.java)
            overridePendingTransition(0, 0)
            startActivity(intent)
        }
        val navigationBarRecipes = findViewById<BottomNavigationItemView>(R.id.recipes_navigation)
        navigationBarRecipes.setOnClickListener {
            val intent = Intent(this, Recipes::class.java)
            overridePendingTransition(0, 0)
            startActivity(intent)
        }
        val navigationBarProgress = findViewById<BottomNavigationItemView>(R.id.progress_navigation)
        navigationBarProgress.performClick()
        navigationBarProgress.setOnClickListener {
            val intent = Intent(this, Progress::class.java)
            startActivity(intent)
        }

       imageId = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f)
       title = arrayOf("Chicken and White Rice", "Eggs and Brown Rice", "Brocoli and Sweet Potato", "Apple and Oatmeal", "Lentil and Spinach", "Chicken Sandwich")

        recipeRecyclerView = findViewById(R.id.recycler_view)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.setHasFixedSize(true)
        recipeArrayList = arrayListOf<RecyclerRecipe>()
        getUserData()









































        //binding.readButton.setOnClickListener {
           // FirebaseDatabase.getInstance().getReference("recipes")
           // var ggg = database.child("recipes").child("-MtA-0x_vFfo3An0uqlO").child("name").get()
           // binding.readView.text = ss.toString()

           // var dataRef = FirebaseDatabase.getInstance().getReference("recipes")
            //database = FirebaseDatabase.getInstance().getReference("recipes")
           // val postListener = object : ValueEventListener {
               // override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                  //  val post = dataSnapshot.getValue<Recipe>()
                    // ...
                 //   if (post != null) {
                 //       binding.readView.text = post.name.toString()
                   // }
             //   }

               // override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

              //  }
         //   }
           // dataRef.addValueEventListener(postListener)






    }

     fun getUserData() {
         for(i in imageId.indices){
             val recipe = RecyclerRecipe(imageId[i], title[i])
             recipeArrayList.add(recipe)
         }
         recipeRecyclerView.adapter = RecipeAdapter(recipeArrayList)

    }
}

//binding.readView.text = database.ref.toString()
//database.child("recipes").child("name").parent
//binding.readView.text = it.toString()
// val testFile = File("test.txt")
//  var testData = FileInputStream(testFile).bufferedReader()
// binding.readView.text = testData.toString()