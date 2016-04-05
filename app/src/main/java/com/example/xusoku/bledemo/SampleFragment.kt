/*
 * BottomBar library for Android
 * Copyright (c) 2016 Iiro Krankka (http://github.com/roughike).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.xusoku.bledemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.xusoku.bledemo.api.ApiService
import com.example.xusoku.bledemo.model.film
import com.squareup.okhttp.Callback
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import kotlinx.android.synthetic.main.fragment_mian.*
import org.jetbrains.anko.async
import retrofit.Call
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import java.io.IOException

/**
 */
class SampleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(activity)
        textView.text = arguments?.getString(ARG_TEXT)?:""
        var view = inflater?.inflate(R.layout.fragment_mian,null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tv.text=arguments?.getString(ARG_TEXT)?:""
        initData()
    }
    companion object {
        private val ARG_TEXT = "ARG_TEXT"

        fun newInstance(text: String): SampleFragment {
            val args = Bundle()
            args.putString(ARG_TEXT, text)
            val sampleFragment = SampleFragment()
            sampleFragment.arguments = args
            return sampleFragment
        }
    }
    fun initData(){
        var  retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("http://api.dymfilm.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        var service : ApiService= retrofit.create(ApiService::class.java)

        async() {
            var call  =service.listfilms("1").execute() as Call<film>

//            call.enqueue(object : Callback<film>(){
//                override fun onFailure(request: Request?, e: IOException?) {
//
//                }
//
//                override fun onResponse(response: Response?) {
//                    var statusCode = response?.code()
//                    var user = response?.body()
//                }
//
//            })
//
//                Log.e("list",list.tags.t)
        }

    }
}
