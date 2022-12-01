package com.cpadridev.carmonaadrian_reviewexercises.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise2Binding

class Exercise2 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}