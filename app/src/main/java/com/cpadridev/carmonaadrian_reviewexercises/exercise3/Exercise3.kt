package com.cpadridev.carmonaadrian_reviewexercises.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise3Binding

class Exercise3 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise3Binding

    private var people: ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        people.add(Person("Adrian", 19, "Programmer"))
        people.add(Person("Victor", 20, "Programmer"))
        people.add(Person("Jose Vicente", 19, "Programmer"))
        people.add(Person("Raul", 19, "Programmer"))
        people.add(Person("Rodrigo", 19, "Programmer"))

        val recycler = binding.ryvPeople

        recycler.setHasFixedSize(true)

        recycler.addItemDecoration(DividerItemDecoration(this, 1))

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recycler.adapter = PersonAdapter(people)
    }
}