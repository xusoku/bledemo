package com.example.xusoku.bledemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.BottomBarBadge
import com.roughike.bottombar.BottomBarFragment
import com.roughike.bottombar.OnTabClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var mBottomBar : BottomBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mBottomBar = BottomBar.attach(this, savedInstanceState)
//        mBottomBar.setFragmentItems(supportFragmentManager, R.id.fragmentContainer,
//                BottomBarFragment(SampleFragment.newInstance("Content for Recents."), R.drawable.abc_ic_star_black_36dp, "Recents"),
//                BottomBarFragment(SampleFragment.newInstance("Content for favorites."), R.drawable.ic_favorites, "Favorites"),
//                BottomBarFragment(SampleFragment.newInstance("Content for nearby stuff."), R.drawable.ic_nearby, "Nearby"))
////                BottomBarFragment(SampleFragment.newInstance("Content for friends."), R.drawable.ic_friends, "Friends"))
////                BottomBarFragment(SampleFragment.newInstance("Content for food."), R.drawable.ic_restaurants, "Food"))
        mBottomBar = BottomBar.attach(this, savedInstanceState)
        mBottomBar.setFragmentItems(supportFragmentManager, R.id.fragmentContainer,
                BottomBarFragment(SampleFragment.newInstance("Content for recents."), R.drawable.ic_recents, "Recents"),
                BottomBarFragment(SampleFragment.newInstance("Content for favorites."), R.drawable.ic_favorites, "Favorites"),
                BottomBarFragment(SampleFragment.newInstance("Content for nearby stuff."), R.drawable.ic_nearby, "Nearby"),
                BottomBarFragment(SampleFragment.newInstance("Content for friends."), R.drawable.ic_friends, "Friends"),
                BottomBarFragment(SampleFragment.newInstance("Content for food."), R.drawable.ic_restaurants, "Food"));

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SampleFragment.newInstance("Content for recents.")).commit()
        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
//        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent))
//        mBottomBar.mapColorForTab(1, 0xFF5D4037.toInt())
//        mBottomBar.mapColorForTab(2, "#7B1FA2")
//        mBottomBar.mapColorForTab(3, "#FF5252")
//        mBottomBar.mapColorForTab(4, "#FF9800")
//
        mBottomBar.setActiveTabColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
//
//        mBottomBar.setOnTabClickListener(object : OnTabClickListener{
//            override fun onTabReSelected(p0: Int) {
//            }
//
//            override fun onTabSelected(p0: Int) {
//            }
//
//        })

    }
    override fun onSaveInstanceState(outState :Bundle ) {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }
}
