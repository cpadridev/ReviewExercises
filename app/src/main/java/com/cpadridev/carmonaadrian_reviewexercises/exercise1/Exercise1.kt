package com.cpadridev.carmonaadrian_reviewexercises.exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.cpadridev.carmonaadrian_reviewexercises.R
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise1Binding

class Exercise1 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var ages: ArrayList<Int> = ArrayList()

        for (i in 10..100) {
            ages.add(i)
        }

        val adapter = ArrayAdapter(applicationContext, R.layout.color_spinner_layout, ages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnAge.adapter = adapter

        binding.btnNext.setOnClickListener {
            val person = Person(binding.edtName.text.toString(),
                binding.spnAge.selectedItem.toString().toInt(),
                if (binding.rbtMale.isChecked) {
                    getString(R.string.male)
                } else if (binding.rbtFemale.isChecked) {
                    getString(R.string.female)
                } else {
                    getString(R.string.other)
                })

            val bundle = Bundle()

            bundle.putParcelable("Person", person)

            val intent = Intent(this, SummaryPerson::class.java).apply {
                putExtra(Intent.EXTRA_TEXT, bundle)
            }

            startActivity(intent)
        }
    }
}