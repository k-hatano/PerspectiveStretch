package jp.nita.perspectivestretch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View

class MainActivity : AppCompatActivity() {
    var time = 0
    var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        runnable = Runnable {
            time++
            val view: PerspectiveStretchView = findViewById(R.id.view)
            view.updateViewBy(time)
            handler.postDelayed(runnable!!, 10)
        }
        handler.post(runnable!!)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.apply {
                systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }
    }
}