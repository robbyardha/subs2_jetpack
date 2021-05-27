package com.ardhacodes.subs1_jetpack.ui.movie

import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MovieViewModelTest
{
    private lateinit var viewmodel: MovieViewModel

    @Mock
    private lateinit var catalogRepository: CatalogRepository


    @Before
    fun setData(){
        viewmodel = MovieViewModel(catalogRepository)
    }

    @Test
    fun getMovie(){
        val movie = viewmodel.getdDataMovie()
        val countdata = 10
        assertNotNull(movie)
        assertEquals(countdata, movie.size)
    }
}