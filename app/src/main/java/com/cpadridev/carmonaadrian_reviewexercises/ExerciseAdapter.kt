package com.cpadridev.carmonaadrian_reviewexercises

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private var list: ArrayList<AppCompatActivity>) : RecyclerView.Adapter<ExerciseAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvExercise: TextView

        init {
            txvExercise = view.findViewById(R.id.txvExercise)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.exercises_elements, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.txvExercise.text = list[position].title
    }

    override fun getItemCount() = list.size
}