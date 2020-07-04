package com.niko.wanandroidkotlin.ui.login

import com.niko.wanandroidkotlin.base.IBaseModel
import com.niko.wanandroidkotlin.base.IBasePresenter
import com.niko.wanandroidkotlin.base.IBaseView
import com.niko.wanandroidkotlin.bean.LoginBean

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */

interface ILoginView : IBaseView {

    fun loginSuccess(data: LoginBean)

    fun loginFilure(msg: String)
}

interface ILoginPresenter {

    fun login(username: String, password: String)
}


interface ILoginModel : IBaseModel {

    fun login(username: String, password: String, callback: LoginCallBack)
}

interface LoginCallBack {
    fun loginSuccess(data: LoginBean)

    fun loginFilure(msg: String)
}