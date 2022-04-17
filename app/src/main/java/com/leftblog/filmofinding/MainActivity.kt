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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        populateList()

        setUpAdapter()
    }

    private fun setUpAdapter() {

        adapter = MainShowElementsAdapter(this,mainElementsList)

        b.mainFilmsGrid.adapter = adapter
        b.mainFilmsGrid.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        //val links = arrayOf(Film("Анчартед","@drawable/uncharted_2021"))
        val filmsName = arrayOf("Анчартед", "Фантастические Твари", "Бэтмен", "Очень странные дела")
        val filmsSRC = arrayOf(R.drawable.uncharted_2021, R.drawable.fantasticbeasts3, R.drawable.batman, R.drawable.stranger_things)
        //val link:Int = R.drawable.uncharted_2021
        for (i in 0..3){
            val foodItem = MainElement(name = filmsName[i],src = filmsSRC[i])
            mainElementsList.add(foodItem)
        }
    }
    fun onClick(v: View) {
        val intent = Intent(this, ShowFilmDetails::class.java)
        startActivity(intent)
    }
}