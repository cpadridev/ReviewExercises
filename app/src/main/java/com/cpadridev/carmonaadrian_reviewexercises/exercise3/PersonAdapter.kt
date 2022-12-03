package com.cpadridev.carmonaadrian_reviewexercises.exercise3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cpadridev.carmonaadrian_reviewexercises.R

class PersonAdapter(private var list: ArrayList<Person> = ArrayList()) : RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvName: TextView
        val txvAge: TextView
        val txvProfession: TextView
        val lytPerson: LinearLayout

        init {
            txvName = view.findViewById(R.id.txvName)
            txvAge = view.findViewById(R.id.txvAge)
            txvProfession = view.findViewById(R.id.txvProfession)
            lytPerson = view.findViewById(R.id.lytPerson)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.people_elements, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.txvName.text = list[position].name
        viewHolder.txvAge.text = list[position].age.toString()
        viewHolder.txvProfession.text = list[position].profession
        viewHolder.lytPerson.setOnClickListener { v ->
            val bundle = Bundle()

            bundle.putParcelable("Person", list[position])

            val intent = Intent(v.context, ShowPerson::class.java).apply {
                putExtra(Intent.EXTRA_TEXT, bundle)
            }

            v.context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size
}