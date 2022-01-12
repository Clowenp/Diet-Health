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


/**
 * Class that runs the progress activity
 *
 * @author Jaidon & Joshua & Owen
 *
 * Updated 12-Jan-2022
 */
class Progress : AppCompatActivity() {
    lateinit var binding: ActivityProgressBinding
    //lateinit var database: DatabaseReference
    lateinit var recipeRecyclerView : RecyclerView
    lateinit var recipeArrayList : ArrayList<RecyclerRecipe>
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var description : Array<String>



    /**
     * When activity is first opened, it runs
     *
     * @param savedInstanceState If there was a previous time where there was data in the activity that it can revert to
     */
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
       title = arrayOf("Chicken Fried Rice", "Egg Fried Rice", "Broccoli and Sweet Potato", "Apple Oatmeal", "Lentil Salad", "Chicken Sandwich")
        description = arrayOf("100g of Chicken Breast with 300g of White Rice. 560 kcal, 30 IU Vit. A, 0 mg Vit. C, 4 g Zinc, 50 mg Calcium, 133 mcg Folate", "100g of Egg with 300g of Brown Rice. 529 kcal, 520 IU Vit. A, 0 mg Vit. C, 4 mg of Zinc, 50 mg Calcium, 43 mcg Folate", "200g of Sweet Potato with 400g of Broccoli. 320 kcal, 44636 IU Vit. A, 280 mg Vit C, 0 mg Zinc, 236 mg Calcium, 442 mcg Folate", "100g of Apple with 200g of Oatmeal. 810 kcal, 54 IU Vit. A, 5 mg Vit. C, 8 mg Zinc, 110 mg Calcium, 5 mcg Folate", "100g of Lentils with 300g of Spinach. 185 kcal, 28139 IU Vit. A, 85 mg Vit. C, 4mg Zinc, 316 mg Calcium, 763 mcg Folate", "200g of Chicken Breast with 100g of Whole Wheat Bread. 590 kcal, 62 IU Vit. A, 0 mg Vit. C, 3 mg Zinc, 200 mg Calcium, 48 mcg Folate")

        recipeRecyclerView = findViewById(R.id.recycler_view)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.setHasFixedSize(true)
        recipeArrayList = arrayListOf<RecyclerRecipe>()
        recipeRecycler()









































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

    /**
     * Constructs the recyclerview
     *
     */
     fun recipeRecycler() {
         for(i in imageId.indices){
             val recipe = RecyclerRecipe(imageId[i], title[i], description[i])
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