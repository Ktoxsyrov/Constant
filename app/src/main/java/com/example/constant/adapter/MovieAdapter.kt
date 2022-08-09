package com.example.constant.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constant.R
import com.example.constant.model.Movie
import com.example.constant.model.MoviesList

class MovieAdapter(private val movies: List<Movie>,
                   private val context: Context,
                   val listener: (Movie) -> Unit
                   ): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val directorName: TextView = view.findViewById(R.id.directorName)
        val actorsRecycler: RecyclerView = view.findViewById(R.id.actorsRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.title.text = "${currentMovie.title} (${currentMovie.releaseYear})"
        val directorFullName = currentMovie.directorName
        val directorLastName = directorFullName.substringAfterLast(' ')
        val directorInitials = directorFullName[0] + "." + directorFullName.substringAfter(' ')[0] + "."
        holder.directorName.text = "$directorLastName $directorInitials"
        holder.actorsRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerAdapter = ActorsAdapter(context)
        recyclerAdapter.setActors(currentMovie.actors)
        holder.actorsRecycler.adapter = recyclerAdapter
        holder.itemView.setOnClickListener { listener(currentMovie) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}