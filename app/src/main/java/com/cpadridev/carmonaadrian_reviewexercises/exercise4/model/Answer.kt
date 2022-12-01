package com.cpadridev.carmonaadrian_reviewexercises.exercise4.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Answer (@SerializedName("results") @Expose var results: ArrayList<Starship>)