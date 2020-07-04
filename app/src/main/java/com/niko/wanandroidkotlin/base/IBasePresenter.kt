package com.niko.wanandroidkotlin.base

interface IBasePresenter<in T : IBaseView> {


    fun attachView(view: T)

    fun detchView()
}