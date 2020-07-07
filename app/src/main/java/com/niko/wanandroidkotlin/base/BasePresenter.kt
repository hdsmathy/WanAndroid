package com.niko.wanandroidkotlin.base

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
abstract class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    private var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detchView() {
        this.mView = null
    }
}