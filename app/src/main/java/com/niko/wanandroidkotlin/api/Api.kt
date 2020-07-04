package com.niko.wanandroidkotlin.api

import com.niko.wanandroidkotlin.bean.LoginBean
import com.niko.wanandroidkotlin.bean.ResponseBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @ClassName: Api
 * @Description: 网络接口
 * @Author: Niko
 * @Date: 2020/7/4 17:00
 */
interface Api {


    @FormUrlEncoded
    @POST("/user/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    )
            : Observable<ResponseBean<LoginBean>>

    @FormUrlEncoded
    @POST("/user/register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<ResponseBean<LoginBean>>

}