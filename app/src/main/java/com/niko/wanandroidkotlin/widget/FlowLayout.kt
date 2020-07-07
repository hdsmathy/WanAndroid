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

class FlowLayout : ViewGroup {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    )

    private val mHorizontalSpacing = 16.dp2px()
    private val mVerticalSpacing = 8.dp2px()
    private val mLineHeightList = ArrayList<Int>()
    private val mAllLinesViews = ArrayList<ArrayList<View>>()

    private fun initParam() {
        mAllLinesViews.clear()
        mLineHeightList.clear()
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        //防止内存抖动
        initParam()

        //先度量孩子
        //每一行的所有View
        var lineViews = ArrayList<View>()

        //从FlowLayout 父布局处获取 宽高
        val selfWidth = MeasureSpec.getSize(widthMeasureSpec)//ViewGroup解析的父亲给我的宽度
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)//ViewGroup解析的父亲给我的高度

        var lineWidth = 0 //记录这行已经使用了多宽的size
        var lineHeight = 0 //一行的行高
        var parentWidth = 0 //父布局宽
        var parentHeight = 0 //父布局高


        for (i in 0 until childCount) {
            val childView = getChildAt(i)

            //如果子View不可见，则不测量
            if (childView.visibility != View.GONE) {
                //将layoutParams转变成为 measureSpec
                val childLp = childView.layoutParams
                //获取孩子的MeasureSpec
                val childWidthMeasureSpec =
                    getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLp.width)
                val childHeightMeasureSpec =
                    getChildMeasureSpec(
                        heightMeasureSpec,
                        paddingTop + paddingBottom,
                        childLp.height
                    )
                //测量孩子
                childView.measure(childWidthMeasureSpec, childHeightMeasureSpec)

                val childW = childView.measuredWidth
                val childH = childView.measuredHeight

                //每一行不能超过父布局的最大宽度,否则换行
                if (lineWidth + mHorizontalSpacing + childW > selfWidth) {
                    //记录行高
                    mLineHeightList.add(lineHeight)
                    //存储每一行的所有View
                    mAllLinesViews.add(lineViews)

                    parentHeight += lineHeight + mVerticalSpacing
                    parentWidth = max(parentWidth, lineWidth + mHorizontalSpacing)

                    //一行结束重新初始化lineViews
                    lineViews = ArrayList<View>()
                    //每一行重置相关数据
                    lineWidth = 0
                    lineHeight = 0
                }

                //存储每一行的View
                lineViews.add(childView)
                //行宽
                lineWidth += childW + mHorizontalSpacing
                //行高
                lineHeight = max(lineHeight, childH)

                //度量最后一行
                if (i == childCount - 1) {
                    mLineHeightList.add(lineHeight)
                    mAllLinesViews.add(lineViews)

                    parentHeight += lineHeight + mVerticalSpacing
                    parentWidth = max(parentWidth, lineWidth + mHorizontalSpacing)
                }

            }
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
        var currentL = paddingLeft
        var currentT = paddingTop

        val lineSize = mAllLinesViews.size
        for (i in 0 until lineSize) {
            //每一行的size
//            val size = mAllLinesViews[i].size
            val lineHeight = mLineHeightList[i]
            mAllLinesViews[i].forEach { view ->
                val left = currentL
                val top = currentT

//                view.width  //这个两个是在onLayout 之后才有值的，
//                view.height //onLayout与onLayout之前都是用measureWidth和measureHeight
                val right = left + view.measuredWidth
                val bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)
                //当前宽度
                currentL = right + mHorizontalSpacing
            }
            //当前高度
            currentT += lineHeight + mVerticalSpacing
            //换行之后重置此行第一个View的left
            currentL = paddingLeft
        }
    }


}