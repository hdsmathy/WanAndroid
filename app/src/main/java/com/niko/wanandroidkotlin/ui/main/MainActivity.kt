package com.niko.wanandroidkotlin.ui.main

import android.os.Bundle
import com.niko.wanandroidkotlin.R
import com.niko.wanandroidkotlin.base.MvpBaseActivity

class MainActivity : MvpBaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
