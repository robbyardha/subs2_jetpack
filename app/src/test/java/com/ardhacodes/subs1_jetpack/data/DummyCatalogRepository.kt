package com.ardhacodes.subs1_jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ardhacodes.subs1_jetpack.data.source.remote.RemoteDataSource
import com.ardhacodes.subs1_jetpack.data.source.remote.response.MovieResponse
import com.ardhacodes.subs1_jetpack.data.source.remote.response.TvResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DummyCatalogRepository(private val remote: RemoteDataSource) : CatalogDataSource {
    override fun getPopularMovies(): LiveData<List<MovieTvEntity>> {
        val listMovRes = MutableLiveData<List<MovieTvEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remote.getPlayingMovies(object : RemoteDataSource.LoadNowPlayingMoviesCallback{
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<MovieTvEntity>()
                    for (response in movieResponse){
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
                    listMovRes.postValue(movieList)
                }
            })
        }
        return listMovRes
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieTvEntity>
    {
        val movResultDetail = MutableLiveData<MovieTvEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remote.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetailCallback{
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
                    movResultDetail.postValue(movie)
                }
            })
        }
        return movResultDetail
    }

    override fun getTvShow(): LiveData<List<MovieTvEntity>> {
        val listTvRes = MutableLiveData<List<MovieTvEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remote.getTvShowList(object : RemoteDataSource.LoadTvShowCallback{

                override fun onAllTvShowsReceived(tvShowResponse: List<TvResponse>) {
                    val tvListArr = ArrayList<MovieTvEntity>()
                    for (response in tvShowResponse){
                        val tvRes = MovieTvEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.popularity,
                            response.overview,
                            response.vote_average,
                            response.poster_path
                        )
                        tvListArr.add(tvRes)
                    }
                    listTvRes.postValue(tvListArr)
                }
            })
        }
        return listTvRes
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<MovieTvEntity>
    {
        val tvResultDetail = MutableLiveData<MovieTvEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remote.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetailCallback{
                override fun onTvShowDetailReceived(tvShowResponse: TvResponse) {
                    val tv = MovieTvEntity(
                        tvShowResponse.id,
                        tvShowResponse.title,
                        tvShowResponse.release_date,
                        tvShowResponse.popularity,
                        tvShowResponse.overview,
                        tvShowResponse.vote_average,
                        tvShowResponse.poster_path
                    )
                    tvResultDetail.postValue(tv)
                }
            })
        }
        return tvResultDetail
    }
}