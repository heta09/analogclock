package com.techno.analogclocklivewallpaperdemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import java.util.*


class AnalogClock(context: Context?) : View(context) {
    /** center X.  */
    private var radius = 0
    private val cal: Calendar = Calendar.getInstance()
    private var paint: Paint? = null
    private val clockDial = BitmapFactory.decodeResource(
        resources,R.drawable.widgetdial
    )
    private val sizeScaled = -1
    private var clockDialScaled: Bitmap? = null

    /** Hands colors.  */
    private lateinit var colors: IntArray
    private var displayHandSec = false
    fun config(
        x: Float,
        y: Float,
        size: Int,
        date: Date?,
        paint: Paint?,
        colors: IntArray,
        displayHandSec: Boolean
    ) {
        this.x = x
        this.y = y
        this.paint = paint
        this.colors = colors
        this.displayHandSec = displayHandSec
        cal.time = date

        // scale bitmap if needed
        if (size != sizeScaled) {
            clockDialScaled = Bitmap.createScaledBitmap(clockDial, size, size, false)
            radius = size / 2
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (paint != null) {
            // draw clock img
            canvas.drawBitmap(clockDialScaled!!, x - radius, y - radius, null)
            val sec = cal[Calendar.SECOND].toFloat()
            val min = cal[Calendar.MINUTE].toFloat()
            val hour = cal[Calendar.HOUR_OF_DAY].toFloat()
            //draw hands
            paint!!.color = colors[0]
            canvas.drawLine(
                x, y,
                (x + radius * 0.5f * Math.cos(Math.toRadians((hour / 12.0f * 360.0f - 90f).toDouble()))).toFloat(),
                (y + radius * 0.5f * Math.sin(Math.toRadians((hour / 12.0f * 360.0f - 90f).toDouble()))).toFloat(),
                paint!!
            )
            canvas.save()
            paint!!.color = colors[1]
            canvas.drawLine(
                x, y,
                (x + radius * 0.6f * Math.cos(Math.toRadians((min / 60.0f * 360.0f - 90f).toDouble()))).toFloat(),
                (y + radius * 0.6f * Math.sin(Math.toRadians((min / 60.0f * 360.0f - 90f).toDouble()))).toFloat(),
                paint!!
            )
            canvas.save()
            if (displayHandSec) {
                paint!!.color = colors[2]
                canvas.drawLine(
                    x, y,
                    (x + radius * 0.7f * Math.cos(Math.toRadians((sec / 60.0f * 360.0f - 90f).toDouble()))).toFloat(),
                    (y + radius * 0.7f * Math.sin(Math.toRadians((sec / 60.0f * 360.0f - 90f).toDouble()))).toFloat(),
                    paint!!
                )
            }
        }
    }

}