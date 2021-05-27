package com.ardhacodes.subs1_jetpack.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy

class TvViewModel(val catalogRepository: CatalogRepository):ViewModel() {
    fun getdDataTv () :List<MovieTvEntity> = MoviesTvDataDummy.DataTvShow()

    fun getDataTvAPI() : LiveData<List<MovieTvEntity>>
    {
       return catalogRepository.getTvShow()
    }
}