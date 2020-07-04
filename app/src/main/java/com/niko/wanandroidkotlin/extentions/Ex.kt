package com.niko.wanandroidkotlin.extentions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.niko.wanandroidkotlin.app.WanAndroidApplication

/**
 * @ClassName: Ex
 * @Description: 其他的扩展函数
 * @Author: Niko
 * @Date: 2020/7/4 17:02
 */


/**
 * 判断是否有网络连接
 */
fun <T> T.isNetworkIsConnect(): Boolean {
    val connectManager: ConnectivityManager =
        WanAndroidApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo:NetworkInfo = connectManager.activeNetworkInfo
    return networkInfo?.isAvailable ?: false
}