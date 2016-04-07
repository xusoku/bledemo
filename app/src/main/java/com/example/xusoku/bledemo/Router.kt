package cn.nekocode.kotgo.sample.presentation

import android.content.Context
import com.example.xusoku.bledemo.Grils
import com.example.xusoku.bledemo.MainActivity
import org.jetbrains.anko.intentFor

/**
 */
fun Context.gotoMainPage() {
    startActivity(intentFor<MainActivity>())
}

fun Context.gotoPage2(gril: Grils.Gril) {
    startActivity(intentFor<MainActivity>(Pair("gril", gril)))
}


