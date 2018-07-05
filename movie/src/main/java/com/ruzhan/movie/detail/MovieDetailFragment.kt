package com.ruzhan.movie.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzhan.movie.R

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailFragment : Fragment() {

    companion object {

        private const val MOVIE_ID: String = "MOVIE_ID"

        @JvmStatic
        fun newInstance(movieId: String): MovieDetailFragment {
            val args = Bundle()
            args.putString(MOVIE_ID, movieId)
            val frag = MovieDetailFragment()
            frag.arguments = args
            return  frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}