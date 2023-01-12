package com.most4dev.countriesapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.most4dev.countriesapp.R
import com.most4dev.countriesapp.databinding.ActivityMainBinding
import com.most4dev.countriesapp.presentation.utils.showSnackBar
import com.most4dev.countriesapp.presentation.viewModels.CheckConnection

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var connection: CheckConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        connection = CheckConnection(application = application)
        connection.observe(this){
            if (!it){
                binding.root.showSnackBar(getString(R.string.error_connect))
            }
        }
    }
}