package com.niko.wanandroidkotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class SimpleColorChangeTextView1 : AppCompatTextView {
    private val mText = "享学课堂" //成员变量
    private var mPercent = 0.0f

    //重绘
    var percent: Float
        get() = mPercent
        set(mPercent) {
            this.mPercent = mPercent
            invalidate() //重绘
        }

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //绘制文字
        val paint = Paint()
        paint.textSize = 80f
        val baseline = 100f
        canvas.drawText(mText, 0f, baseline, paint)
        drawCenterLineX(canvas)
        val x = width / 2.toFloat()

        //默认LEFT
        canvas.drawText(mText, x, baseline, paint)
        //1. 设置文字对齐
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(mText, x, baseline + paint.fontSpacing, paint)
        //RIGHT
        paint.textAlign = Paint.Align.RIGHT
        canvas.drawText(mText, x, baseline + paint.fontSpacing * 2, paint)
        drawCenterLineY(canvas)
        //把文字绘制到view的中心
        //文字高度的计算

//        public float ascent;
//        public float bottom;
//        public float descent;
//        public float leading;
//        public float top; 从baseline到文字最顶端的尺寸


        //第二种方式 x种居中
        //底层 黑色
        drawCenterText(canvas)
        //上面一层 红色
        drawCenterText1(canvas)
    }

    private fun drawCenterText(canvas: Canvas) {
        //反面教程
        canvas.save()
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.textSize = 80f
        val textWidth = paint.measureText(mText)
        paint.textAlign = Paint.Align.LEFT
        val left = width / 2 - textWidth / 2
        val left_x = left + textWidth * mPercent
        val fontMetrics = paint.fontMetrics
        val baseline =
            height / 2 - (fontMetrics.descent + fontMetrics.ascent) / 2
        val rect =
            Rect(left_x.toInt(), 0, width, height)
        canvas.clipRect(rect)
        canvas.drawText(mText, left, baseline, paint)
        canvas.restore()
    }

    private fun drawCenterText1(canvas: Canvas) {
        canvas.save()
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        paint.isAntiAlias = true
        paint.textSize = 80f
        val textWidth = paint.measureText(mText)
        paint.textAlign = Paint.Align.LEFT
        val left = width / 2 - textWidth / 2
        val right = left + textWidth * mPercent
        val fontMetrics = paint.fontMetrics
        val baseline =
            height / 2 - (fontMetrics.descent + fontMetrics.ascent) / 2
        val rect =
            Rect(left.toInt(), 0, right.toInt(), height)
        canvas.clipRect(rect)

        canvas.drawText(mText, left, baseline, paint)
        canvas.restore()
    }

    private fun drawCenterLineX(canvas: Canvas) {
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        paint.strokeWidth = 3f
        canvas.drawLine(
            width / 2.toFloat(),
            0f,
            width / 2.toFloat(),
            height.toFloat(),
            paint
        )
    }

    private fun drawCenterLineY(canvas: Canvas) {
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        paint.strokeWidth = 3f
        canvas.drawLine(
            0f,
            height / 2.toFloat(),
            width.toFloat(),
            height / 2.toFloat(),
            paint
        )
    }
}