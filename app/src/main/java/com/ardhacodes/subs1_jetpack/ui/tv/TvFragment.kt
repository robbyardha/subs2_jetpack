package com.ardhacodes.subs1_jetpack.ui.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardhacodes.subs1_jetpack.R
import com.ardhacodes.subs1_jetpack.data.MovieTvEntity
import com.ardhacodes.subs1_jetpack.databinding.FragmentMovieBinding
import com.ardhacodes.subs1_jetpack.databinding.FragmentTvBinding
import com.ardhacodes.subs1_jetpack.ui.CallbackMovTv
import com.ardhacodes.subs1_jetpack.ui.detail.DetailMovieTvActivity
import com.ardhacodes.subs1_jetpack.ui.movie.MovieAdapter
import com.ardhacodes.subs1_jetpack.ui.movie.MovieViewModel
import com.ardhacodes.subs1_jetpack.utils.Helper
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy


class TvFragment : Fragment(), CallbackMovTv {

    lateinit var fragmentTvBinding : FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            viewModelProviderConfig()
        }
    }

    private fun viewModelProviderConfig() {
        val viewmodel =ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]
        val tv = viewmodel.getdDataTv()
        val tvadaper = TvAdapter(this)
        tvadaper.setTv(tv)

        with(fragmentTvBinding.rvTv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = tvadaper
        }
    }

    override fun onItemClicked(movtvEntity: MovieTvEntity) {
        startActivity(
            Intent(context, DetailMovieTvActivity::class.java)
            .putExtra(DetailMovieTvActivity.EXTRA_MOV, movtvEntity.title)
            .putExtra(DetailMovieTvActivity.EXTRA_CATEGORY, Helper.EXTRA_TV_SHOW)
        )
    }
}