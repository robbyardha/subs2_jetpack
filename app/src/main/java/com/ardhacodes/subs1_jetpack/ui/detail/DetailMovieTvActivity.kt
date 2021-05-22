package com.ardhacodes.subs1_jetpack.ui.detail

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ardhacodes.subs1_jetpack.R
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.databinding.ActivityDetailMovieTvBinding
import com.ardhacodes.subs1_jetpack.databinding.ContentDetailMovieTvBinding
import com.ardhacodes.subs1_jetpack.ui.movie.MovieViewModel
import com.ardhacodes.subs1_jetpack.utils.Helper.EXTRA_MOVIE
import com.ardhacodes.subs1_jetpack.utils.Helper.EXTRA_TV_SHOW
import com.ardhacodes.subs1_jetpack.utils.Helper.setImageGlide
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMovieTvActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOV = "extra_mov"
        const val EXTRA_CATEGORY = "extra_cat"
    }

    private lateinit var detailbinding : ActivityDetailMovieTvBinding
    private lateinit var result: MovieTvEntity
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailbinding = ActivityDetailMovieTvBinding.inflate(layoutInflater)
        setContentView(detailbinding.root)

        viewModelProviderConfig()

//        Declaration Binding
        var titlebinding = detailbinding.tvTitle
        var genrebinding = detailbinding.tvGenre
        var releasebinding = detailbinding.tvYear
        var scorebinding = detailbinding.tvScore
        var durationbinding = detailbinding.tvDuration
        var overviewbinding = detailbinding.tvOverview
        var posterbinding = detailbinding.ivPoster

        //Load
        titlebinding.text = result.title
        genrebinding.text = result.genre
        releasebinding.text = "Release : ${result.yearrelease}"
        scorebinding.text = "Score : ${result.score}"
        durationbinding.text = "Duration : ${result.duration}"
//        durationbinding.text = result.duration
        overviewbinding.text = result.overview
        //load Image using Glide
        Glide.with(this@DetailMovieTvActivity)
                .load(result.poster)
                .apply(RequestOptions())
                .into(posterbinding)

//        Load image using helper
    //        setImageGlide(this@DetailMovieTvActivity, result.poster, detailbinding.ivPoster)

//        Databinding quick
//        detailbinding.tvTitle.text = result.title
//        detailbinding.tvGenre.text = result.genre
//        detailbinding.tvYear.text = "Release : ${result.yearrelease}"
//        detailbinding.tvScore.text = "Score : ${result.score}"
//        detailbinding.tvDuration.text = "Duration : ${result.duration}"
//        detailbinding.tvOverview.text = result.overview



    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun viewModelProviderConfig()
    {
        val viewmodel = ViewModelProvider(this@DetailMovieTvActivity, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        val ex_id_mov_tv = intent.getStringExtra(EXTRA_MOV)
        val ex_category = intent.getStringExtra(EXTRA_CATEGORY)

        if(ex_category.equals(EXTRA_MOVIE, ignoreCase = true)){
            ex_id_mov_tv?.let {
                viewmodel.setMovieById(it)
            }
            result = viewmodel.getMovieById()!!
        }

        else if (ex_category.equals(EXTRA_TV_SHOW, ignoreCase = true)){
            ex_id_mov_tv?.let {
                viewmodel.setTvShowById(it)
            }
            result = viewmodel.getTvShowById()!!
        }
    }

    fun TitleActionBar()
    {
        val getTitle =intent.getStringExtra(EXTRA_MOV)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail ${getTitle}"
    }
}