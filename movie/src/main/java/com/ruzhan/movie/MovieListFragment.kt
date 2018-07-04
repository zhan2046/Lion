package com.ruzhan.movie


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.ToastUtils
import com.ruzhan.lion.App
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import kotlinx.android.synthetic.main.frag_movie_list.*

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MovieListFragment()
    }

    private lateinit var movieListAdapter: MovieListAdapter
    private var movieListViewModel: MovieListViewModel = MovieListViewModel(App.get())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListAdapter = MovieListAdapter(object : OnItemClickListener<Movie> {
            override fun onItemClick(position: Int, bean: Movie, itemView: View) {
                ToastUtils.showShort(bean.title)
            }
        })
        recycler_view.adapter = movieListAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
                false)

        movieListViewModel.movieListLiveData.observe(this@MovieListFragment, Observer { movieList ->
            if (movieList != null) {
                movieListAdapter.setData(movieList)
            }
        })

        movieListViewModel.getMovieList(1)
    }
}