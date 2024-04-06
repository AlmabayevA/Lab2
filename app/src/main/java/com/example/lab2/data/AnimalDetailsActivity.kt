package com.example.lab2.data

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.data.AnimalModel
import com.example.lab2.data.Characteristics
import com.example.lab2.data.Taxonomy
import com.example.lab2.databinding.ActivityAnimalDetailsBinding

class AnimalDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animal:AnimalModel = intent.getSerializableExtra("ANIMAL") as AnimalModel
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animalDetails.text = listOf(
            animal.characteristics.height,
            animal.characteristics.color,
            animal.characteristics.ageOfSexualMaturity,
            animal.characteristics.ageOfWeaning,
            animal.characteristics.weight,
            animal.characteristics.averageLittlerSize,
            animal.characteristics.biggestThreat,
            animal.characteristics.commonName,
            animal.characteristics.estimatedPopulationSize,
            animal.characteristics.gestationPeriod,
            animal.characteristics.group,
            animal.characteristics.groupBehavior,
            animal.characteristics.habitat,
            animal.characteristics.lifespan,
            animal.characteristics.lifestyle,
            animal.characteristics.location,
            animal.characteristics.mostDistinctiveFeature,
            animal.characteristics.nameOfYoung,
            animal.characteristics.numberOfSpecies,
            animal.characteristics.prey,
            animal.characteristics.skinType,
            animal.characteristics.slogan,
            animal.characteristics.topSpeed,
            animal.taxonomy.classOfAnimal,
            animal.taxonomy.family,
            animal.taxonomy.genus,
            animal.taxonomy.kingdom,
            animal.taxonomy.order,
            animal.taxonomy.phylum,
            animal.taxonomy.scientificName
        ).joinToString(separator = ", ")
    }
}