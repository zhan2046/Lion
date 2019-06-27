package com.ruzhan.movie


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
import com.ruzhan.movie.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.frag_movie_list.*

class MovieListFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MovieListFragment()
    }

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shotTransitionName = resources.getString(R.string.transition_shot)
        val shotBackgroundTransitionName = resources.getString(R.string.transition_shot_background)

        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)

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

        movieListAdapter = MovieListAdapter(object : OnItemClickListener<Movie> {
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
        })
        recycler_view.adapter = movieListAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
                false)

        OnRefreshHelper.setOnRefreshStatusListener(swipe_refresh, recycler_view, object :
                OnRefreshHelper.OnRefreshStatusListener {

            override fun onRefresh() {
                movieListViewModel.getRefreshMovieList()
            }

            override fun onLoadMore() {
                movieListViewModel.getLoadMoreMovieList()
            }
        })
        movieListViewModel.loadStatusLiveData.observe(this@MovieListFragment, Observer { isLoading ->
            if (isLoading != null) {
                swipe_refresh.isRefreshing = isLoading
            }
        })
        movieListViewModel.refreshLiveData.observe(this@MovieListFragment, Observer { movieList ->
            movieList?.let {
                movieListAdapter.setRefreshData(movieList)
            }
        })
        movieListViewModel.loadMoreLiveData.observe(this@MovieListFragment, Observer { movieList ->
            movieList?.let {
                movieListAdapter.setLoadMoreData(movieList)
            }
        })
        movieListViewModel.loadMovieEntityList()
        movieListViewModel.getRefreshMovieList()
    }
}