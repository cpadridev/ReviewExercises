package com.cpadridev.carmonaadrian_reviewexercises.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise3Binding

class Exercise3 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise3Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}