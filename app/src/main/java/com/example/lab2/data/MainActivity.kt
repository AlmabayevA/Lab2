package com.example.lab2.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import com.example.lab2.R
import com.example.lab2.adapter.AnimalAdapter
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.AnimalApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AnimalAdapter.OnDetailsClick {
    private val adapter = AnimalAdapter(this)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchData("")
        binding.animalList.adapter = adapter
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
               query?.let { fetchData(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = true
        })
    }
    override fun onClick(animal: AnimalModel){
        val intent = Intent(this, AnimalDetailsActivity::class.java).putExtra("ANIMAL", animal)

        startActivity(intent)
    }
    private fun fetchData(name:String){
        AnimalApi.instance.getAnimals(name).enqueue(NetworkCallback())

    }
    private inner class NetworkCallback:Callback<List<AnimalModel>>{
        override fun onResponse(call: Call<List<AnimalModel>>, response: Response<List<AnimalModel>>) {
            response.body()?.let { adapter.submitList(it) }
        }

        override fun onFailure(call: Call<List<AnimalModel>>, throwable: Throwable) {
           Toast.makeText(this@MainActivity, throwable.message, Toast.LENGTH_SHORT).show()
            Log.e("ERROR", throwable.message.orEmpty())

        }

    }
}