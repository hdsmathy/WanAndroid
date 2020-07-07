package com.niko.wanandroidkotlin.base

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
abstract class BasePresenter<in V : IBaseView> : IBasePresenter<IBaseView> {

    private var mView: V? = null

    override fun attachView(view: IBaseView) {
        mView = view as V
    }

    override fun detchView() {
        this.mView = null
    }
}