package com.ruzhan.lion.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import com.ruzhan.favourites.FavouritesFragment
import com.ruzhan.lion.R
import com.ruzhan.lion.util.AnimUtils
import com.ruzhan.movie.home.MovieListFragment
import kotlinx.android.synthetic.main.frag_home.*

class HomeFragment : Fragment() {

    companion object {

        private const val DEFAULT_START_DELAY = 300L
        private const val DEFAULT_DURATION = 900L
        private const val DEFAULT_SCALE_X = 0.8f

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val fragmentMap = HashMap<String, Fragment>()

    private var movieListFragment: MovieListFragment? = null
    private var favouritesFragment: FavouritesFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity
        if (activity is AppCompatActivity) {
            activity.setSupportActionBar(tool_bar)
        }
        replaceFragment(R.id.movie)
        initListener()
    }

    private fun initListener() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            if (bottom_navigation.selectedItemId != it.itemId) {
                replaceFragment(it.itemId)
            }
            true
        }
        tool_bar.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                tool_bar.viewTreeObserver.removeOnGlobalLayoutListener(this)
                animateToolbar()
            }
        })
    }

    private fun replaceFragment(tabId: Int) {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()
        for (frag in fragmentMap.values) {
            transaction.hide(frag)
        }
        var fragTag: String? = null
        var frag: Fragment? = null
        when (tabId) {
            R.id.movie -> {
                fragTag = "movieListFragment"
                frag = fragmentMap[fragTag]

                if (frag == null) {
                    frag = MovieListFragment.newInstance()
                    movieListFragment = frag
                    transaction.add(R.id.container, frag, fragTag)

                } else {
                    transaction.show(frag)
                }

            }
            R.id.favourites -> {
                fragTag = "favouritesFragment"
                frag = fragmentMap[fragTag]

                if (frag == null) {
                    frag = FavouritesFragment.newInstance()
                    favouritesFragment = frag
                    transaction.add(R.id.container, frag, fragTag)

                } else {
                    transaction.show(frag)
                }
            }
        }
        if (fragTag != null && frag != null) {
            fragmentMap[fragTag] = frag
        }
        if (!fm.isDestroyed) {
            transaction.commitAllowingStateLoss()
        }
    }

    private fun animateToolbar() {
        val t = tool_bar.getChildAt(0)
        if (t != null && t is TextView) {
            t.letterSpacing = 0.1f
            t.alpha = 0f
            t.scaleX = DEFAULT_SCALE_X
            t.animate()
                    .alpha(1f)
                    .scaleX(1f)
                    .setStartDelay(DEFAULT_START_DELAY)
                    .setDuration(DEFAULT_DURATION).interpolator = AnimUtils.getFastOutSlowInInterpolator(activity)
        }
    }
}