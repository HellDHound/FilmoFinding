package com.leftblog.filmofinding

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leftblog.filmofinding.databinding.MainFilmElementBinding


class MainShowElementsAdapter(
    private val context: Context,
    private val mainElementList:MutableList<MainElement>,
    private val favoritesList:MutableList<MainElement>,
    private val filmDetailsClickListener:OnFilmsDetailClickListener
    )
    : RecyclerView.Adapter<MainShowElementsAdapter.MainElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainElementViewHolder {
        val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainElementViewHolder, position: Int) {
        val MainElement = mainElementList[position]
        holder.bind(MainElement,favoritesList)
    }

    override fun getItemCount(): Int {
        return mainElementList.size
    }

    inner class MainElementViewHolder(mainFilmElementBinding: MainFilmElementBinding)
        : RecyclerView.ViewHolder(mainFilmElementBinding.root){

        private val binding = mainFilmElementBinding
        private lateinit var filmDetailsFragment: FilmDetailsFragment

        fun bind(mainElement: MainElement, favoritesList:MutableList<MainElement>){
            binding.filmName.text = mainElement.name
            binding.filmMainImage.setImageResource(mainElement.src)

            binding.showFilmDetails.setOnClickListener {
                filmDetailsFragment = FilmDetailsFragment()
                binding.filmName.setTextColor(Color.parseColor("#FFBA5F"))
                filmDetailsClickListener.onFilmClick(mainElement)

            }
            binding.filmMainImage.setOnLongClickListener() {
                val filmItem = MainElement(name = mainElement.name,src = mainElement.src, description = mainElement.description)
                favoritesList.add(filmItem)
                var context = itemView.getContext();

                this?.let {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Избранное!")
                        .setMessage("Фильм добавлен в избранное!")
                        .setPositiveButton("ОК") { dialog, id ->
                            dialog.cancel()
                        }
                    builder.create()
                }
                    return@setOnLongClickListener true
                }
            }
        }
        interface OnFilmsDetailClickListener{
            fun onFilmClick(mainElement: MainElement)
        }
    }

