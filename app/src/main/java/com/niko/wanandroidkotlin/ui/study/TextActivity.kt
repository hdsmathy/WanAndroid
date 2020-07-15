package com.niko.wanandroidkotlin.ui.study

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.AppCompatTextView
import com.niko.wanandroidkotlin.R
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        val view = findViewById<AppCompatTextView>(R.id.tv_change)

        Handler().postDelayed({
            startAnimator()
        }, 3000)

    }

    private fun startAnimator() {
        ObjectAnimator.ofFloat(tv_change, "percent", 0.0f, 1.0f).setDuration(5000).start()
    }
}