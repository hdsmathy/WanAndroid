package com.niko.wanandroidkotlin.base

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
open class BasePresenter<in V : BaseView> : IBasePresenter<BaseView> {

    private var mView: V? = null

    override fun attachView(view: BaseView) {
        mView = view as V
    }

    override fun detchView() {
        this.mView = null
    }
}