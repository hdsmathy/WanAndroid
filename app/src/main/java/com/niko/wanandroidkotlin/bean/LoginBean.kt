package com.niko.wanandroidkotlin.bean

/**
 * @ClassName: LoginBean
 * @Description: 登录bean类
 * @Author: Niko
 * @Date: 2020/7/4 22：35
 */
data class LoginBean(
    var userId: Int,
    var admin: Boolean = false,
    var email: String? = null,
    var icon: String? = null,
    var id: String,
    var nickname: String,
    var password: String,
    var publicName: String? = null,
    var token: String? = null,
    var type: String,
    var username: String
)