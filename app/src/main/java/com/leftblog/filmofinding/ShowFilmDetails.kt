package com.leftblog.filmofinding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import com.leftblog.filmofinding.databinding.ActivityShowFilmDetailsBinding
import android.content.pm.ResolveInfo

import android.content.pm.PackageManager




class ShowFilmDetails : AppCompatActivity() {
    //private lateinit var binding: ActivityShowFilmDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_film_details)
        //binding = ActivityShowFilmDetailsBinding.inflate(layoutInflater);
       // var imgSrc: String = intent.getStringExtra(IMG_SRC).toString()
       // var variableValueInt: Int = intent.getIntExtra(TEST, -1)
       // val Hello: String = intent.getStringExtra("hello").toString();
        //val variableValue: Int = intent.getIntExtra(IMG_SRC,-1)
        //Log.d("KEY!", intent.getIntExtra(IMG_SRC, -1).toString())
        //binding.imageView.setImageResource(resources.getIdentifier(variableValue, "drawable", packageName))
        //binding.imageView.setImageResource(R.drawable.stranger_things)
        //binding.textView5.text = intent.getStringExtra(DESCRIPTION_TEXT)
        var text: TextView = findViewById(R.id.textView5)
        var image: ImageView = findViewById(R.id.imageView)
        text.text = intent.getStringExtra("image_description")
        image.setImageResource(intent.getIntExtra("image_url", -1))
        findViewById<Button>(R.id.buttonFriend).setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi bro, follow me")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }


    companion object{
        const val IMG_SRC = "imgSrc"
        const val DESCRIPTION_TEXT = "descriptionText"
    }
}