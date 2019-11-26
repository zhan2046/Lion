package com.ruzhan.movie.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.app.ActivityCompat.finishAfterTransition
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.Video
import com.ruzhan.lion.ui.widget.ElasticDragDismissFrameLayout
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.R
import com.ruzhan.movie.detail.activity.ImageDetailActivity
import com.ruzhan.movie.detail.adapter.MovieDetailAdapter
import com.ruzhan.movie.detail.viewmodel.MovieDetailViewModel
import com.ruzhan.movie.model.ImageListModel
import com.ruzhan.movie.video.WebVideoActivity
import kotlinx.android.synthetic.main.lion_frag_movie_detail.*

class MovieDetailFragment : Fragment() {

    companion object {

        private const val MOVIE: String = "MOVIE"
        private const val TRANSITION_TIME: Long = 450

        @JvmStatic
        fun newInstance(movie: Movie): MovieDetailFragment {
            val args = Bundle()
            args.putParcelable(MOVIE, movie)
            val frag = MovieDetailFragment()
            frag.arguments = args
            return frag
        }
    }

    private lateinit var movie: Movie
    private val movieDetailAdapter = MovieDetailAdapter()
    private var chromeFaber: ElasticDragDismissFrameLayout.SystemChromeFader? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getParcelable(MOVIE) as Movie
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieDetailViewModel =
                ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        initData(movieDetailViewModel)
        initListener(movieDetailViewModel)
        movieDetailViewModel.getMovieDetail(movie.id)
    }

    private fun initData(movieDetailViewModel: MovieDetailViewModel) {
        movieDetailViewModel.movieId = movie.id
        ImageLoader.get().loadNoCrossFade(shot, movie.image,
                ViewUtils.getPlaceholder(activity, 0))
        recycler_view.adapter = movieDetailAdapter
    }

    private fun initListener(movieDetailViewModel: MovieDetailViewModel) {
        activity?.let { activity ->
            movieDetailAdapter.onItemVideoClickListener = object : OnItemClickListener<Video> {

                override fun onItemClick(position: Int, bean: Video, itemView: View) {
                    WebVideoActivity.launch(activity, bean.playWebUrl)
                }
            }
            movieDetailAdapter.onItemImageClickListener =
                    object : OnItemClickListener<ImageListModel> {

                        override fun onItemClick(position: Int, bean: ImageListModel, itemView: View) {
                            ImageDetailActivity.launch(activity, bean)
                        }
                    }
            recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    shot.offset = movieDetailAdapter.getHeaderHolderTop()
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    shot.isImmediatePin = newState == RecyclerView.SCROLL_STATE_SETTLING
                }
            })
            recycler_view.onFlingListener = object : RecyclerView.OnFlingListener() {
                override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                    shot.isImmediatePin = true
                    return false
                }
            }
            back.setOnClickListener {
                closeFragmentUpdateUi()
                finishAfterTransition(activity)
            }
            chromeFaber = object : ElasticDragDismissFrameLayout.SystemChromeFader(activity) {

                override fun onDragDismissed() {
                    closeFragmentUpdateUi()
                    finishAfterTransition(activity)
                }
            }
            postponeEnterTransition()
            shot.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    shot.viewTreeObserver.removeOnPreDrawListener(this)
                    startPostponedEnterTransition()
                    return true
                }
            })
            movieDetailViewModel.movieDetailLiveData.observe(this,
                    Observer { movieDetail ->
                        movieDetail?.let { movieDetailAdapter.setData(it) }
                    })
            shot.postDelayed({ movieDetailViewModel.getLocalMovieDetail(movie.id) },
                    TRANSITION_TIME)
        }
    }

    override fun onResume() {
        super.onResume()
        elastic_drag_dismiss.addListener(chromeFaber)
    }

    override fun onPause() {
        super.onPause()
        elastic_drag_dismiss.removeListener(chromeFaber)
    }

    fun closeFragmentUpdateUi() {
        recycler_view?.let { recycler_view.visibility = View.INVISIBLE }
    }
}