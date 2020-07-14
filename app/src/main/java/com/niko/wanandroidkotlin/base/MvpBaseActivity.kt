package com.niko.wanandroidkotlin.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @Description: Activity基类
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
abstract class MvpBaseActivity<P : IBasePresenter> : AppCompatActivity(), IBaseView {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initWidget()
        mPresenter = getPresenter()
    }

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

    fun setOnClickListener(vararg view: View, listener: View.OnClickListener) {
        view.forEach { v ->
            v.setOnClickListener(listener)
        }
        /*for (v in view) {
            v.setOnClickListener(listener)
        }*/
    }

}