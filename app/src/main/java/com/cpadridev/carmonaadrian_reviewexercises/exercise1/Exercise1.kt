package com.cpadridev.carmonaadrian_reviewexercises.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise1Binding

class Exercise1 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise1Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}