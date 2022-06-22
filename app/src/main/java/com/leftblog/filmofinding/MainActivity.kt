package com.leftblog.filmofinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leftblog.filmofinding.databinding.ActivityMainBinding
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainShowElementsAdapter
    private lateinit var b: ActivityMainBinding
    private val mainElementsList: MutableList<MainElement> = mutableListOf()
    private val favoritesList: MutableList<MainElement> = mutableListOf()
    private lateinit var mainRecyclerFragment: MainRecyclerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("OnCreate", "1")
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        mainRecyclerFragment = MainRecyclerFragment()
        if (savedInstanceState == null){
            loadMainRecyclerFragment(b.filmMainContainer.id, MainRecyclerFragment(), "mainRecycler",  false)
        }
        //loadMainRecyclerFragment(b.menuMainContainer.id, BottomNavigationFragment(), "mainMenu",  false)
    }
    /*override fun OnBackPressed(){
        if (supportFragmentManager.backStackEntryCount > 1){
            supportFragmentManager.popBackStack()
        }
    }*/

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0){
            Log.d("backstackbefore", supportFragmentManager.backStackEntryCount.toString())
            supportFragmentManager.popBackStack()
            Log.d("backstackafter", supportFragmentManager.backStackEntryCount.toString())

        }else{
            super.onBackPressed()
        }
    }
    fun loadMainRecyclerFragment(fragmentId: Int, fragment: Fragment, tag: String, addToBackStack: Boolean){
       val transaction = supportFragmentManager.beginTransaction()
       transaction.replace(fragmentId, fragment, tag)
       if (addToBackStack){
           transaction.addToBackStack(null)
       }
       transaction.commit()
   }
}