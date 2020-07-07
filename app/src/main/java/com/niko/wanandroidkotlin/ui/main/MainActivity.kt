package com.niko.wanandroidkotlin.ui.main

import android.os.Bundle
import com.niko.wanandroidkotlin.R
import com.niko.wanandroidkotlin.base.MvpBaseActivity

class MainActivity : MvpBaseActivity<MainPresenter>() {
    override fun getPresenter(): MainPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initWidget() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
