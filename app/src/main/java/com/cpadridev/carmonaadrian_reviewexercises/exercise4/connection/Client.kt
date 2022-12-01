package com.cpadridev.carmonaadrian_reviewexercises.exercise4.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object{
        private const val URL:String = "https://swapi.dev/api/"
        var retrofit: Retrofit?= null

        fun getClient(): Retrofit? {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            }

            return retrofit
        }
    }
}