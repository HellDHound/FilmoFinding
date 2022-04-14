package com.leftblog.filmofinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.TextView




class MainActivity : AppCompatActivity() {
    lateinit var btnDetails: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*btnDetails = findViewById(R.id.Details1)
        findViewById<Button>(R.id.Details1).setOnClickListener {
            val intent = Intent(this, ShowFilmDetails::class.java)
            startActivity(intent)
        }*/
    }
    fun onClick(v: View) {
            val intent = Intent(this, ShowFilmDetails::class.java)
            startActivity(intent)
        }
    }
