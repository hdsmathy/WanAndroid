package com.niko.wanandroidkotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.niko.wanandroidkotlin.extentions.logI

/**
 *
 * @Description: 文件描述
 * @Author: Niko
 * @Date: 2020/7/14
 *
 */

class SimpleColorChangeText @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attributeSet, defStyle) {


    private var mPercent: Float = 0f
        set(value) {
            "percent = $value".logI("percent")
            field = value
            invalidate()
        }

    private val mText = "绘制的文字"
    private val mPaint by lazy {
        Paint().apply {
            textSize = 40f
            isAntiAlias = true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //绘制文字
        val baseLine = 100f
        canvas?.drawText(mText, 0f, baseLine, mPaint)

        drawCenterLineX(canvas)
        val x = (width / 2).toFloat()
        //设置文字对齐
        mPaint.textAlign = Paint.Align.CENTER
        canvas?.drawText(mText, x, baseLine, mPaint)

        //RIGHT
        mPaint.textAlign = Paint.Align.RIGHT
        canvas?.drawText(mText, x, baseLine + mPaint.fontSpacing, mPaint)


        drawCenterText(canvas)
        drawCenterText1(canvas)
    }


    private fun drawCenterText1(canvas: Canvas?) {
        "mPercent = $mPercent".logI("percent")
//        canvas?.save()    //为一层
//        canvas?.restore()
        //绘制在View中心
        //用于计算文字高度
        val fontMetrics = mPaint.fontMetrics
//        baseLine = height / 2.toFloat() + (-fontMetrics.ascent) /2.toFloat()
//        canvas?.drawText(mText, x, baseLine, mPaint)
        mPaint.textAlign = Paint.Align.LEFT
        mPaint.color = Color.RED
        //Y轴
        var baseLine = height / 2.toFloat() - (fontMetrics.ascent + fontMetrics.descent) / 2
        //X轴
        val textWidth = mPaint.measureText(mText)
        val left = width / 2 - textWidth / 2
        var width = left + textWidth * mPercent
        val rect = Rect(left.toInt(), 0, width.toInt(), height)
        canvas?.clipRect(rect)
        canvas?.drawText(mText, left, baseLine, mPaint)
//        canvas?.restore()
    }


    private fun drawCenterText(canvas: Canvas?) {
        canvas?.save()    //为一层
        //绘制在View中心
        //用于计算文字高度
        val fontMetrics = mPaint.fontMetrics
//        baseLine = height / 2.toFloat() + (-fontMetrics.ascent) /2.toFloat()
//        canvas?.drawText(mText, x, baseLine, mPaint)
        mPaint.textAlign = Paint.Align.LEFT
        //Y轴
        var baseLine = height / 2.toFloat() - (fontMetrics.ascent + fontMetrics.descent) / 2
        //X轴
        val textWidth = mPaint.measureText(mText)
        val left = width / 2 - textWidth / 2
        canvas?.drawText(mText, left, baseLine, mPaint)
        canvas?.restore()
    }

    private fun drawCenterLineX(canvas: Canvas?) {
        val paint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.RED
            strokeWidth = 3f
        }
        canvas?.drawLine(width / 2.toFloat(), 0f, width / 2.toFloat(), height.toFloat(), paint)

        paint.color = Color.GREEN
        canvas?.drawLine(0f, height / 2.toFloat(), width.toFloat(), height / 2.toFloat(), paint)
    }
}