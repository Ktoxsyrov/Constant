package com.example.constant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.constant.R
import com.example.constant.model.Actor
import com.google.android.material.imageview.ShapeableImageView

class ActorsAdapter(private val context: Context): RecyclerView.Adapter<ActorsAdapter.MyViewHolder>() {

    private var actors: List<Actor> = listOf()

    fun setActors(actors: List<Actor>){
        val noDuplicateActors = actors.distinctBy { it.actorName }
        this.actors = noDuplicateActors
    }
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val actorName: TextView = view.findViewById(R.id.actorName)
        val actorImage: ShapeableImageView = view.findViewById(R.id.actorImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.actor_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.actorName.text = actors[position].actorName
        when((1..4).random()){ //тут должен быть забор картинок с апи, но их нет
            1->{
                holder.actorImage.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.avatar1
                ))
            }
            2->{
                holder.actorImage.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.avatar2
                ))
            }
            3->{
                holder.actorImage.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.avatar3
                ))
            }
            4->{
                holder.actorImage.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.avatar4
                ))
            }
        }

    }

    override fun getItemCount(): Int {
        return actors.size
    }

}