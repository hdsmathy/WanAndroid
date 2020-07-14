package com.niko.wanandroidkotlin.ui.main

import android.view.View
import com.niko.wanandroidkotlin.R
import com.niko.wanandroidkotlin.base.MvpBaseActivity
import com.niko.wanandroidkotlin.extentions.startActivityA
import com.niko.wanandroidkotlin.ui.study.FlowLayoutActivity
import com.niko.wanandroidkotlin.ui.study.ScrollViewActivity
import com.niko.wanandroidkotlin.ui.study.TextActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpBaseActivity<MainPresenter>() {

    override fun getPresenter(): MainPresenter = MainPresenter()

    override fun initWidget() {
        setOnClickListener(
            btn_flow_layout,
            btn_scroll_layout,
            btn_text,
            listener = View.OnClickListener { v ->
                when (v) {
                    btn_flow_layout -> startActivityA(FlowLayoutActivity::class.java)
                    btn_scroll_layout -> startActivityA(ScrollViewActivity::class.java)
                    btn_text -> startActivityA(TextActivity::class.java)
                }
            }
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
