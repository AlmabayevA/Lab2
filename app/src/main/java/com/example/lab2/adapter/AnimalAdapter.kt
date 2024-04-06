package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab2.R
import com.example.lab2.data.AnimalModel
import com.example.lab2.data.DietType
import com.example.lab2.databinding.ItemAnimalBinding


class AnimalAdapter(private val callback:OnDetailsClick) : ListAdapter<AnimalModel, AnimalAdapter.ViewHolder>(AnimalDiffUtil()) {

    interface OnDetailsClick{
        fun onClick(animal: AnimalModel)
    }

    inner class ViewHolder(
        private val binding: ItemAnimalBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(animal: AnimalModel){
            binding.details.setOnClickListener{
                callback.onClick(animal)
            }
            binding.name.text = animal.name
            binding.description.text = listOf(
                animal.taxonomy.classOfAnimal,
                animal.characteristics.diet,
                animal.characteristics.lifespan,
                animal.characteristics.weight,
                animal.characteristics.height
            ).joinToString(separator = ", ")
            val iconId = when(animal.characteristics.diet){
                DietType.Carnivore -> R.drawable.ic_carnivore
                DietType.Herbivore -> R.drawable.ic_herbivore
                else -> R.drawable.ic_omnivore
            }
            binding.image.setImageResource(iconId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((getItem(position)))
    }
}