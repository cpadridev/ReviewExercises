package com.cpadridev.carmonaadrian_reviewexercises.exercise3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityShowPersonBinding

class ShowPerson : AppCompatActivity() {
    private lateinit var binding: ActivityShowPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val bundle = intent.getBundleExtra(Intent.EXTRA_TEXT)

            var person: Person = bundle?.getParcelable("Person")!!

            binding.txvName.text = person.name
            binding.txvAge.text = person.age.toString()
            binding.txvProfession.text = person.profession
        }
    }
}