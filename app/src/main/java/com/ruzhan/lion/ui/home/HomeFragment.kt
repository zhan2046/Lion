package com.ruzhan.lion.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.ToastUtils
import com.ruzhan.lion.R
import com.ruzhan.movie.MovieListFragment
import kotlinx.android.synthetic.main.frag_home.*


/**
 * Created by ruzhan123 on 2018/7/3.
 */
class HomeFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private var movieListFragment: MovieListFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_navigation.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.movie &&
                    bottom_navigation.selectedItemId != R.id.movie) {
                initMovieListFragment()

            } else if (it.itemId == R.id.favourites &&
                    bottom_navigation.selectedItemId != R.id.favourites) {
                ToastUtils.showShort("favourites")
            }
            true
        }

        // normal show MovieListFragment
        initMovieListFragment()
    }

    fun initMovieListFragment() {
        if (movieListFragment == null) {
            movieListFragment = MovieListFragment.newInstance()
            childFragmentManager
                    .beginTransaction()
                    .add(R.id.container, movieListFragment, "movieListFragment")
                    .commit()
        }
    }
}