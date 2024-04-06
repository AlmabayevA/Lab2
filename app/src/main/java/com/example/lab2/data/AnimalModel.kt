package com.example.lab2.data

import java.io.Serializable

data class AnimalModel(
    val characteristics: Characteristics,
    val locations: List<String>,
    val name: String,
    val taxonomy: Taxonomy
):Serializable