package com.niko.wanandroidkotlin.app

import android.app.Application

/**
 * @ClassName: WanAndroidApplication
 * @Description: Application类
 * @Author: Niko
 * @Date: 2020/7/4 17:04
 */ 


class WanAndroidApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object{
        lateinit var instance : WanAndroidApplication
    }


}