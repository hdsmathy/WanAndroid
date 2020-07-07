package com.niko.wanandroidkotlin.ui.login

import com.niko.wanandroidkotlin.R
import com.niko.wanandroidkotlin.base.MvpBaseActivity
import com.niko.wanandroidkotlin.bean.LoginBean

/**
 *
 * @Description: 登录页面
 * @Author: Niko
 * @Date: 2020-07-04
 *
 */
class LoginActivity : MvpBaseActivity<LoginPresenter>(), ILoginView {

    override fun getPresenter(): LoginPresenter = LoginPresenter(this)

    override fun initWidget() {

    }

    override fun getLayoutId(): Int = R.layout.activity_login


    override fun loginSuccess(data: LoginBean) {
    }

    override fun loginFilure(msg: String) {
    }
}