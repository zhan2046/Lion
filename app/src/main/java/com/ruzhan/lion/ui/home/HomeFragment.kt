package com.ruzhan.lion.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzhan.favourites.FavouritesFragment
import com.ruzhan.lion.R
import com.ruzhan.movie.MovieListFragment
import kotlinx.android.synthetic.main.frag_home.*


/**
 * Created by ruzhan123 on 2018/7/3.
 */
class HomeFragment : Fragment() {

    companion object {

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

        bottom_navigation.setOnNavigationItemSelectedListener {
            if (bottom_navigation.selectedItemId != it.itemId) {
                replaceFragment(it.itemId)
            }
            true
        }

        // normal show MovieListFragment
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

        when(tabId) {
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
}