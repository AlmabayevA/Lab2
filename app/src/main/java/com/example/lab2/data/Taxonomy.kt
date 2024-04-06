package com.example.lab2.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Taxonomy(
    @SerializedName ("class")
    val classOfAnimal: String,
    val family: String,
    val genus: String,
    val kingdom: String,
    val order: String,
    val phylum: String,
    @SerializedName ("scientific_name")
    val scientificName: String
): Serializable