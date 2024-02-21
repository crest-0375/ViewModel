package com.practice.viewmodel.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.practice.viewmodel.R
import com.practice.viewmodel.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navView: BottomNavigationView
    lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        val navController = this.findNavController(R.id.nav_host_fragment_container)
        navView = this.findViewById(R.id.bottom_nav_view)

        navView.setupWithNavController(navController)
    }
}