package com.example.xusoku.bledemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.xusoku.bledemo.adpter.base.CommonFragmentAdapter
import com.example.xusoku.bledemo.base.BaseActivity
import com.example.xusoku.bledemo.views.HackyViewPager
import com.example.xusoku.bledemo.views.viewpagerindicator.PageIndicator
import com.example.xusoku.bledemo.views.viewpagerindicator.scrollbar.BitmapBar
import com.example.xusoku.bledemo.views.viewpagerindicator.scrollbar.ColorBar
import com.example.xusoku.bledemo.views.viewpagerindicator.scrollbar.ScrollBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

     val tabDrawables = intArrayOf(R.drawable.main_btn_home_selector, R.drawable.main_btn_film_review_selector, R.drawable.main_btn_price_selector, R.drawable.main_btn_share_ticket_selector)
     val tabNames = arrayOf("影片", "影评", "比价", "晒票")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setLayoutView(): Int {
       return  R.layout.activity_main
    }

    override fun initVariable() {
    }


    override fun findViews() {

        viewPager.setOffscreenPageLimit(4)

    }

    override fun initData() {

        val mPriceFragment = SampleFragment.newInstance("wo");
        val mPriceFragment1 = SampleFragment.newInstance("wo1");
        val mPriceFragment2 = SampleFragment.newInstance("wo2");
        val mPriceFragment3 = SampleFragment.newInstance("wo3");
        val fragments = ArrayList<Fragment>()
        fragments.add(mPriceFragment)
        fragments.add(mPriceFragment1)
        fragments.add(mPriceFragment2)
        fragments.add(mPriceFragment3)
        viewPager.setAdapter(CommonFragmentAdapter(supportFragmentManager, fragments))
        indicator.setViewPager(viewPager, 0)
        title=tabNames[0]
        indicator.setIndicatorAdapter(object : PageIndicator.IndicatorAdapter{
            override fun getIndicatorView(position: Int): View? {
                val textView = mInflater.inflate(R.layout.layout_main_tab_item, null) as TextView
                textView.setText(tabNames[position])
                textView.setCompoundDrawablesWithIntrinsicBounds(0, tabDrawables[position], 0, 0)
                return textView
            }
            override fun onPageScrolled(view: View?, position: Int, selectPercent: Float) {
//                Log.e("gfd",position.toString())
//                title=tabNames[position]
            }
        })

        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                title=tabNames[position]
            }
        })
        val colorBar = ColorBar(mContext, mContext.resources.getColor(R.color.red_color))
        //        colorBar.setWidth(DimenUtils.dp2px(mContext, 80));

        indicator.setScrollBar(colorBar)

    }

    override fun setListener() {
    }

    override fun doClick(view: View?) {
    }
}
