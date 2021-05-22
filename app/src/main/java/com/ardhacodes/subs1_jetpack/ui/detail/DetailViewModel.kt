package com.ardhacodes.subs1_jetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy

class DetailViewModel : ViewModel() {
    private lateinit var mov_id: String
    private lateinit var tv_id: String

    fun setMovieById(movieId: String) {
        this.mov_id = movieId
    }

    fun setTvShowById(tvShowId: String) {
        this.tv_id = tvShowId
    }

    private fun getListMovie(): ArrayList<MovieTvEntity> = MoviesTvDataDummy.DataMovies() as ArrayList<MovieTvEntity>
    private fun getListTvShow(): ArrayList<MovieTvEntity> = MoviesTvDataDummy.DataTvShow() as ArrayList<MovieTvEntity>


    fun getMovieById(): MovieTvEntity? {
        var result: MovieTvEntity? = null
        val listMovie = getListMovie()
        for (movie in listMovie){
            if(movie.title == mov_id){
                result = movie
                break
            }
        }
        return result
    }


    fun getTvShowById(): MovieTvEntity? {
        var result: MovieTvEntity? = null
        val listTvShow = getListTvShow()
        for(tvshow in listTvShow){
            if(tvshow.title == tv_id){
                result = tvshow
                break
            }
        }
        return result
    }
}