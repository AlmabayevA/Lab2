package com.example.lab2.model
import com.example.lab2.data.AnimalModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

object AnimalApi {

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val instance = retrofit.create(AnimalService::class.java)

    interface AnimalService {
        @GET("animals/")
        fun getAnimals(
            @Query("name") name: String,
            @Header("X-Api-Key") apiKey: String = "uDQWU+6SIKLIk6KHTiYYpw==ttMQhVOeGV30PYa4"
        ): Call<List<AnimalModel>>

    }
}
