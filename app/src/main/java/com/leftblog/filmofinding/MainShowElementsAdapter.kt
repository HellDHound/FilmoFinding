package com.leftblog.filmofinding

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leftblog.filmofinding.databinding.MainFilmElementBinding
import java.security.AccessController.getContext


class MainShowElementsAdapter(private val context: Context, private val mainElementList:MutableList<MainElement>, private val favoritesList:MutableList<MainElement>)
    : RecyclerView.Adapter<MainShowElementsAdapter.MainElementViewHolder>() {

    //var favorites: MutableList<Int> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainElementViewHolder {
        Log.d("contextCreateViewHolder", context.toString())
        val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        //val v: View = ViewGroup
        //val h: RecyclerView.ViewHolder = object : RecyclerView.ViewHolder(bin) {}
        return MainElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainElementViewHolder, position: Int) {
        //val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        val MainElement = mainElementList[position]
        Log.d("MainElement", MainElement.toString())
        holder.bind(MainElement,favoritesList)
    }

    override fun getItemCount(): Int {
        return mainElementList.size
    }

    class MainElementViewHolder(mainFilmElementBinding: MainFilmElementBinding)
        : RecyclerView.ViewHolder(mainFilmElementBinding.root){

        private val binding = mainFilmElementBinding
        private lateinit var filmDetailsFragment: FilmDetailsFragment

        fun bind(mainElement: MainElement, favoritesList:MutableList<MainElement>){
            binding.filmName.text = mainElement.name
            binding.filmMainImage.setImageResource(mainElement.src)

            binding.showFilmDetails.setOnClickListener {
                //val activity = itemView.getContext()
                filmDetailsFragment = FilmDetailsFragment()
                binding.filmName.setTextColor(Color.parseColor("#FFBA5F"))



                //mainElement.
                //MainActivity.getSupportFragmentManager().beginTransaction().
                //mainElement.getSupportFragmentManager().beginTransaction()
                //supportFragmentManager.beginTransaction()
                //    .commit()


                 var context = itemView.getContext()
                Log.d("contextAdapter", context.toString())
                val intent = Intent (context, ShowFilmDetails::class.java)
                 intent.putExtra("image_url", mainElement.src)
                 intent.putExtra("image_name", mainElement.name)
                 intent.putExtra("image_description", mainElement.description)
                 context.startActivity(intent)

            }
            binding.filmMainImage.setOnLongClickListener() {
                //var favorites: MutableList<Int> = mutableListOf()
                //favorites.add(mainElement.src)
                //Log.d("FAV", favorites.toString())
                val filmItem = MainElement(name = mainElement.name,src = mainElement.src, description = mainElement.description)
                favoritesList.add(filmItem)
                Log.d("FAV", favoritesList.toString())
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

    }

