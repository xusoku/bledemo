package com.example.xusoku.bledemo.adpter.base

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.example.xusoku.bledemo.Grils
import com.example.xusoku.bledemo.R
import com.example.xusoku.bledemo.util.CommonManager

/**
 * Created by xusoku on 2016/4/7.
 */
class FilmAdapter(activity: Activity) : ExRecyclerAdapter<Grils.Gril,FilmAdapter.ViewHolder>(activity) {

    private val mMaxImageHeight =1000
    private val mMinImageHeight = 150
    var mImageWidth : Float = 0.0f


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
       return ViewHolder(inflateView(R.layout.item_recyc_layout, parent))
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView(data[position], position)
    }


    inner class  ViewHolder(view:View) : ExRecyclerAdapter.ExViewHolder<Grils.Gril>(view){
        override fun bindView(gril: Grils.Gril, pos: Int) {

            var iv=findView(R.id.item_iv) as ImageView

            var tv=findView(R.id.item_tv) as TextView


            tv.text=gril?.title
            Glide.with(activity)
                    .load("http://tnfs.tngou.net/img"+gril.img)
                    .dontAnimate()
                    .into(iv)
            //                    .into(object : SimpleTarget<GlideDrawable>(){
            //                        override fun onResourceReady(resource: GlideDrawable?, glideAnimation: GlideAnimation<in GlideDrawable>?) {
            //                            val width =resource?.intrinsicWidth as Int
            //                            val height = resource?.intrinsicHeight as Int
            ////                            Log.e("123===="+gril.id,"width-"+width+"   height-"+height);
            //                            var imageHeight =  (mImageWidth* 1.0f / width * height).toInt()
            //                            if (imageHeight > mMaxImageHeight) {
            //                                imageHeight = mMaxImageHeight
            //                            }
            //                            if (imageHeight < mMinImageHeight) {
            //                                imageHeight = mMinImageHeight
            //                            }
            ////                            Log.e("123","mMaxImageHeight-"+mImageWidth);
            ////                            Log.e("123","imageHeight-"+imageHeight);
            //
            //                            val params = iv.getLayoutParams()
            //                            params.height = imageHeight
            //                            iv.setLayoutParams(params)
            //                            iv.setImageDrawable(resource)
            //                        }
            //                    });
        }

    }
}
