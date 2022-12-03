package com.cpadridev.carmonaadrian_reviewexercises.exercise2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityExercise2Binding

class Exercise2 : AppCompatActivity() {
    private lateinit var binding: ActivityExercise2Binding

    private var words: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercise2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val bundle = intent.getBundleExtra(Intent.EXTRA_TEXT)

            words = bundle?.getStringArrayList("Words")!!
        }

        for (i in words) {
            binding.txvWords.append("$i, ")
        }

        if (words.size != 0) {
            binding.txvWords.text = binding.txvWords.text.substring(0, binding.txvWords.text.length - 2)
        }

        binding.btnNext.setOnClickListener {
            val bundle = Bundle()

            bundle.putStringArrayList("Words", words)

            val intent = Intent(this, Form::class.java).apply {
                putExtra(Intent.EXTRA_TEXT, bundle)
            }

            startActivity(intent)
        }
    }
}