package com.cpadridev.carmonaadrian_reviewexercises.exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cpadridev.carmonaadrian_reviewexercises.R
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivitySummaryPersonBinding

class SummaryPerson : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val bundle = intent.getBundleExtra(Intent.EXTRA_TEXT)
            val person: Person = bundle?.getParcelable("Person")!!

            binding.txvName.text = person.name
            binding.txvAge.text = person.age.toString()
            binding.txvGender.text = person.gender
        }

        binding.btnSend.setOnClickListener {
            val intent = Intent(this, Exercise1::class.java)
            startActivity(intent)
            Toast.makeText(this, getString(R.string.send_person), Toast.LENGTH_LONG).show()
        }
    }
}