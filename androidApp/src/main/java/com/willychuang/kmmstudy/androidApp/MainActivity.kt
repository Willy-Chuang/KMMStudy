package com.willychuang.kmmstudy.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.willychuang.kmmstudy.shared.Greeting
import android.widget.TextView
import com.willychuang.kmmstudy.shared.GdgLogger
import com.willychuang.kmmstudy.shared.service.SpotifyService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.logging.Logger

fun greet(): String {
    return Greeting().greeting()
}

val service = SpotifyService()
val scope = MainScope()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        findViewById<Button>(R.id.btn_main_go_xml_layout).setOnClickListener(onButtonListener)
    }

    private val onButtonListener = View.OnClickListener {

        scope.launch {
            kotlin.runCatching {
                service.getAlbums()
            }.onSuccess {
                GdgLogger.i("Data","$it")
            }.onFailure {
                GdgLogger.e("Error","$it")
            }
        }
    }
}
