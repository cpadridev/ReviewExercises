package com.cpadridev.carmonaadrian_reviewexercises.exercise4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cpadridev.carmonaadrian_reviewexercises.R
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise4Binding
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.connection.Client
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.connection.ApiStarWars
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.model.Answer
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.model.Starship
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Exercise4 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise4Binding
    private lateinit var recycler: RecyclerView

    private var retrofit: Retrofit? = null
    private var starshipAdapter: StarshipAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        recycler = binding.ryvStarships

        recycler.setHasFixedSize(true)

        recycler.addItemDecoration(DividerItemDecoration(this, 1))

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        starshipAdapter = StarshipAdapter()

        recycler.adapter = starshipAdapter

        retrofit = Client.getClient()

        getData()
    }

    private fun getData() {
        val api: ApiStarWars? = retrofit?.create(ApiStarWars::class.java)

        api?.getStarships()?.enqueue(object : Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                if (response.isSuccessful) {
                    val answer = response.body()

                    if (answer != null) {
                        val starshipsList = answer.results
                        starshipAdapter?.addToList(starshipsList)
                    }
                } else {
                    Toast.makeText(applicationContext, getString(R.string.error_response), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}