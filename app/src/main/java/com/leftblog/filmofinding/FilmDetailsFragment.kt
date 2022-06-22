package com.leftblog.filmofinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leftblog.filmofinding.databinding.ShowFilmDetailsFragmentBinding

class FilmDetailsFragment : Fragment() {
    private lateinit var b: ShowFilmDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_film_details_fragment, container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = ShowFilmDetailsFragmentBinding.bind(view)
        val bundle = this.arguments
        Log.d("TEST", bundle?.getString("image_description").toString())
        b.filmDescription.text = bundle?.getString("image_description")
        b.mainImage.setImageResource(bundle?.getInt("image_url")!!)
        b.buttonFriend.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi bro, follow me")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }
}