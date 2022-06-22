package com.leftblog.filmofinding

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.leftblog.filmofinding.databinding.MainRecyclerFragmentBinding
import java.security.AccessController.getContext

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
        Log.d("BACKSTACKRecycler", (activity as MainActivity).supportFragmentManager.backStackEntryCount.toString())

        populateList()
        setUpAdapter()
    }

    private fun setUpAdapter() {
        val context = getContext() as Activity
        adapter = MainShowElementsAdapter(
            context,
            mainElementsList,
            favoritesList,
            filmDetailsClickListener = object : MainShowElementsAdapter.OnFilmsDetailClickListener{
                override fun onFilmClick(mainElement: MainElement){
                    Log.d("setUpAdapter", context.toString())
                    val detailsFragment: Fragment = FilmDetailsFragment()
                    val filmDetails = Bundle()
                    filmDetails.putInt("image_url", mainElement.src)
                    filmDetails.putString("image_name", mainElement.name)
                    filmDetails.putString("image_description", mainElement.description)
                    detailsFragment.arguments = filmDetails
                    (activity as MainActivity).loadMainRecyclerFragment(R.id.film_main_container, detailsFragment, "mainRecycler", true)
                }
            }
        )

        Log.d("adapter", adapter.toString())
        b.mainFilmsGrid.adapter = adapter
    }

    private fun populateList() {
        val packageName = getActivity()?.getPackageName();
        val filmsName = arrayOf("Анчартед", "Фантастические Твари", "Бэтмен", "Очень странные дела")
        val filmsSRC = arrayOf(resources.getIdentifier("uncharted_2021","drawable", packageName), resources.getIdentifier("fantasticbeasts3","drawable",packageName
        ), resources.getIdentifier("batman","drawable", packageName), resources.getIdentifier("stranger_things","drawable", packageName))

        for (i in 0..3){
            val foodItem = MainElement(name = filmsName[i],src = filmsSRC[i], description = filmsName[i])
            mainElementsList.add(foodItem)
        }
    }
}