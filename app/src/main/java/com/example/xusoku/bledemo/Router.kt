package cn.nekocode.kotgo.sample.presentation

import android.content.Context
import com.example.xusoku.bledemo.Grils
import com.example.xusoku.bledemo.Main2Activity
import com.example.xusoku.bledemo.MainActivity
import org.jetbrains.anko.intentFor

/**
 */
fun Context.gotoMainPage() {
    startActivity(intentFor<MainActivity>())
}

fun Context.gotoPage2(str: String) {
    startActivity(intentFor<Main2Activity>(Pair("gril", str)))
}
fun Context.gotoPage3(gril: Grils.Gril) {
    startActivity(intentFor<Main2Activity>(Pair("gril", gril)))
}


