package com.niko.wanandroidkotlin.extentions

import android.util.Log

/**
 * @ClassName: StringEx
 * @Description: String扩展函数
 * @Author: Niko
 * @Date: 2020/7/4 16:54
 */


fun <T> T.logI(tag: String = "WanAndroidKotlin") {
    if (showLog())
        Log.i(tag, "$this")
}

/**
 * 是否显示log  true 显示，false 不显示
 */
private fun showLog(): Boolean = true

