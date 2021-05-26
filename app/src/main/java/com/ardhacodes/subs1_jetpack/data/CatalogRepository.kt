package com.ardhacodes.subs1_jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ardhacodes.subs1_jetpack.data.source.remote.RemoteDataSource
import com.ardhacodes.subs1_jetpack.data.source.remote.response.MovieResponse
import com.ardhacodes.subs1_jetpack.data.source.remote.response.TvResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatalogRepository private constructor(private val remoteDataSource: RemoteDataSource): CatalogDataSource{
    companion object{
        @Volatile
        private var instance: CatalogRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogRepository =
            instance ?: synchronized(this){
                instance ?: CatalogRepository(remoteDataSource)
            }
    }

    override fun getPopularMovies(): LiveData<List<MovieTvEntity>> {
        val listMovieResult = MutableLiveData<List<MovieTvEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getPlayingMovies(object : RemoteDataSource.LoadNowPlayingMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<MovieTvEntity>()
                    for(response in movieResponse){
                        val movie = MovieTvEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.popularity,
                            response.overview,
                            response.vote_average,
                            response.poster_path
                        )
                        movieList.add(movie)
                    }
                    listMovieResult.postValue(movieList)
                }

            })
        }

        return listMovieResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieTvEntity> {
        val movResult = MutableLiveData<MovieTvEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieDetail(movieId, object: RemoteDataSource.LoadMovieDetailCallback{
                override fun onMovieDetailReceived(movieResponse: MovieResponse) {
                    val movie = MovieTvEntity(
                        movieResponse.id,
                        movieResponse.title,
                        movieResponse.release_date,
                        movieResponse.popularity,
                        movieResponse.overview,
                        movieResponse.vote_average,
                        movieResponse.poster_path
                    )
                    movResult.postValue(movie)
                }
            })
        }
        return movResult
    }

    override fun getTvShow(): LiveData<List<MovieTvEntity>> {
        val listTvShowResult = MutableLiveData<List<MovieTvEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShowList(object : RemoteDataSource.LoadTvShowCallback{
                override fun onAllTvShowsReceived(tvShowResponse: List<TvResponse>) {
                    val tvShowList = ArrayList<MovieTvEntity>()
                    for(response in tvShowResponse){
                        val tvShow = MovieTvEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.popularity,
                            response.overview,
                            response.vote_average,
                            response.poster_path
                        )
                        tvShowList.add(tvShow)
                    }
                    listTvShowResult.postValue(tvShowList)
                }
            })
        }
        return listTvShowResult
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<MovieTvEntity> {
        val tvShowResult = MutableLiveData<MovieTvEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object :  RemoteDataSource.LoadTvShowDetailCallback {
                override fun onTvShowDetailReceived(tvShowResponse: TvResponse) {
                    val tvShow = MovieTvEntity(
                        tvShowResponse.id,
                        tvShowResponse.title,
                        tvShowResponse.release_date,
                        tvShowResponse.popularity,
                        tvShowResponse.overview,
                        tvShowResponse.vote_average,
                        tvShowResponse.poster_path
                    )
                    tvShowResult.postValue(tvShow)
                }
            })
        }
        return tvShowResult
    }

}