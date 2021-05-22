package com.ardhacodes.subs1_jetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy

class MovieViewModel : ViewModel(){
    fun getdDataMovie () :List<MovieTvEntity> = MoviesTvDataDummy.DataMovies()
}