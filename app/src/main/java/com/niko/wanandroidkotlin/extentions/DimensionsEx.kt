package com.niko.wanandroidkotlin.extentions

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020-07-06
 *
 */


fun Int.dp2px(): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()
}