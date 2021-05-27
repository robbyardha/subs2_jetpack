package com.ardhacodes.subs1_jetpack.data.source.remote

import com.ardhacodes.subs1_jetpack.data.source.remote.api.ApiConfig
import com.ardhacodes.subs1_jetpack.data.source.remote.response.MovieResponse
import com.ardhacodes.subs1_jetpack.data.source.remote.response.TvResponse
import com.ardhacodes.subs1_jetpack.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
                    instance?: RemoteDataSource()
                }
    }

    suspend fun getPlayingMovies(
            callback: LoadPopularMoviesCallback
    ){
        EspressoIdlingResource.increment()
//        ApiConfig.instance.getPopularMovie().await().isSuccessful
        ApiConfig.instance.getPopularMovie().await().result?.let{ getlistMovie ->
            callback.responseOnAllMoviesReceived(
                    getlistMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailMovie(movieId).await().let { getdetmovie ->
            callback.responseOnDetailMoviesReceived(
                    getdetmovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvList(callback: LoadTvCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getTvPopular().await().result?.let { getlistTvShow ->
            callback.responseOnAllTvReceived(
                    getlistTvShow
            )
            EspressoIdlingResource.decrement()
        }
    }


    suspend fun getTvDetail(tvShowId: Int, callback: LoadTvDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailTvShow(tvShowId).await().let{ getdettvShow ->
            callback.responseOnDetailTvReceived(
                    getdettvShow
            )
            EspressoIdlingResource.decrement()

        }
    }




    interface LoadPopularMoviesCallback{
        fun responseOnAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadMovieDetailCallback{
        fun responseOnDetailMoviesReceived(movieResponse: MovieResponse)
    }


    interface LoadTvCallback{
        fun responseOnAllTvReceived(tvShowResponse: List<TvResponse>)
    }

    interface LoadTvDetailCallback{
        fun responseOnDetailTvReceived(tvShowResponse: TvResponse)
    }
}