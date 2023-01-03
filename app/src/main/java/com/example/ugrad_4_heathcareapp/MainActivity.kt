package com.example.ugrad_4_heathcareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    // Declaring a readonly (assigning only once) variable
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Passing the navigation container
        val fragmentContainerView = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Initializing navigation controller obj
        navController = fragmentContainerView.navController
    }
}