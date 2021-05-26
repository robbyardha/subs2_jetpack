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
            callback: LoadNowPlayingMoviesCallback
    ){
        EspressoIdlingResource.increment()
//        ApiConfig.instance.getPopularMovie().await().isSuccessful
        ApiConfig.instance.getPopularMovie().await().result?.let{ getlistMovie ->
            callback.onAllMoviesReceived(
                    getlistMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailMovie(movieId).await().let { getdetmovie ->
            callback.onMovieDetailReceived(
                    getdetmovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowList(callback: LoadTvShowCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getTvPopular().await().result?.let { getlistTvShow ->
            callback.onAllTvShowsReceived(
                    getlistTvShow
            )
            EspressoIdlingResource.decrement()
        }
    }


    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailTvShow(tvShowId).await().let{ getdettvShow ->
            callback.onTvShowDetailReceived(
                    getdettvShow
            )
            EspressoIdlingResource.decrement()

        }
    }




    interface LoadNowPlayingMoviesCallback{
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadMovieDetailCallback{
        fun onMovieDetailReceived(movieResponse: MovieResponse)
    }


    interface LoadTvShowCallback{
        fun onAllTvShowsReceived(tvShowResponse: List<TvResponse>)
    }

    interface LoadTvShowDetailCallback{
        fun onTvShowDetailReceived(tvShowResponse: TvResponse)
    }
}