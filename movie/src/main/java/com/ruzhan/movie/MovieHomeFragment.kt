package com.ruzhan.movie

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lion.font.FontHelper
import com.ruzhan.lion.util.LionTitleHelper
import com.ruzhan.movie.home.adapter.MovieHomeAdapter
import com.ruzhan.movie.home.viewmodel.MovieListViewModel
import com.ruzhan.movie.widget.ScaleTransitionPagerTitleView
import kotlinx.android.synthetic.main.lion_movie_main_home.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator

class MovieHomeFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MovieHomeFragment()
    }

    private var movieHomeAdapter: MovieHomeAdapter? = null
    private var commonNavigator: CommonNavigator? = null
    private val titleList = ArrayList<String>()

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
                        titleList.clear()
                        titleList.addAll(tagList)
                        movieHomeAdapter?.setData(titleList)
                        commonNavigator?.notifyDataSetChanged()
                    }
                })
    }

    private fun initData() {
        titleTv.typeface = FontHelper.get().boldFontTypeface
        titleTv.text = resources.getString(R.string.lion_tab_movie_title)
        LionTitleHelper.setToolbar(toolbar, activity)
        LionTitleHelper.setAlphaScaleAnimate(titleTv)

        val movieHomeAdapter = MovieHomeAdapter(childFragmentManager)
        this.movieHomeAdapter = movieHomeAdapter
        viewPager.adapter = movieHomeAdapter

        val commonNavigator = CommonNavigator(activity)
        this.commonNavigator = commonNavigator
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getTitleView(context: Context, index: Int):
                    IPagerTitleView {
                val simplePagerTitleView = ScaleTransitionPagerTitleView(context)
                simplePagerTitleView.typeface = FontHelper.get().boldFontTypeface
                simplePagerTitleView.text = titleList[index]
                simplePagerTitleView.textSize = 16f
                simplePagerTitleView.normalColor =
                        ContextCompat.getColor(context, R.color.text_tertiary_dark)
                simplePagerTitleView.selectedColor =
                        ContextCompat.getColor(context, R.color.lion_movie_colorAccent)
                simplePagerTitleView.setOnClickListener {
                    viewPager.currentItem = index
                }
                return simplePagerTitleView
            }

            override fun getCount(): Int = titleList.size

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                indicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
                indicator.setColors(ContextCompat.getColor(context, R.color.lion_movie_colorAccent))
                indicator.roundRadius = resources.getDimension(R.dimen.space_small_4)
                indicator.xOffset = resources.getDimension(R.dimen.space_small_4)
                indicator.yOffset = resources.getDimension(R.dimen.space_small_4)
                return indicator
            }
        }
        magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(magicIndicator, viewPager)
    }
}