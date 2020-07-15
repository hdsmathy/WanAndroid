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
 * @Date: 2020/7/15
 *
 */

class DynamicChangeTextColor @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attributeSet, defStyle) {

    private val mText = "动态变化文字"
    private var percent: Float = 0f
        set(value) {
            field = value
            invalidate()
            "percent = $percent".logI()
        }

    private val mPaint by lazy {
        Paint().apply {
            textSize = 80f
            strokeWidth = 4f
            isAntiAlias = true
            color = Color.BLACK
        }
    }
    private val mPaint2 by lazy {
        Paint().apply {
            textSize = 80f
            isAntiAlias = true
            color = Color.RED
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制XY
        drawTextLineXY(canvas)
        //绘制底层文字
        drawTextBlack(canvas)

        //绘制红色文字
        drawTextRed(canvas)
    }

    private fun drawTextBlack(canvas: Canvas) {
        canvas.save()
        //计算文字宽度
        val textWidth = mPaint.measureText(mText)
        val left = width / 2 - textWidth / 2
        val left_x = left + textWidth * percent
        val right = left + textWidth
        //计算文字高度
        val fontMetrics = mPaint.fontMetrics

//        val baseLine = height / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent
        //上面等价于这句
        val baseLine = height / 2 - (fontMetrics.descent + fontMetrics.ascent) / 2

        //裁剪
        val rect =
            Rect(left_x.toInt(), 0, right.toInt(), height)
        canvas.clipRect(rect)

        //绘制文本
        canvas.drawText(mText, left, baseLine, mPaint)
        canvas.restore()
    }

    private fun drawTextRed(canvas: Canvas) {
        canvas.save()

        //计算文字宽度
        val textWidth = mPaint2.measureText(mText)
        val left = width / 2 - textWidth / 2
        val right = left + textWidth * percent
        //计算文字高度
        val fontMetrics = mPaint2.fontMetrics

//        val baseLine = height / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent
        //上面等价于这句
        val baseLine = height / 2 - (fontMetrics.descent + fontMetrics.ascent) / 2
        "right = $right".logI()
        //裁剪
        val rect =
            Rect(left.toInt(), 0, right.toInt(), height)
        canvas.clipRect(rect)
        //绘制文本
        canvas.drawText(mText, left, baseLine, mPaint2)
        canvas.restore()
    }

    private fun drawTextLineXY(canvas: Canvas) {
        val y = height / 2.toFloat()
        //画x轴
        canvas.drawLine(0f, y, width.toFloat(), y, mPaint)
        //画y轴
        val x = width / 2.toFloat()
        canvas.drawLine(x, 0f, x, height.toFloat(), mPaint)
    }
}