package com.most4dev.countriesapp.presentation.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(message: String){
    if (message.isNotEmpty()){
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
    }

}