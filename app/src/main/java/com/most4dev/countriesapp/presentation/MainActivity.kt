package com.most4dev.countriesapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.most4dev.countriesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}