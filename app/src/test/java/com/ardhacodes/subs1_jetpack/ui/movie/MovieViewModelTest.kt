package com.ardhacodes.subs1_jetpack.ui.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest
{
    private lateinit var viewmodel: MovieViewModel


    @Before
    fun setData(){
        viewmodel = MovieViewModel()
    }

    @Test
    fun getMovie(){
        val movie = viewmodel.getdDataMovie()
        val countdata = 10
        assertNotNull(movie)
        assertEquals(countdata, movie.size)
    }
}