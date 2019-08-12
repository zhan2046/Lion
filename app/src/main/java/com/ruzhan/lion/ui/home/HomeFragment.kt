package com.ruzhan.lion.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ruzhan.favourites.FavouritesFragment
import com.ruzhan.lion.R
import com.ruzhan.movie.MovieHomeFragment

class HomeFragment : Fragment() {

    companion object {

        private const val DEFAULT_START_DELAY = 300L
        private const val DEFAULT_DURATION = 900L
        private const val DEFAULT_SCALE_X = 0.8f

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val fragmentMap = HashMap<String, Fragment>()

    private var movieHomeFragment: MovieHomeFragment? = null
    private var favouritesFragment: FavouritesFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replaceFragment(R.id.movie)
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
                fragTag = "MovieHomeFragment"
                frag = fragmentMap[fragTag]

                if (frag == null) {
                    frag = MovieHomeFragment.newInstance()
                    movieHomeFragment = frag
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
}