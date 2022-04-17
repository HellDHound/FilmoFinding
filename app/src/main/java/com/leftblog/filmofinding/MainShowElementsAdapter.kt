package com.leftblog.filmofinding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import com.leftblog.filmofinding.databinding.MainFilmElementBinding

class MainShowElementsAdapter(private val context: Context, private val mainElementList:MutableList<MainElement>)
    : RecyclerView.Adapter<MainShowElementsAdapter.MainElementViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainElementViewHolder {
        val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainElementViewHolder, position: Int) {
        val MainElement = mainElementList[position]
        holder.bind(MainElement)
    }

    override fun getItemCount(): Int {
        return mainElementList.size
    }

    class MainElementViewHolder(mainFilmElementBinding: MainFilmElementBinding)
        : RecyclerView.ViewHolder(mainFilmElementBinding.root){

        private val binding = mainFilmElementBinding

        fun bind(mainElement: MainElement){
            binding.filmName.text = mainElement.name
            binding.filmMainImage.setImageResource(mainElement.src)
        }

    }
}
