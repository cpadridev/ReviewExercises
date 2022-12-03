package com.cpadridev.carmonaadrian_reviewexercises.exercise2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cpadridev.carmonaadrian_reviewexercises.R
import com.cpadridev.carmonaadrian_reviewexercises.databinding.ActivityFormBinding

class Form : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding

    private var words: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val bundle = intent.getBundleExtra(Intent.EXTRA_TEXT)

            words = bundle?.getStringArrayList("Words")!!
        }

        binding.btnAdd.setOnClickListener {
            if (binding.edtWord.text.isNotEmpty()) {
                words?.add(binding.edtWord.text.toString())

                val bundle = Bundle()

                bundle.putStringArrayList("Words", words)

                val intent = Intent(this, Exercise2::class.java).apply {
                    putExtra(Intent.EXTRA_TEXT, bundle)
                }

                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.error_fill_fields), Toast.LENGTH_LONG).show()
            }
        }
    }
}