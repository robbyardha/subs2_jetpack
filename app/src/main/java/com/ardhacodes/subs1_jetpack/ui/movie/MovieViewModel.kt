package com.ardhacodes.subs1_jetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy

class MovieViewModel(val catalogRepository: CatalogRepository) : ViewModel(){
//    fun getdDataMovie () :List<MovieTvEntity> = MoviesTvDataDummy.DataMovies()

    fun getDataMovieApi () : LiveData<List<MovieTvEntity>> = catalogRepository.getPopularMovies()
}