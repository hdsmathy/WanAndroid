package com.niko.wanandroidkotlin.api

import com.niko.wanandroidkotlin.BuildConfig
import com.niko.wanandroidkotlin.extentions.isNetworkIsConnect
import com.niko.wanandroidkotlin.extentions.logI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @ClassName: HttpRepository
 * @Description: 网络请求
 * @Author: Niko
 * @Date: 2020/7/4 16:40
 */

class HttpRepository private constructor() {

    private val timeout = 10L

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor { message -> message.logI("WanAndroidHttp") }
            .setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS)
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: Api by lazy { retrofit.create(Api::class.java) }

    val apiClass: Api
        get() = api

    /**
     * 检查网络
     *
     * @param normalHandle 网络正常运行函数
     * @param networkErrorHandle 网络异常运行函数
     */
    fun getApiClassWithNetwork(normalHandle: (Api) -> Unit, networkErrorHandle: () -> Unit) {
        if (isNetworkIsConnect()) {
            normalHandle(apiClass)
        } else {
            networkErrorHandle()
        }
    }


    companion object {
        //KT 单例模式
        val instance = EHttpRepository.holder
    }

    private object EHttpRepository {
        val holder = HttpRepository()
    }
}
