package com.example.lab2.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Characteristics(
    @SerializedName("age_of_sexual_maturity")
    val ageOfSexualMaturity: String,
    @SerializedName("age_of_weaning")
    val ageOfWeaning: String,
    @SerializedName("average_littler_size")
    val averageLittlerSize: String,
    @SerializedName("biggest_threat")
    val biggestThreat: String,
    val color: String,
    @SerializedName("common_name")
    val commonName: String,
    val diet: DietType,
    @SerializedName("estimated_population_size")
    val estimatedPopulationSize: String,
    @SerializedName("gestation_period")
    val gestationPeriod: String,
    val group: String,
    @SerializedName("group_behavior")
    val groupBehavior: String,
    val habitat: String,
    val height: String,
    val lifespan: String,
    val lifestyle: String,
    val location: String,
    @SerializedName("most_distinctive_feature")
    val mostDistinctiveFeature: String,
    @SerializedName("name_of_young")
    val nameOfYoung: String,
    @SerializedName("number_of_species")
    val numberOfSpecies: String,
    val prey: String,
    @SerializedName("skin_type")
    val skinType: String,
    val slogan: String,
    @SerializedName("top_speed")
    val topSpeed: String,
    val weight: String
) : Serializable

enum class DietType{
    Herbivore,
    Omnivore,
    Carnivore
}