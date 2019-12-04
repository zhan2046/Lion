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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.movie.listener.OnItemClickListener
import com.ruzhan.movie.model.Video
import com.ruzhan.movie.base.widget.ElasticDragDismissFrameLayout
import com.ruzhan.movie.utils.ViewUtils
import com.ruzhan.movie.R
import com.ruzhan.movie.db.entity.MovieEntity
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
        fun newInstance(movie: MovieEntity): MovieDetailFragment {
            val args = Bundle()
            args.putParcelable(MOVIE, movie)
            val frag = MovieDetailFragment()
            frag.arguments = args
            return frag
        }
    }

    private lateinit var movie: MovieEntity
    private val movieDetailAdapter = MovieDetailAdapter()
    private var chromeFaber: ElasticDragDismissFrameLayout.SystemChromeFader? = null
    private val movieDetailViewModel: MovieDetailViewModel by lazy {
        ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getParcelable(MOVIE) as MovieEntity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initListener()
        shot.postDelayed({
            movieDetailViewModel.getMovieDetail(movie.id)
        }, TRANSITION_TIME)
    }

    private fun initData() {
        activity?.let { activity ->
            ImageLoader.get().loadNoCrossFade(shot, movie.image,
                    ViewUtils.getPlaceholder(activity, 0))
            val layoutManager = GridLayoutManager(activity, MovieDetailAdapter.SPAN_COUNT,
                    GridLayoutManager.VERTICAL, false)
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return movieDetailAdapter.getSpanSize(position)
                }
            }
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = movieDetailAdapter
        }
    }

    private fun initListener() {
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
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    shot.offset = movieDetailAdapter.getHeaderHolderTop()
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    shot.isImmediatePin = newState == RecyclerView.SCROLL_STATE_SETTLING
                }
            })
            recyclerView.onFlingListener = object : RecyclerView.OnFlingListener() {
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
        }
    }

    override fun onResume() {
        super.onResume()
        chromeFaber?.let { chromeFaber ->
            elasticDragDismissFrameLayout.addListener(chromeFaber)
        }
    }

    override fun onPause() {
        super.onPause()
        chromeFaber?.let { chromeFaber ->
            elasticDragDismissFrameLayout.removeListener(chromeFaber)
        }
    }

    fun closeFragmentUpdateUi() {
        recyclerView?.let { recyclerView.visibility = View.INVISIBLE }
    }
}