package com.ruzhan.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lion.font.FontHelper
import com.ruzhan.lion.util.LionTitleHelper
import com.ruzhan.movie.home.adapter.MovieHomeAdapter
import com.ruzhan.movie.home.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.lion_movie_main_home.*

class MovieHomeFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MovieHomeFragment()
    }

    private var movieHomeAdapter: MovieHomeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_movie_main_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let { activity ->
            val movieListViewModel =
                    ViewModelProviders.of(activity).get(MovieListViewModel::class.java)
            initData()
            initLiveData(movieListViewModel)
            movieListViewModel.getLocalMovieList()
            movieListViewModel.getRefreshMovieList()
        }
    }

    private fun initLiveData(movieListViewModel: MovieListViewModel) {
        movieListViewModel.titleListLiveData.observe(this,
                Observer<List<String>> { tagList ->
                    tagList?.let {
                        movieHomeAdapter?.setData(tagList)
                    }
                })
    }

    private fun initData() {
        titleTv.typeface = FontHelper.get().getBoldTypeface()
        titleTv.text = resources.getString(R.string.lion_tab_movie_title)
        LionTitleHelper.setToolbar(toolbar, activity)
        LionTitleHelper.setAlphaScaleAnimate(titleTv)

        val movieHomeAdapter = MovieHomeAdapter(childFragmentManager)
        this.movieHomeAdapter = movieHomeAdapter
        viewPager.adapter = movieHomeAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.isSmoothScrollingEnabled = true
    }
}