package com.niko.wanandroidkotlin.ui.login

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
class LoginPresenter(var loginView: ILoginView?) : ILoginPresenter {

    override fun detchView() {
        loginView = null
    }


    override fun login(username: String, password: String) {

    }


}