package com.niko.wanandroidkotlin.extentions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020/7/13
 *
 */


fun <T> Activity.startActivityA(clazz: Class<T>) {
    this.startActivity(Intent(this, clazz))
}