package com.example.tplogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(private val names: List<String>) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val element = names[position]
        holder.txtName.text = element
    }

    override fun getItemCount(): Int {
        return names.size
    }

    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
    }
}
