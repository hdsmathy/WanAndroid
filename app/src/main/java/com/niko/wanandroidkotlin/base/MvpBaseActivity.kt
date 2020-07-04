package com.niko.wanandroidkotlin.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @Description: Activity基类
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
abstract class MvpBaseActivity<P : BasePresenter<BaseView>> : AppCompatActivity(), IBaseView {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        hideActionBar()
        initWidget()
        mPresenter = getPresenter()
    }

    fun hideActionBar() = supportActionBar?.hide()

    abstract fun getPresenter(): P

    abstract fun initWidget()

    abstract fun getLayoutId(): Int

    fun toast(message: String, showTime: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, showTime).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter?.detchView()
            mPresenter = null
        }
    }

}