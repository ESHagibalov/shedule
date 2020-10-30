package com.example.exams_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(home())
        setupBottomNavigationBar();

    }

   private fun setupBottomNavigationBar() {
       val bot_navigation : BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bot_nav)
       bot_navigation!!.setOnNavigationItemSelectedListener { item ->
           when(item.itemId) {
               R.id.navigation_home -> {openFragment(home())
                    true}
               R.id.navigation_classes -> {openFragment(classes())
                   true}
               else -> true
           }
       }
   }

   private fun openFragment(fragment: Fragment) {
       supportFragmentManager.beginTransaction()
               .replace(R.id.fr_home, fragment)
               .addToBackStack(null)
               .commit()
   }
}