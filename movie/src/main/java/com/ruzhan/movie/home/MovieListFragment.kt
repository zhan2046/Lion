package com.ruzhan.movie.home


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.app.SharedElementCallback
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzhan.lion.helper.OnRefreshHelper
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.movie.R
import com.ruzhan.movie.detail.MovieDetailActivity
import com.ruzhan.movie.home.adapter.MovieListAdapter
import com.ruzhan.movie.home.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.lion_frag_movie_list.*

class MovieListFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MovieListFragment()
    }

    private val movieListAdapter = MovieListAdapter()
    private var movieListViewModel: MovieListViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
        this.movieListViewModel = movieListViewModel
        recycler_view.adapter = movieListAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
                false)
        initListener()
        initLiveData()
        movieListViewModel.getLocalMovieList()
        movieListViewModel.getRefreshMovieList()
    }

    private fun initListener() {
        val shotTransitionName = resources.getString(R.string.transition_shot)
        val shotBackgroundTransitionName = resources.getString(R.string.transition_shot_background)
        setExitSharedElementCallback(object : SharedElementCallback() {

            override fun onMapSharedElements(names: MutableList<String>,
                                             sharedElements: MutableMap<String, View>) {
                if (sharedElements.size != names.size) {
                    // couldn't map all shared elements
                    val sharedShot = sharedElements[shotTransitionName]
                    if (sharedShot != null) {
                        // has shot so add shot background, mapped to same view
                        sharedElements[shotBackgroundTransitionName] = sharedShot
                    }
                }
            }
        })
        OnRefreshHelper.setOnRefreshStatusListener(swipe_refresh, recycler_view, object :
                OnRefreshHelper.OnRefreshStatusListener {

            override fun onRefresh() {
                movieListViewModel?.getRefreshMovieList()
            }

            override fun onLoadMore() {
                movieListViewModel?.getLoadMoreMovieList()
            }
        }, R.color.colorAccent)
        movieListAdapter.onItemClickListener = object : OnItemClickListener<Movie> {
            override fun onItemClick(position: Int, bean: Movie, itemView: View) {
                val activity = activity
                if (activity != null) {
                    val transitionShot = activity.getString(R.string.transition_shot)
                    val transitionShotBackground = activity.getString(R.string.transition_shot_background)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                            Pair.create(itemView, transitionShot), Pair.create(itemView, transitionShotBackground))
                    MovieDetailActivity.launch(activity, bean, options)
                }
            }
        }
    }

    private fun initLiveData() {
        val movieListViewModel = movieListViewModel
        if (movieListViewModel != null) {
            movieListViewModel.loadStatusLiveData.observe(this@MovieListFragment, Observer { isLoading ->
                if (isLoading != null && !isLoading) {
                    swipe_refresh.isRefreshing = isLoading
                }
            })
            movieListViewModel.refreshLiveData.observe(this@MovieListFragment, Observer { movieList ->
                movieList?.let {
                    progressBar.visibility = View.GONE
                    movieListAdapter.setRefreshData(movieList)
                }
            })
            movieListViewModel.loadMoreLiveData.observe(this@MovieListFragment, Observer { movieList ->
                movieList?.let {
                    progressBar.visibility = View.GONE
                    movieListAdapter.setLoadMoreData(movieList)
                }
            })
        }
    }
}