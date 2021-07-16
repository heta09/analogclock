package com.techno.analogclocklivewallpaperdemo.clock

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.view.ViewCompat
import com.techno.analogclocklivewallpaperdemo.BuildConfig
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class AnalogClock2 : View {
    private var Digitalcolock = false
    private var Showdate = false
    private var Showday = false
    private var Showmonth = false
    private var bgcolor = 0
    private var cal: Calendar? = null
    private var clockcolor = 0
    private var displayHandSec = false
    private var font: String? = null
    private var hourcolor = 0
    private var mincolor = 0
    private var numtype = 0
    private var paint: Paint? = null
    private var radius = 0
    private var seccolor = 0
    private var shadow: Boolean? = null
    private var textcolor = 0

    /* renamed from: tf */
    private var f81tf: Typeface? = null
    private var twh: Boolean? = null
    private var widgets: Boolean? = null

    /* renamed from: x */
    private var f82x = 0f

    /* renamed from: y */
    private var f83y = 0f

    constructor(context: Context?) : super(context) {
        intial()
    }

    constructor(context: Context?, attributeSet: AttributeSet?) : super(context, attributeSet) {
        intial()
    }

    constructor(context: Context?, attributeSet: AttributeSet?, i: Int) : super(
        context,
        attributeSet,
        i
    ) {
        intial()
    }

    /* access modifiers changed from: package-private */
    fun intial() {
        cal = Calendar.getInstance()
    }

    fun config(
        f: Float,
        f2: Float,
        i: Int,
        date: Date,
        z: Boolean,
        z2: Boolean,
        z3: Boolean,
        z4: Boolean,
        i2: Int,
        i3: Int,
        i4: Int,
        i5: Int,
        str: String?,
        i6: Int,
        bool: Boolean,
        bool2: Boolean?,
        bool3: Boolean?,
        i7: Int,
        i8: Int,
        z5: Boolean
    ) {
        twh = bool2
        f82x = f
        shadow = bool3
        Digitalcolock = bool
        f83y = f2
        numtype = i8
        radius = i / 2
        displayHandSec = z
        Showdate = z2
        Showday = z3
        Showmonth = z4
        seccolor = i2
        textcolor = i3
        clockcolor = i4
        bgcolor = i6
        mincolor = i5
        hourcolor = i7
        font = str
        widgets = java.lang.Boolean.valueOf(z5)
        val date2 = date
        cal!!.time = date
        val paint2 = Paint()
        paint = paint2
        paint2.isAntiAlias = true
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = 5.0f
        val ttfFont: Typeface = ttfFont()!!
        f81tf = ttfFont
        try {
            paint!!.typeface = ttfFont
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /* access modifiers changed from: protected */
    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (paint != null) {
            clockShape(canvas)
            if (shadow!!) {
                paint!!.setShadowLayer(
                    3.0f, 1.0f, 2.0f, getComplimentColor(
                        clockcolor
                    )
                )
            } else {
                paint!!.setShadowLayer(0.0f, 0.0f, 0.0f, -12303292)
            }
            clock(canvas)
            paint!!.textSize = (radius / 8).toFloat()
            if (Digitalcolock) {
                digitalClock(canvas)
            }
            if (Showmonth) {
                showMonth(canvas, cal)
            }
            if (Showdate) {
                showDate(canvas, cal)
            }
            if (Showday) {
                showDay(canvas, cal)
            }
            minhour(canvas)
            if (displayHandSec) {
                setDisplayHandSec(canvas)
            }
        }
    }

    /* access modifiers changed from: package-private */
    fun ttfFont(): Typeface? {
        if (font == "1") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "a.ttf")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else if (font == "2") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "b.ttf")
            } catch (e2: Exception) {
                e2.printStackTrace()
            }
        } else if (font == "3") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "c.ttf")
            } catch (e3: Exception) {
                e3.printStackTrace()
            }
        } else if (font == "4") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "d.ttf")
            } catch (e4: Exception) {
                e4.printStackTrace()
            }
        } else if (font == "5") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "e.ttf")
            } catch (e5: Exception) {
                e5.printStackTrace()
            }
        } else if (font == "6") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "f.ttf")
            } catch (e6: Exception) {
                e6.printStackTrace()
            }
        } else if (font == "7") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "g.ttf")
            } catch (e7: Exception) {
                e7.printStackTrace()
            }
        } else if (font == "8") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "h.ttf")
            } catch (e8: Exception) {
                e8.printStackTrace()
            }
        } else if (font == "9") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "i.ttf")
            } catch (e9: Exception) {
                e9.printStackTrace()
            }
        } else if (font == "10") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "j.ttf")
            } catch (e10: Exception) {
                e10.printStackTrace()
            }
        } else if (font == "11") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "k.ttf")
            } catch (e11: Exception) {
                e11.printStackTrace()
            }
        } else if (font == "12") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "l.ttf")
            } catch (e12: Exception) {
                e12.printStackTrace()
            }
        } else if (font == "13") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "m.ttf")
            } catch (e13: Exception) {
                e13.printStackTrace()
            }
        } else if (font == "14") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "n.ttf")
            } catch (e14: Exception) {
                e14.printStackTrace()
            }
        } else if (font == "15") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "o.ttf")
            } catch (e15: Exception) {
                e15.printStackTrace()
            }
        } else if (font == "16") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "p.ttf")
            } catch (e16: Exception) {
                e16.printStackTrace()
            }
        } else if (font == "17") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "q.ttf")
            } catch (e17: Exception) {
                e17.printStackTrace()
            }
        } else if (font == "18") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "r.ttf")
            } catch (e18: Exception) {
                e18.printStackTrace()
            }
        } else if (font == "19") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "s.ttf")
            } catch (e19: Exception) {
                e19.printStackTrace()
            }
        } else if (font == "20") {
            try {
                f81tf = Typeface.createFromAsset(context.assets, "t.ttf")
            } catch (e20: Exception) {
                e20.printStackTrace()
            }
        }
        return f81tf
    }

    /* access modifiers changed from: package-private */
    fun digitalClock(canvas: Canvas) {
        val str: String
        val time = cal!!.time
        str = if (twh!!) {
            SimpleDateFormat("kk:mm").format(time)
        } else {
            SimpleDateFormat("hh:mm a").format(time)
        }
        val fontMetrics = Paint.FontMetrics()
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.getFontMetrics(fontMetrics)
        paint!!.color = textcolor
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = (radius / 100).toFloat()
        val d = f82x.toDouble()
        val d2 = (radius.toFloat() * 0.5f).toDouble()
        val cos = Math.cos(Math.toRadians(90.0))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val d3 = f83y.toDouble()
        val d4 = (radius.toFloat() * 0.5f).toDouble()
        val sin = Math.sin(Math.toRadians(90.0))
        java.lang.Double.isNaN(d4)
        java.lang.Double.isNaN(d3)
        val d5 = d3 + d4 * sin
        val d6 = (-(fontMetrics.ascent + fontMetrics.descent) / 2.0f).toDouble()
        java.lang.Double.isNaN(d6)
        paint!!.style = Paint.Style.FILL
        paint!!.alpha = 180
        canvas.drawText(
            str, (d + d2 * cos).toInt().toFloat(), (d5 + d6).toInt()
                .toFloat(), paint!!
        )
    }

    /* access modifiers changed from: package-private */
    fun showMonth(canvas: Canvas, calendar: Calendar?) {
        val str = arrayOf(
            "JAN",
            "FEB",
            "MAR",
            "APR",
            "MAY",
            "JUN",
            "JUL",
            "AUG",
            "SEP",
            "OCT",
            "NOV",
            "DEC"
        )[calendar!![2]]
        val fontMetrics = Paint.FontMetrics()
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.getFontMetrics(fontMetrics)
        paint!!.color = textcolor
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = (radius / 100).toFloat()
        val paint2 = paint
        val measureText = paint2!!.measureText(" $str") / 2.0f
        val textSize = paint!!.textSize
        val d = f82x.toDouble()
        val d2 = (radius.toFloat() * 0.5f).toDouble()
        val cos = Math.cos(Math.toRadians(180.0))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val d3 = f83y.toDouble()
        val d4 = (radius.toFloat() * 0.5f).toDouble()
        val sin = Math.sin(Math.toRadians(180.0))
        java.lang.Double.isNaN(d4)
        java.lang.Double.isNaN(d3)
        val d5 = d3 + d4 * sin
        val d6 = (-(fontMetrics.ascent + fontMetrics.descent) / 2.0f).toDouble()
        java.lang.Double.isNaN(d6)
        paint!!.alpha = 180
        val f = (d + d2 * cos).toInt().toFloat()
        val f2 = (d5 + d6).toInt().toFloat()
        canvas.drawRect(f - measureText, f2 - textSize, f + measureText, f2, paint!!)
        paint!!.style = Paint.Style.FILL
        canvas.drawText(str, f, f2, paint!!)
    }

    /* access modifiers changed from: package-private */
    fun showDate(canvas: Canvas, calendar: Calendar?) {
        val i = calendar!![5]
        val fontMetrics = Paint.FontMetrics()
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.getFontMetrics(fontMetrics)
        paint!!.color = textcolor
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = (radius / 100).toFloat()
        val paint2 = paint
        val measureText = paint2!!.measureText(" $i") / 2.0f
        val textSize = paint!!.textSize
        val d = f82x.toDouble()
        val d2 = (radius.toFloat() * 0.5f).toDouble()
        val cos = Math.cos(Math.toRadians(0.0))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val d3 = f83y.toDouble()
        val d4 = (radius.toFloat() * 0.5f).toDouble()
        val sin = Math.sin(Math.toRadians(0.0))
        java.lang.Double.isNaN(d4)
        java.lang.Double.isNaN(d3)
        val d5 = d3 + d4 * sin
        val d6 = (-(fontMetrics.ascent + fontMetrics.descent) / 2.0f).toDouble()
        java.lang.Double.isNaN(d6)
        paint!!.alpha = 180
        val f = (d + d2 * cos).toInt().toFloat()
        val f2 = (d5 + d6).toInt().toFloat()
        canvas.drawRect(f - measureText, f2 - textSize, f + measureText, f2, paint!!)
        paint!!.style = Paint.Style.FILL
        canvas.drawText(" $i", f, f2, paint!!)
    }

    /* access modifiers changed from: package-private */
    fun showDay(canvas: Canvas, calendar: Calendar?) {
        val str = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")[calendar!![7] - 1]
        val fontMetrics = Paint.FontMetrics()
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.getFontMetrics(fontMetrics)
        paint!!.color = textcolor
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = (radius / 100).toFloat()
        val paint2 = paint
        val measureText = paint2!!.measureText(" $str") / 2.0f
        val textSize = paint!!.textSize
        val d = f82x.toDouble()
        val d2 = (radius.toFloat() * 0.25f).toDouble()
        val cos = Math.cos(Math.toRadians(0.0))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val d3 = f83y.toDouble()
        val d4 = (radius.toFloat() * 0.25f).toDouble()
        val sin = Math.sin(Math.toRadians(0.0))
        java.lang.Double.isNaN(d4)
        java.lang.Double.isNaN(d3)
        val d5 = d3 + d4 * sin
        val d6 = (-(fontMetrics.ascent + fontMetrics.descent) / 2.0f).toDouble()
        java.lang.Double.isNaN(d6)
        paint!!.alpha = 180
        val f = (d + d2 * cos).toInt().toFloat()
        val f2 = (d5 + d6).toInt().toFloat()
        canvas.drawRect(f - measureText, f2 - textSize, f + measureText, f2, paint!!)
        paint!!.style = Paint.Style.FILL
        canvas.drawText(BuildConfig.FLAVOR.toString() + str, f, f2, paint!!)
    }

    /* access modifiers changed from: package-private */
    fun clock(canvas: Canvas) {
        var str: String
        val fontMetrics = Paint.FontMetrics()
        paint!!.textAlign = Paint.Align.CENTER
        paint!!.getFontMetrics(fontMetrics)
        paint!!.color = textcolor
        paint!!.style = Paint.Style.FILL
        paint!!.color = textcolor
        paint!!.isAntiAlias = true
        paint!!.strokeWidth = (radius / 50).toFloat()
        paint!!.isDither = true
        paint!!.style = Paint.Style.FILL
        paint!!.strokeJoin = Paint.Join.ROUND
        paint!!.strokeCap = Paint.Cap.ROUND
        paint!!.pathEffect = CornerPathEffect((radius / 100).toFloat())
        for (i in 0..60) {
            val d = i.toDouble()
            java.lang.Double.isNaN(d)
            val d2 = d * 3.141592653589793 / 30.0 - 1.5707963267948966
            val cos = Math.cos(d2)
            val d3 = radius.toDouble()
            java.lang.Double.isNaN(d3)
            val d4 = cos * d3
            val d5 = f82x.toDouble()
            java.lang.Double.isNaN(d5)
            val i2 = (d4 + d5).toInt()
            val sin = Math.sin(d2)
            val i3 = radius
            val d6 = i3.toDouble()
            java.lang.Double.isNaN(d6)
            val d7 = sin * d6
            val d8 = f83y.toDouble()
            java.lang.Double.isNaN(d8)
            val i4 = (d7 + d8).toInt()
            if (i % 5 == 0) {
                paint!!.textSize = (i3 / 4) as Float
                if (i != 0) {
                    val fontMetrics2 = Paint.FontMetrics()
                    paint!!.textAlign = Paint.Align.CENTER
                    paint!!.getFontMetrics(fontMetrics2)
                    if (numtype == 1) {
                        str = (i / 5.plus(0)).toString()
                    } else {
                        str = romanNum(i)
                    }
                    val d9 = f82x.toDouble()
                    val d10 = (radius.toFloat() * 0.8f).toDouble()
                    val d11 = (i.toFloat() / 60.0f * 360.0f - 90.0f).toDouble()
                    val cos2 = Math.cos(Math.toRadians(d11))
                    java.lang.Double.isNaN(d10)
                    java.lang.Double.isNaN(d9)
                    val d12 = f83y.toDouble()
                    val d13 = (radius.toFloat() * 0.8f).toDouble()
                    val sin2 = Math.sin(Math.toRadians(d11))
                    java.lang.Double.isNaN(d13)
                    java.lang.Double.isNaN(d12)
                    canvas.drawText(
                        str,
                        (d9 + d10 * cos2).toFloat(),
                        (d12 + d13 * sin2).toFloat() + -(fontMetrics2.ascent + fontMetrics2.descent) / 2.0f,
                        paint!!
                    )
                }
                paint!!.isAntiAlias = true
                canvas.drawCircle(
                    i2.toFloat(),
                    i4.toFloat(),
                    (radius / 40).toFloat(),
                    paint!!
                )
            } else {
                paint!!.strokeWidth = (i3 / 50) as Float
                canvas.drawCircle(
                    i2.toFloat(),
                    i4.toFloat(),
                    (radius / 70).toFloat(),
                    paint!!
                )
                paint!!.strokeWidth = (radius / 25).toFloat()
            }
        }
    }

    /* access modifiers changed from: package-private */
    fun minhour(canvas: Canvas) {
        val f = cal!![12].toFloat() / 60.0f
        paint!!.color = hourcolor
        paint!!.strokeWidth = (radius / 15).toFloat()
        val f2 = f82x
        val f3 = f83y
        val d = f2.toDouble()
        val d2 = (radius.toFloat() * 0.6f).toDouble()
        val d3 = ((cal!![11]
            .toFloat() + f) / 12.0f * 360.0f - 90.0f).toDouble()
        val cos = Math.cos(Math.toRadians(d3))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val f4 = (d + d2 * cos).toFloat()
        val d4 = f83y.toDouble()
        val d5 = (radius.toFloat() * 0.6f).toDouble()
        val sin = Math.sin(Math.toRadians(d3))
        java.lang.Double.isNaN(d5)
        java.lang.Double.isNaN(d4)
        canvas.drawLine(f2, f3, f4, (d4 + d5 * sin).toFloat(), paint!!)
        paint!!.strokeWidth = (radius / 30).toFloat()
        paint!!.color = seccolor
        val f5 = f82x
        val f6 = f83y
        val d6 = f5.toDouble()
        val d7 = (radius.toFloat() * 0.3f).toDouble()
        val cos2 = Math.cos(Math.toRadians(d3))
        java.lang.Double.isNaN(d7)
        java.lang.Double.isNaN(d6)
        val d8 = f83y.toDouble()
        val d9 = (radius.toFloat() * 0.3f).toDouble()
        val sin2 = Math.sin(Math.toRadians(d3))
        java.lang.Double.isNaN(d9)
        java.lang.Double.isNaN(d8)
        canvas.drawLine(f5, f6, (d6 + d7 * cos2).toFloat(), (d8 + d9 * sin2).toFloat(), paint!!)
        canvas.save()
        paint!!.strokeWidth = (radius / 25).toFloat()
        paint!!.color = mincolor
        val f7 = f82x
        val f8 = f83y
        val d10 = f7.toDouble()
        val d11 = (radius.toFloat() * 0.75f).toDouble()
        val d12 = (f * 360.0f - 90.0f).toDouble()
        val cos3 = Math.cos(Math.toRadians(d12))
        java.lang.Double.isNaN(d11)
        java.lang.Double.isNaN(d10)
        val f9 = (d10 + d11 * cos3).toFloat()
        val d13 = f83y.toDouble()
        val d14 = (radius.toFloat() * 0.75f).toDouble()
        val sin3 = Math.sin(Math.toRadians(d12))
        java.lang.Double.isNaN(d14)
        java.lang.Double.isNaN(d13)
        canvas.drawLine(f7, f8, f9, (d13 + d14 * sin3).toFloat(), paint!!)
        paint!!.strokeWidth = (radius / 45).toFloat()
        paint!!.color = seccolor
        val f10 = f82x
        val f11 = f83y
        val d15 = f10.toDouble()
        val d16 = (radius.toFloat() * 0.4f).toDouble()
        val cos4 = Math.cos(Math.toRadians(d12))
        java.lang.Double.isNaN(d16)
        java.lang.Double.isNaN(d15)
        val d17 = f83y.toDouble()
        val d18 = (radius.toFloat() * 0.4f).toDouble()
        val sin4 = Math.sin(Math.toRadians(d12))
        java.lang.Double.isNaN(d18)
        java.lang.Double.isNaN(d17)
        canvas.drawLine(
            f10,
            f11,
            (d15 + d16 * cos4).toFloat(),
            (d17 + d18 * sin4).toFloat(),
            paint!!
        )
        canvas.save()
        paint!!.color = mincolor
        canvas.drawCircle(f82x, f83y, (radius / 25).toFloat(), paint!!)
    }

    /* access modifiers changed from: package-private */
    fun setDisplayHandSec(canvas: Canvas) {
        paint!!.color = seccolor
        paint!!.isAntiAlias = true
        paint!!.strokeWidth = (radius / 50).toFloat()
        paint!!.isDither = true
        paint!!.style = Paint.Style.FILL
        paint!!.strokeJoin = Paint.Join.ROUND
        paint!!.strokeCap = Paint.Cap.ROUND
        paint!!.pathEffect = CornerPathEffect((radius / 100).toFloat())
        val f = f82x
        val f2 = f83y
        val d = f.toDouble()
        val d2 = (radius.toFloat() * 0.85f).toDouble()
        val d3 = (cal!![13].toFloat() / 60.0f * 360.0f - 90.0f).toDouble()
        val cos = Math.cos(Math.toRadians(d3))
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        val d4 = f83y.toDouble()
        val d5 = (radius.toFloat() * 0.85f).toDouble()
        val sin = Math.sin(Math.toRadians(d3))
        java.lang.Double.isNaN(d5)
        java.lang.Double.isNaN(d4)
        canvas.drawLine(f, f2, (d + d2 * cos).toFloat(), (d4 + d5 * sin).toFloat(), paint!!)
        paint!!.strokeWidth = (radius / 25).toFloat()
        val d6 = f82x.toDouble()
        val d7 = (radius.toFloat() * 0.3f).toDouble()
        val cos2 = Math.cos(Math.toRadians(d3))
        java.lang.Double.isNaN(d7)
        java.lang.Double.isNaN(d6)
        val f3 = (d6 - d7 * cos2).toFloat()
        val d8 = f83y.toDouble()
        val d9 = (radius.toFloat() * 0.3f).toDouble()
        val sin2 = Math.sin(Math.toRadians(d3))
        java.lang.Double.isNaN(d9)
        java.lang.Double.isNaN(d8)
        canvas.drawLine(f3, (d8 - d9 * sin2).toFloat(), f82x, f83y, paint!!)
        canvas.drawCircle(f82x, f83y, (radius / 20).toFloat(), paint!!)
    }

    /* access modifiers changed from: package-private */
    fun clockShape(canvas: Canvas) {
        val paint2 = Paint()
        paint2.color = clockcolor
        paint2.style = Paint.Style.FILL_AND_STROKE
        val f = f82x
        val f2 = f83y
        val i = radius
        val d = i.toDouble()
        val d2 = i.toDouble()
        java.lang.Double.isNaN(d2)
        java.lang.Double.isNaN(d)
        canvas.drawCircle(f, f2, (d + d2 * 0.1).toInt().toFloat(), paint2)
        val paint3 = Paint()
        paint3.shader = LinearGradient(
            f82x,
            f83y,
            0.0f,
            radius.toFloat(),
            ViewCompat.MEASURED_STATE_MASK,
            -12303292,
            Shader.TileMode.MIRROR
        )
        paint3.isAntiAlias = true
        val d3 = radius.toDouble()
        java.lang.Double.isNaN(d3)
        paint3.strokeWidth = (d3 * 0.1).toInt().toFloat()
        paint3.style = Paint.Style.STROKE
        val f3 = f82x
        val f4 = f83y
        val i2 = radius
        val d4 = i2.toDouble()
        val d5 = i2.toDouble()
        java.lang.Double.isNaN(d5)
        java.lang.Double.isNaN(d4)
        canvas.drawCircle(f3, f4, (d4 + d5 * 0.1).toInt().toFloat(), paint3)
    }

    /* access modifiers changed from: package-private */
    fun romanNum(i: Int): String {
        val i2 = i / 5
        if (i2 == 1) {
            return "I"
        }
        if (i2 == 2) {
            return "II"
        }
        if (i2 == 3) {
            return "III"
        }
        if (i2 == 4) {
            return "IV"
        }
        if (i2 == 5) {
            return "V"
        }
        if (i2 == 6) {
            return "VI"
        }
        if (i2 == 7) {
            return "VII"
        }
        if (i2 == 8) {
            return "VIII"
        }
        if (i2 == 9) {
            return "IX"
        }
        if (i2 == 10) {
            return "X"
        }
        if (i2 == 11) {
            return "XI"
        }
        return if (i2 == 12) "XII" else BuildConfig.FLAVOR
    }

    companion object {
        fun getComplimentColor(i: Int): Int {
            val alpha = Color.alpha(i)
            val red = Color.red(i)
            val blue = Color.blue(i)
            return Color.argb(
                alpha,
                red xor -1 and 255,
                Color.green(i) xor -1 and 255,
                blue xor -1 and 255
            )
        }
    }
}