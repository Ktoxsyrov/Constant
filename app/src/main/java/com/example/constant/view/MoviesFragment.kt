package com.example.constant.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constant.viewModel.MainViewModel
import com.example.constant.adapter.MovieAdapter
import com.example.constant.R

class MoviesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        recyclerView = view.findViewById(R.id.moviesRecycler)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val recyclerAdapter = MovieAdapter(view.context){movie ->
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Фильм '${movie.title}' был нажат")
            builder.show()
        }

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getMovies().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setMovies(it)
            recyclerView.adapter = recyclerAdapter
        })

        return view
    }
}