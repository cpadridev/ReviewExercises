package com.cpadridev.carmonaadrian_reviewexercises.exercise4.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Starship (@SerializedName("name") @Expose var name: String,
                     @SerializedName("model") @Expose var model: String,
                     @SerializedName("films") @Expose var films: ArrayList<String>)