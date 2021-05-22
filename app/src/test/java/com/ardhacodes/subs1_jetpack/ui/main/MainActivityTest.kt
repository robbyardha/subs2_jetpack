package com.ardhacodes.subs1_jetpack.ui.main

import com.ardhacodes.subs1_jetpack.ui.detail.DetailViewModel
import com.ardhacodes.subs1_jetpack.ui.movie.MovieViewModel
import com.ardhacodes.subs1_jetpack.ui.tv.TvViewModel
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainActivityTest
{

    private lateinit var viewmodeldetail: DetailViewModel
    private lateinit var viewmodelmov: MovieViewModel
    private lateinit var viewmodeltv: TvViewModel
    val dataMov = MoviesTvDataDummy.DataMovies()[0]
    val dataTv = MoviesTvDataDummy.DataTvShow()[0]
    val movieId = dataMov.title
    val tvShowId = dataTv.title

    @Before
    fun setData()
    {
        viewmodelmov = MovieViewModel()
        viewmodelmov.getdDataMovie()

        viewmodeltv = TvViewModel()
        viewmodeltv.getdDataTv()


        viewmodeldetail = DetailViewModel()
        viewmodeldetail.setMovieById(movieId)
        viewmodeldetail.setTvShowById(tvShowId)
    }

    @Test
    fun getListMovieItem() {
        val movies = viewmodelmov.getdDataMovie()
        TestCase.assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getListTvShowItem() {
        val tvShows = viewmodeltv.getdDataTv()
        TestCase.assertNotNull(tvShows)
        assertEquals(11, tvShows.size)
    }

    @Test
    fun getNotNull()
    {
        val movie = viewmodeldetail.getMovieById()
        val tvShow = viewmodeldetail.getTvShowById()

        assertNotNull(movie)
        assertEquals(dataMov.title, movie?.title)
        assertEquals(dataMov.genre, movie?.genre)
        assertEquals(dataMov.yearrelease, movie?.yearrelease)
        assertEquals(dataMov.poster, movie?.poster)
        assertEquals(dataMov.score, movie?.score)
        assertEquals(dataMov.duration, movie?.duration)
        assertEquals(dataMov.overview, movie?.overview)

        assertNotNull(tvShow)
        assertEquals(dataTv.title, tvShow?.title)
        assertEquals(dataTv.genre, tvShow?.genre)
        assertEquals(dataTv.yearrelease, tvShow?.yearrelease)
        assertEquals(dataTv.poster, tvShow?.poster)
        assertEquals(dataTv.score, tvShow?.score)
        assertEquals(dataTv.duration, tvShow?.duration)
        assertEquals(dataTv.overview, tvShow?.overview)
    }
}
