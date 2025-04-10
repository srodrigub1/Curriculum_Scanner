package com.example.curriculumscanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumscanner.databinding.ItemCvBinding

class CVAdapter(private val items: List<String>) : RecyclerView.Adapter<CVAdapter.CVViewHolder>() {

    inner class CVViewHolder(val binding: ItemCvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val binding = ItemCvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.binding.textViewCv.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}
