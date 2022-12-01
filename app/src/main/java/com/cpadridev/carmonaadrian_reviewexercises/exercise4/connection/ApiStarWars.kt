package com.cpadridev.carmonaadrian_reviewexercises.exercise4.connection

import com.cpadridev.carmonaadrian_reviewexercises.exercise4.model.Answer
import retrofit2.Call
import retrofit2.http.*

interface ApiStarWars {
    @GET("starships")
    fun getStarships(): Call<Answer>
}