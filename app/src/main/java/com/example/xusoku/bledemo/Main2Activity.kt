package com.example.xusoku.bledemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.xusoku.bledemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.act

class Main2Activity : BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_main2
    }

    var pic : String = ""

    override fun initVariable() {
        pic=intent.getStringExtra("gril")
    }

    override fun findViews() {
    }

    override fun initData() {
        Glide.with(act)
                .load(pic)
                .dontAnimate()

                .into(big_iv)
    }

    override fun setListener() {
    }

    override fun doClick(view: View?) {
    }

}
