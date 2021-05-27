package com.ardhacodes.subs1_jetpack.ui.detail

import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class DetailViewModelTest
{
    private lateinit var viewmodel: DetailViewModel
    val dataMov = MoviesTvDataDummy.DataMovies()[0]
    val dataTv = MoviesTvDataDummy.DataTvShow()[0]
    val movieId = dataMov.title
    val tvShowId = dataTv.title
    @Mock
    private lateinit var catalogRepository: CatalogRepository
    @Before
    fun setDataMovie() {
        viewmodel = DetailViewModel(catalogRepository)
        viewmodel.setMovieById(movieId)
        viewmodel.setTvShowById(tvShowId)
    }

    @Test
    fun getData()
    {
        val movie = viewmodel.getMovieById()
        val tvShow = viewmodel.getTvShowById()

        assertNotNull(movie)
        assertEquals(dataMov.title, movie?.title)
        assertEquals(dataMov.release_date, movie?.release_date)
        assertEquals(dataMov.popularity, movie?.popularity)
        assertEquals(dataMov.overview, movie?.overview)
        assertEquals(dataMov.vote_average, movie?.vote_average)
        assertEquals(dataMov.poster_path, movie?.poster_path)

        assertNotNull(tvShow)
        assertEquals(dataTv.title, tvShow?.title)
        assertEquals(dataTv.release_date, tvShow?.release_date)
        assertEquals(dataTv.popularity, tvShow?.popularity)
        assertEquals(dataTv.overview, tvShow?.overview)
        assertEquals(dataTv.vote_average, tvShow?.vote_average)
        assertEquals(dataTv.poster_path, tvShow?.poster_path)
    }

//    @Test
//    fun getDataMov()
//    {
//        val movie = viewmodel.getMovieById()
//        assertNotNull(movie)
//        assertEquals(dataMov.title, movie?.title)
//        assertEquals(dataMov.genre, movie?.genre)
//        assertEquals(dataMov.yearrelease, movie?.yearrelease)
//        assertEquals(dataMov.poster, movie?.poster)
//        assertEquals(dataMov.score, movie?.score)
//        assertEquals(dataMov.duration, movie?.duration)
//        assertEquals(dataMov.overview, movie?.overview)
//    }
//    @Test
//    fun getDataTv()
//    {
//        val tvShow = viewmodel.getTvShowById()
//        assertNotNull(tvShow)
//        assertEquals(dataTv.title, tvShow?.title)
//        assertEquals(dataTv.genre, tvShow?.genre)
//        assertEquals(dataTv.yearrelease, tvShow?.yearrelease)
//        assertEquals(dataTv.poster, tvShow?.poster)
//        assertEquals(dataTv.score, tvShow?.score)
//        assertEquals(dataTv.duration, tvShow?.duration)
//        assertEquals(dataTv.overview, tvShow?.overview)
//    }

//    @Test
//    fun getData() {
//        val movie = viewmodel.getMovieById()
//        val tvShow = viewmodel.getTvShowById()
//        assertNotNull(tvShow)
//        assertNotNull(movie)
//        if (movie != null) {
//            assertEquals(dataMov.title, movie.title)
//            assertEquals(dataMov.genre, movie.genre)
//            assertEquals(dataMov.yearrelease, movie.yearrelease)
//            assertEquals(dataMov.poster, movie.poster)
//            assertEquals(dataMov.score, movie.score)
//            assertEquals(dataMov.duration, movie.duration)
//            assertEquals(dataMov.overview, movie.overview)
//        }
//        if (tvShow != null) {
//            assertEquals(dataTv.title, tvShow.title)
//            assertEquals(dataTv.genre, tvShow.genre)
//            assertEquals(dataTv.yearrelease, tvShow.yearrelease)
//            assertEquals(dataTv.poster, tvShow.poster)
//            assertEquals(dataTv.score, tvShow.score)
//            assertEquals(dataTv.duration, tvShow.duration)
//            assertEquals(dataTv.overview, tvShow.overview)
//        }
//    }
}
