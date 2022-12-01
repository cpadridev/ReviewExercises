package com.cpadridev.carmonaadrian_reviewexercises

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var exerciseAdapter: ExerciseAdapter? = null
    private var exercisesList: ArrayList<AppCompatActivity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exercisesList.add(Exercise1)

        val recycler = binding.ryvExercises

        recycler.setHasFixedSize(true)

        recycler.addItemDecoration(DividerItemDecoration(this, 1))

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        exerciseAdapter = ExerciseAdapter(exercisesList)

        recycler.adapter = exerciseAdapter
    }
}