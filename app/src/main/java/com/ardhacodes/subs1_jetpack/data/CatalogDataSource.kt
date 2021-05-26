package com.ardhacodes.subs1_jetpack.data

import androidx.lifecycle.LiveData
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity

interface CatalogDataSource {
    fun getPopularMovies(): LiveData<List<MovieTvEntity>>

    fun getMovieDetail(movieId: Int): LiveData<MovieTvEntity>

    fun getTvShow(): LiveData<List<MovieTvEntity>>

    fun getTvShowDetail(tvShowId: Int): LiveData<MovieTvEntity>
}