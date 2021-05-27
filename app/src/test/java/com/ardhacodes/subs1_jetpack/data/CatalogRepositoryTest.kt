//package com.ardhacodes.subs1_jetpack.data
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.ardhacodes.subs1_jetpack.LiveDataTest
//import com.ardhacodes.subs1_jetpack.data.source.remote.RemoteDataSource
//import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy
//import com.nhaarman.mockitokotlin2.any
//import com.nhaarman.mockitokotlin2.doAnswer
//import com.nhaarman.mockitokotlin2.verify
//import junit.framework.Assert
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert.*
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mockito
//import org.mockito.Mockito.mock
//
//class CatalogRepositoryTest
//{
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private val remoteMock = mock(RemoteDataSource::class.java)
//    private val catalogRepository = DummyCatalogRepository(remoteMock)
//
//    private val listDataMovieResponse = MoviesTvDataDummy.DataMovies()
//    private val movieId = listDataMovieResponse[0].id
//
//    private val listDataTvResponse = MoviesTvDataDummy.DataTvShow()
//    private val tvId = listDataTvResponse[0].id
//
//    private val movResponse = MoviesTvDataDummy.DataMovies()[0]
//    private val tvResponse = MoviesTvDataDummy.DataTvShow()[0]
//
//    @Test
//    fun getPopularMovie() {
//        runBlocking {
//            doAnswer {invocation ->
//                (invocation.arguments[0] as RemoteDataSource.LoadNowPlayingMoviesCallback).onAllMoviesReceived(listDataMovieResponse)
//                null
//            }.`when`(remoteMock).getPlayingMovies(any())
//        }
//
//        val liveDataValue = LiveDataTest.getValue(catalogRepository.getPopularMovies())
//
//        runBlocking {
//            verify(remoteMock).getPlayingMovies(any())
//        }
//
//        Assert.assertNotNull(liveDataValue)
//        assertEquals(listDataMovieResponse.size.toLong(), liveDataValue.size.toLong())
//    }
//}