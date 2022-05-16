package com.leftblog.filmofinding

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import com.leftblog.filmofinding.databinding.MainRecyclerFragmentBinding

class MainRecyclerFragment: Fragment() {
    private lateinit var adapter: MainShowElementsAdapter
    private lateinit var b: MainRecyclerFragmentBinding
    private val mainElementsList: MutableList<MainElement> = mutableListOf()
    private val favoritesList: MutableList<MainElement> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_recycler_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = MainRecyclerFragmentBinding.bind(view)
        Log.d("TAG", this.getResources().getConfiguration().orientation.toString())
        if (this.getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE
        ) {
            b.mainFilmsGrid.layoutManager = GridLayoutManager(context, 2)
        } else {
            b.mainFilmsGrid.layoutManager = LinearLayoutManager(context)
        }

        populateList()
        setUpAdapter()
        // Используем созданный viewBinding
    }

     /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //b = MainRecyclerFragmentBinding.inflate(layoutInflater)
        b = MainRecyclerFragmentBinding.bind(inflater)
        //setContentView(b.root)
         Log.d("TAG", this.getResources().getConfiguration().orientation.toString())
        if (this.getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE
        ) {
            b.mainFilmsGrid.layoutManager = GridLayoutManager(context, 2)
        } else {
            b.mainFilmsGrid.layoutManager = LinearLayoutManager(context)
        }

        populateList()
        setUpAdapter()
    }*/

    private fun setUpAdapter() {
        val context = getContext() as Activity
        //val context = this.getActivity()
        adapter = MainShowElementsAdapter(context,mainElementsList,favoritesList)

        Log.d("adapter", adapter.toString())

        b.mainFilmsGrid.adapter = adapter
        //b.mainFilmsGrid.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        val packageName = getActivity()?.getPackageName();
        val filmsName = arrayOf("Анчартед", "Фантастические Твари", "Бэтмен", "Очень странные дела")
       // packageName = this.getResources().getIdentifier(filename, "drawable", "my.project.package");
        val filmsSRC = arrayOf(resources.getIdentifier("uncharted_2021","drawable", packageName), resources.getIdentifier("fantasticbeasts3","drawable",packageName
        ), resources.getIdentifier("batman","drawable", packageName), resources.getIdentifier("stranger_things","drawable", packageName))
        //getResources().getIdentifier("image_name","drawable", getPackageName())

        //val filmsSRC = arrayOf(1,2,3)

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