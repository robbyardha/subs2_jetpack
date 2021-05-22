package com.ardhacodes.subs1_jetpack.ui.tv

import androidx.lifecycle.ViewModel
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy

class TvViewModel:ViewModel() {
    fun getdDataTv () :List<MovieTvEntity> = MoviesTvDataDummy.DataTvShow()
}