package com.ruzhan.movie.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.app.SharedElementCallback
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruzhan.lion.helper.OnRefreshHelper
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.util.ResUtils
import com.ruzhan.movie.R
import com.ruzhan.movie.detail.MovieDetailActivity
import com.ruzhan.movie.home.adapter.MovieListAdapter
import com.ruzhan.movie.home.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.lion_frag_movie_list.*

class MovieListFragment : Fragment() {

    companion object {

        private const val TAG_KEY = "TAG_KEY"

        @JvmStatic
        fun newInstance(): MovieListFragment {
            val args = Bundle()
            args.putString(TAG_KEY, ResUtils.getApp().getString(R.string.lion_tab_tag_new))
            val frag = MovieListFragment()
            frag.arguments = args
            return frag
        }

        @JvmStatic
        fun newInstance(tagKey: String): MovieListFragment {
            val args = Bundle()
            args.putString(TAG_KEY, tagKey)
            val frag = MovieListFragment()
            frag.arguments = args
            return frag
        }
    }

    private val movieListAdapter = MovieListAdapter()
    private var tagKey = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tagKey = arguments?.getString(TAG_KEY) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let { activity ->
            val movieListViewModel =
                    ViewModelProviders.of(activity).get(MovieListViewModel::class.java)
            initData(movieListViewModel)
            initListener(movieListViewModel)
            initLiveData(movieListViewModel)
        }
    }

    private fun initData(movieListViewModel: MovieListViewModel) {
        recycler_view.adapter = movieListAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,
                false)
        val tagMovieList = movieListViewModel.getRefreshTagList(tagKey)
        movieListAdapter.setRefreshData(tagMovieList)
    }

    private fun initListener(movieListViewModel: MovieListViewModel) {
        val shotTransitionName = resources.getString(R.string.transition_shot)
        val shotBackgroundTransitionName = resources.getString(R.string.transition_shot_background)
        setExitSharedElementCallback(object : SharedElementCallback() {

            override fun onMapSharedElements(names: MutableList<String>,
                                             sharedElements: MutableMap<String, View>) {
                if (sharedElements.size != names.size) {
                    val sharedShot = sharedElements[shotTransitionName]
                    sharedShot?.let {
                        sharedElements[shotBackgroundTransitionName] = sharedShot
                    }
                }
            }
        })
        OnRefreshHelper.setOnRefreshStatusListener(swipe_refresh, recycler_view, object :
                OnRefreshHelper.OnRefreshStatusListener {

            override fun onRefresh() {
                movieListViewModel.getRefreshMovieList()
            }

            override fun onLoadMore() {
                movieListViewModel.getLoadMoreMovieList()
            }
        }, R.color.colorAccent)
        movieListAdapter.onItemClickListener = object : OnItemClickListener<Movie> {
            override fun onItemClick(position: Int, bean: Movie, itemView: View) {
                activity?.let { activity ->
                    val transitionShot = activity.getString(R.string.transition_shot)
                    val transitionShotBackground =
                            activity.getString(R.string.transition_shot_background)
                    val options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                                    Pair.create(itemView, transitionShot),
                                    Pair.create(itemView, transitionShotBackground))
                    MovieDetailActivity.launch(activity, bean, options)
                }
            }
        }
    }

    private fun initLiveData(movieListViewModel: MovieListViewModel) {
        movieListViewModel.loadStatusLiveData.observe(this, Observer { isLoading ->
            if (isLoading != null && !isLoading) {
                swipe_refresh.isRefreshing = isLoading
            }
        })
        movieListViewModel.refreshLiveData.observe(this, Observer { movieList ->
            movieList?.let {
                val tagMovieList = movieListViewModel.getRefreshTagList(tagKey)
                movieListAdapter.setRefreshData(tagMovieList)
            }
        })
        movieListViewModel.loadMoreLiveData.observe(this, Observer { movieList ->
            movieList?.let {
                val tagMovieList = movieListViewModel.getLoadMoreTagList(tagKey)
                movieListAdapter.setLoadMoreData(tagMovieList)
            }
        })
    }
}