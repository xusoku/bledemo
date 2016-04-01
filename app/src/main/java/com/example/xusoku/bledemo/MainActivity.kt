package com.example.xusoku.bledemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.xusoku.bledemo.base.BaseActivity

class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setLayoutView(): Int {
       return  R.layout.activity_main
    }

    override fun initVariable() {
    }

    override fun findViews() {
    }

    override fun initData() {
    }

    override fun setListener() {
    }

    override fun doClick(view: View?) {
    }
}
