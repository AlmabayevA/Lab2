package com.example.lab2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2.data.AnimalModel

class AnimalDiffUtil : DiffUtil.ItemCallback<AnimalModel>() {
    override fun areItemsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
        return oldItem == newItem
    }
}