package com.niko.wanandroidkotlin.base

interface IBasePresenter<T> {


    fun attachView(view: T)

    fun detchView()
}