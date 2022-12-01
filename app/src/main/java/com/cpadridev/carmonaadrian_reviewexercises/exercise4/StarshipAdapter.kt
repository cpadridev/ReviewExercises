package com.cpadridev.carmonaadrian_reviewexercises.exercise4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cpadridev.carmonaadrian_reviewexercises.R
import com.cpadridev.carmonaadrian_reviewexercises.exercise4.model.Starship

class StarshipAdapter : RecyclerView.Adapter<StarshipAdapter.MyViewHolder>() {
    private var list: ArrayList<Starship> = ArrayList()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvName: TextView
        val txvModel: TextView
        val lytStarship: LinearLayout

        init {
            txvName = view.findViewById(R.id.txvName)
            txvModel = view.findViewById(R.id.txvModel)
            lytStarship = view.findViewById(R.id.lytStarship)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.starships_elements, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.txvName.text = list[position].name
        viewHolder.txvModel.text = list[position].model
        viewHolder.lytStarship.setOnClickListener { v ->
            val bundle = Bundle()

            bundle.putStringArrayList("Films", list[position].films)

            val intent = Intent(v.context, Film::class.java).apply {
                putExtra(Intent.EXTRA_TEXT, bundle)
            }

            v.context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size

    fun addToList(list_: ArrayList<Starship>) {
        list.clear()
        list.addAll(list_)

        notifyDataSetChanged()
    }
}