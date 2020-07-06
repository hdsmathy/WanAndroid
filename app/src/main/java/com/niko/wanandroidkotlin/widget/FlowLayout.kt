package com.niko.wanandroidkotlin.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.niko.wanandroidkotlin.extentions.dp2px
import kotlin.math.max

/**
 *
 * @Description: 流式布局
 * @Author: Niko
 * @Date: 2020-07-06
 *
 */

class FlowLayout(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int = 0) :
    ViewGroup(context, attributeSet, defStyleAttr) {

    private val mHorizontalSpacing = 16.dp2px()
    private val mVerticalSpacing = 8.dp2px()
    private val mLineHeightList = ArrayList<Int>()
    private val mAllLinesViews = ArrayList<ArrayList<View>>()

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //先度量孩子
        var lineViews = ArrayList<View>()

        //从FlowLayout 父布局处获取 宽高
        val selfWidth = MeasureSpec.getSize(widthMeasureSpec)//ViewGroup解析的父亲给我的宽度
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)//ViewGroup解析的父亲给我的高度

        var lineWidth = 0 //记录这行已经使用了多宽的size
        var lineHeight = 0 //一行的行高
        var parentWidth = 0
        var parentHeight = 0

        for (i in 0..childCount) {
            val childView = getChildAt(i)
            //获取孩子的MeasureSpec
            val childWidthMeasureSpec =
                getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childView.height)
            val childHeightMeasureSpec =
                getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childView.height)
            //测量孩子
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec)

            val childW = childView.measuredWidth
            val childH = childView.measuredHeight

            //每一行不能超过父布局的最大宽度,否则换行
            if (lineWidth + mHorizontalSpacing + childW > selfWidth) {

                parentHeight += lineHeight + mVerticalSpacing
                parentWidth = max(parentWidth, lineWidth + mHorizontalSpacing)

                //记录行高
                mLineHeightList.add(parentHeight)
                //存储每一行的所有View
                mAllLinesViews.add(lineViews)

                //一行结束重新初始化lineViews
                lineViews = ArrayList<View>()
                //每一行重置相关数据
                lineWidth = 0
                lineHeight = 0
            }

            //存储每一行的View
            lineViews.add(childView)
            //行宽
            lineWidth += childW
            //行高
            lineHeight = max(lineHeight, childH)
        }


        //再度量自己
        val realWith =
            if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY) selfWidth else parentWidth
        val realHeight =
            if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) selfHeight else parentHeight

        //存储自己的宽高
        setMeasuredDimension(realWith, realHeight)


    }

    //布局
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //第一个位置坐标
        val currentL = paddingLeft
        val currentT = paddingTop

        val lineSize = mAllLinesViews.size
        for (i in 0 .. lineSize){
            //每一行的size
//            val size = mAllLinesViews[i].size
            val lineHeight = mLineHeightList[i]
            mAllLinesViews[i].forEach { view ->

            }

        }
    }


}