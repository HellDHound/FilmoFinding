package com.leftblog.filmofinding

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import com.leftblog.filmofinding.databinding.MainFilmElementBinding
import android.content.SharedPreferences




class MainShowElementsAdapter(private val context: Context, private val mainElementList:MutableList<MainElement>)
    : RecyclerView.Adapter<MainShowElementsAdapter.MainElementViewHolder>() {

    //var favorites: MutableList<Int> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainElementViewHolder {
        val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        //val v: View = ViewGroup
        //val h: RecyclerView.ViewHolder = object : RecyclerView.ViewHolder(bin) {}
        return MainElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainElementViewHolder, position: Int) {
        //val binding = MainFilmElementBinding.inflate(LayoutInflater.from(context), parent, false)
        val MainElement = mainElementList[position]

        holder.bind(MainElement)
    }

    override fun getItemCount(): Int {
        return mainElementList.size
    }

    class MainElementViewHolder(mainFilmElementBinding: MainFilmElementBinding)
        : RecyclerView.ViewHolder(mainFilmElementBinding.root){

        private val binding = mainFilmElementBinding

        fun bind(mainElement: MainElement, favorites: MutableList<Int> = mutableListOf()){
            binding.filmName.text = mainElement.name
            binding.filmMainImage.setImageResource(mainElement.src)
            binding.showFilmDetails.setOnClickListener {
                var context = itemView.getContext();
                val intent = Intent (context, ShowFilmDetails::class.java)
                intent.putExtra("image_url", mainElement.src);
                intent.putExtra("image_name", mainElement.name);
                intent.putExtra("image_description", mainElement.description);
                context.startActivity(intent)
            }
            binding.filmMainImage.setOnLongClickListener() {
                //var favorites: MutableList<Int> = mutableListOf()
                favorites.add(mainElement.src)
                Log.d("FAV", favorites.toString())
                var context = itemView.getContext();
                /*val settings = context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)
                val editor = settings.edit()
                Log.d("FAV1", editor.getInt("LocalStorage", "favorites").toString())*/

               // editor.putInt("favorites", mainElement.src)
                //editor.apply()
               // Log.d("FAV", editor.getInt("LocalStorage", "favorites").toString())
                //nicknameText.setText(mSettings.getInt("LocalStorage", ""));
                /*intent.putExtra("image_url", mainElement.src);
                intent.putExtra("image_name", mainElement.name);
                intent.putExtra("image_description", mainElement.description);
                context.startActivity(intent)*/
                //Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()
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

