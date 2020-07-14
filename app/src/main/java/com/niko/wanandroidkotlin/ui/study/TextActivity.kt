package com.niko.wanandroidkotlin.ui.study

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.niko.wanandroidkotlin.R
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        val view = findViewById<AppCompatTextView>(R.id.tv_change)

         ObjectAnimator.ofFloat(view, "mPercent", 0f, 1f).apply {
            duration = 5000
        }.start()
    }
}