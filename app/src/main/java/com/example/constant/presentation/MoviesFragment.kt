package com.example.constant.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constant.R
import com.example.constant.adapter.MovieAdapter

class MoviesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        recyclerView = view.findViewById(R.id.moviesRecycler)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.moviesList.observe(viewLifecycleOwner) {
            val recyclerAdapter = MovieAdapter(it.items,view.context){movie ->
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("Фильм '${movie.title}' был нажат")
                builder.show()
            }
            recyclerView.adapter = recyclerAdapter
            Log.d("help", it.toString())
        }

        mainViewModel.getMovies()

        return view
    }
}