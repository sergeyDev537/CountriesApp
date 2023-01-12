package com.most4dev.countriesapp.domain.entity.testt

import com.most4dev.countriesapp.domain.entity.Flags

data class TestItem(
    val flags: Flags,
    val independent: Boolean,
    val name: String
)