package com.niko.wanandroidkotlin.base

interface IBasePresenter<in T : IBaseView> {

    fun attachView(mView: T)

    fun detchView()
}