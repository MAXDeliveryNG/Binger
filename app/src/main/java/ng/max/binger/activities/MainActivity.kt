package ng.max.binger.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import ng.max.binger.R
import ng.max.binger.adapters.TvShowPagerAdapter
import ng.max.binger.fragments.AiringTodayFragment
import ng.max.binger.fragments.PopularShowsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set support toolbar
        setSupportActionBar(toolbar)

        // page count for view pager
        val pageCount = 2

        // view pager for tv shows
        val pagerAdapter = TvShowPagerAdapter(supportFragmentManager, pageCount, ::getTitle, ::getFragment)
        viewPager.adapter = pagerAdapter

        // setup tab layout with view pager.
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun getTitle(index: Int): String {
        // get the title for the tab
        val titleId = when (index) {
            0 -> R.string.title_air_today
            else -> R.string.title_popuplar
        }

        return getString(titleId)
    }

    private fun getFragment(index: Int): Fragment {
        // get fragment for the tab
        return when (index) {
            0 -> AiringTodayFragment.newInstance()
            else -> PopularShowsFragment.newInstance()
        }
    }
}
