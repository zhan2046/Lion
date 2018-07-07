package com.ruzhan.movie


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.app.SharedElementCallback
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzhan.lion.App
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.movie.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.frag_movie_list.*

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListFragment : Fragment() {

    companion object {
        const val MOVIE_LIST_REQUEST_CODE: Int = 1000

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

        movieListAdapter = MovieListAdapter(object : OnItemClickListener<Movie> {
            override fun onItemClick(position: Int, bean: Movie, itemView: View) {
                val act = activity!!
                val transitionShot = act.getString(R.string.transition_shot)
                val transitionShotBackground = act.getString(R.string.transition_shot_background)

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(act,
                        Pair.create(itemView, transitionShot), Pair.create(itemView, transitionShotBackground))

                MovieDetailActivity.launch(activity!!, bean, options)
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