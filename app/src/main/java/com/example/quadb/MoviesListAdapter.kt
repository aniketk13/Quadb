package com.example.quadb

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Movies
import com.example.quadb.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class MoviesListAdapter(private val moviesList:List<Movies>,private val listener:ListItemListener):RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding=ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesListAdapter.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesListAdapter.ViewHolder, position: Int) {
        val movie=moviesList[position]
        with(holder.binding){
            if(movie.show.image!=null)
                Picasso.get().load(movie.show.image.medium).into(thumbnail)
            movieName.text=movie.show.name
            root.setOnClickListener {
                listener.showMovie(movie.show.id)
            }
        }
    }

    override fun getItemCount()=moviesList.size

    interface ListItemListener{
        fun showMovie(movieId:Int)
    }
}