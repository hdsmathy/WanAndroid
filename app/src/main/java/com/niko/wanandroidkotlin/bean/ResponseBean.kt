package com.niko.wanandroidkotlin.bean


/**
 * @ClassName: ResponseBean
 * @Description: Bean基类
 * @Author: Niko
 * @Date: 2020/7/4 22：34
 */
data class ResponseBean<T>(
    var errorCode: Int,
    var errorMsg: String,
    val data: T
)