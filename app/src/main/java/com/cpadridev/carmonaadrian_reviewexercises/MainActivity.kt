package com.cpadridev.carmonaadrian_reviewexercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityMainBinding
import com.cpadridev.carmonaadrian_reviewexercises.exercise1.Exercise1
import com.cpadridev.carmonaadrian_reviewexercises.exercise2.Exercise2
import com.cpadridev.carmonaadrian_reviewexercises.exercise3.Exercise3
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.Exercise4

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var exercisesList: ArrayList<Exercise> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exercisesList.add(Exercise("Exercise 1", Exercise1::class.java))
        exercisesList.add(Exercise("Exercise 2", Exercise2::class.java))
        exercisesList.add(Exercise("Exercise 3", Exercise3::class.java))
        exercisesList.add(Exercise("Exercise 4", Exercise4::class.java))

        val recycler = binding.ryvExercises

        recycler.setHasFixedSize(true)

        recycler.addItemDecoration(DividerItemDecoration(this, 1))

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = ExerciseAdapter(exercisesList)

        adapter.setOnItemClickListener {
            val exercise = exercisesList[recycler.getChildAdapterPosition(it)]
            val intent = Intent(this, exercise.app)
            startActivity(intent)
        }

        recycler.adapter = adapter
    }
}