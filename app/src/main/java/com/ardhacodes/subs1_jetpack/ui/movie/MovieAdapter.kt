package com.ardhacodes.subs1_jetpack.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardhacodes.subs1_jetpack.R
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.databinding.ItemMovBinding
import com.ardhacodes.subs1_jetpack.ui.CallbackMovTv
import com.ardhacodes.subs1_jetpack.ui.detail.DetailMovieTvActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter(val callback: CallbackMovTv) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieTvEntity>()

    fun setMovies(movies: List<MovieTvEntity>){
        if(movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val itemMovieBindings = ItemMovBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBindings)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    inner class MovieViewHolder(private val binding: ItemMovBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieTvEntity) {
            with(binding) {
                itemTitle.text = movie.title
                itemGenre.text = movie.genre
                itemYearrelease.text = "Release : ${movie.yearrelease}"
                itemScore.text = "Score: ${movie.score}"

                itemView.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailMovieTvActivity::class.java)
//                    intent.putExtra(DetailMovieTvActivity.EXTRA_MOV, movie.title)
//                    itemView.context.startActivity(intent)
                    callback.onItemClicked(movie)
                }
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(RequestOptions())
                    .into(ivPoster)
            }
        }
    }
}