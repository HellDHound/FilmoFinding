package com.leftblog.filmofinding

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import android.os.Environment
import androidx.annotation.RequiresApi
import java.io.File
import android.R
import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.res.Configuration
import android.graphics.Color
import android.os.PersistableBundle
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


/*
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainShowElementsAdapter
    private lateinit var binding: ActivityMainBinding
    private val mainElementList: MutableList<MainElement> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateList()
        setUpAdapter()
    }
    fun onClick(v: View) {
            val intent = Intent(this, ShowFilmDetails::class.java)
            startActivity(intent)
        }
    }
    private fun setUpAdapter() {
        adapter = MainShowElementsAdapter(this, mainElementList)
        binding.foodItemsRV.adapter = adapter
        binding.foodItemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
    for (i in 1..15){
        val name = "Food Item $i"
        val price = (100 * i).toFloat()

        val mainElement = MainElement(name = name, price = price)

        foodItemsList.add(foodItem)
    }
}*/
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainShowElementsAdapter
    private lateinit var b: ActivityMainBinding
    private val mainElementsList: MutableList<MainElement> = mutableListOf()
    private val favoritesList: MutableList<MainElement> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        if (this.getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE
        ) {
            b.mainFilmsGrid.layoutManager = GridLayoutManager(this, 2)
        } else {
            b.mainFilmsGrid.layoutManager = LinearLayoutManager(this)
        }

        populateList()
        setUpAdapter()
    }

    private fun setUpAdapter() {
        adapter = MainShowElementsAdapter(this,mainElementsList,favoritesList)
        b.mainFilmsGrid.adapter = adapter
        //b.mainFilmsGrid.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        val filmsName = arrayOf("Анчартед", "Фантастические Твари", "Бэтмен", "Очень странные дела")
        val filmsSRC = arrayOf(resources.getIdentifier("uncharted_2021","drawable", packageName), resources.getIdentifier("fantasticbeasts3","drawable",packageName
        ), resources.getIdentifier("batman","drawable", packageName), resources.getIdentifier("stranger_things","drawable", packageName))
        for (i in 0..3){
            val foodItem = MainElement(name = filmsName[i],src = filmsSRC[i], description = filmsName[i])
            mainElementsList.add(foodItem)
        }
    }
    fun onClick(v: View) {
        /*val intent = Intent(this, ShowFilmDetails::class.java)
        startActivity(intent)*/
       /* when (v.id) {
            b.showFilmDetails.id -> {
                b.textView.setTextColor(Color.parseColor("#FFBA5F"))
                val intent = Intent(this, ShowFilmDetails::class.java)
                intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("stranger_things","drawable", getPackageName()))
                intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Очень странные дела")
                startActivity(intent)
            }
            b.showFilmDetails2.id -> {
                b.textView2.setTextColor(Color.parseColor("#FFBA5F"))
                val intent = Intent(this, ShowFilmDetails::class.java)
                intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("uncharted_2021","drawable", getPackageName()))
                intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Анчартед, на картах не значится")
                startActivity(intent)
            }
            b.showFilmDetails3.id -> {
                b.textView3.setTextColor(Color.parseColor("#FFBA5F"))
                val intent = Intent(this, ShowFilmDetails::class.java)
                intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("fantasticbeasts3","drawable", getPackageName()))
                intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Фантачтические твари. Тайны Дамблдора")
                startActivity(intent)
            }
            b.showFilmDetails4.id -> {
                b.textView4.setTextColor(Color.parseColor("#FFBA5F"))
                val intent = Intent(this, ShowFilmDetails::class.java)
                intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("batman","drawable", getPackageName()))
                intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Бэтмен")
                startActivity(intent)
            }

        }*/
    }
    /*fun onClick(v: View) {
       when (v.id) {
           b.showFilmDetails.id -> {
               b.textView.setTextColor(Color.parseColor("#FFBA5F"))
               val intent = Intent(this, ShowFilmDetails::class.java)
               intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("stranger_things","drawable", getPackageName()))
               intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Очень странные дела")
               startActivity(intent)
           }
           b.showFilmDetails2.id -> {
               b.textView2.setTextColor(Color.parseColor("#FFBA5F"))
               val intent = Intent(this, ShowFilmDetails::class.java)
               intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("uncharted_2021","drawable", getPackageName()))
               intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Анчартед, на картах не значится")
               startActivity(intent)
           }
           b.showFilmDetails3.id -> {
               b.textView3.setTextColor(Color.parseColor("#FFBA5F"))
               val intent = Intent(this, ShowFilmDetails::class.java)
               intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("fantasticbeasts3","drawable", getPackageName()))
               intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Фантачтические твари. Тайны Дамблдора")
               startActivity(intent)
           }
           b.showFilmDetails4.id -> {
               b.textView4.setTextColor(Color.parseColor("#FFBA5F"))
               val intent = Intent(this, ShowFilmDetails::class.java)
               intent.putExtra(ShowFilmDetails.IMG_SRC, getResources().getIdentifier("batman","drawable", getPackageName()))
               intent.putExtra(ShowFilmDetails.DESCRIPTION_TEXT, "Бэтмен")
               startActivity(intent)
           }

       }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("KEY1", b.textView.currentTextColor)
        outState.putInt("KEY2", b.textView2.currentTextColor)
        outState.putInt("KEY3", b.textView3.currentTextColor)
        outState.putInt("KEY4", b.textView4.currentTextColor)
    }
    @SuppressLint("RestrictedApi")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        b.textView.setTextColor(savedInstanceState.getInt("KEY1"))
        b.textView2.setTextColor(savedInstanceState.getInt("KEY2"))
        b.textView3.setTextColor(savedInstanceState.getInt("KEY3"))
        b.textView4.setTextColor(savedInstanceState.getInt("KEY4"))
    }*/
}