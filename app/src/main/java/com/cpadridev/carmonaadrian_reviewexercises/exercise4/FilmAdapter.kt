package com.cpadridev.carmonaadrian_reviewexercises.exercise4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cpadridev.carmonaadrian_reviewexercises.R

class FilmAdapter (private val list: ArrayList<String>) : RecyclerView.Adapter<FilmAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvFilm: TextView

        init {
            txvFilm = view.findViewById(R.id.txvFilm)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.films_elements, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.txvFilm.text = list[position]
    }

    override fun getItemCount() = list.size
}