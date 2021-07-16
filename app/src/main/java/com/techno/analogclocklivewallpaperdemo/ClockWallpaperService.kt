package com.techno.analogclocklivewallpaperdemo

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.preference.PreferenceManager
import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import java.util.*


class ClockWallpaperService : WallpaperService() {
    override fun onCreateEngine(): Engine {
        return ClockWallpaperEngine()
    }

    private inner class ClockWallpaperEngine : Engine(),
        OnSharedPreferenceChangeListener {
        private val drawRunner = Runnable { draw() }
        private val paint: Paint
        private  var handler: Handler = Handler()

        /** hands colors for hour, min, sec  */
        private val colors = intArrayOf(-0x10000, -0xffff01, -0x5d43ed)
        private val bgColor: Int
        private var width = 0
        private var height = 0
        private var visible = true
        private var displayHandSec: Boolean
        private val clock: AnalogClock
        private val prefs: SharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(this@ClockWallpaperService)

        override fun onVisibilityChanged(visible: Boolean) {
            this.visible = visible
            if (visible) {
                handler.post(drawRunner)
            } else {
                handler.removeCallbacks(drawRunner)
            }
        }

        override fun onSurfaceDestroyed(holder: SurfaceHolder) {
            super.onSurfaceDestroyed(holder)
            visible = false
            handler.removeCallbacks(drawRunner)
            prefs.unregisterOnSharedPreferenceChangeListener(this)
        }

        override fun onSurfaceChanged(
            holder: SurfaceHolder, format: Int,
            width: Int, height: Int
        ) {
            this.width = width
            this.height = height
            super.onSurfaceChanged(holder, format, width, height)
        }

        private fun draw() {
            val holder = surfaceHolder
            var canvas: Canvas? = null
            try {
                canvas = holder.lockCanvas()
                if (canvas != null) {
                    draw(canvas)
                }
            } finally {
                if (canvas != null) holder.unlockCanvasAndPost(canvas)
            }
            handler.removeCallbacks(drawRunner)
            if (visible) {
                handler.postDelayed(drawRunner, 200)
            }
        }

        private fun draw(canvas: Canvas) {
            canvas.drawColor(bgColor)
            clock.config(width / 2f, height / 2f, (width * 0.6f).toInt(),
                Date(), paint, colors, displayHandSec
            )
            clock.draw(canvas)
        }

        override fun onSharedPreferenceChanged(
            sharedPreferences: SharedPreferences, key: String
        ) {
            if (SettingsActivity.DISPLAY_HAND_SEC_KEY.equals(key)) {
                displayHandSec = sharedPreferences.getBoolean(
                    SettingsActivity.DISPLAY_HAND_SEC_KEY, true
                )
            }
        }

        init {
            prefs.registerOnSharedPreferenceChangeListener(this)
            displayHandSec = prefs.getBoolean(
                SettingsActivity.DISPLAY_HAND_SEC_KEY, true
            )
            paint = Paint()
            paint.isAntiAlias = true
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 5f
            bgColor = Color.parseColor("#f5deb3")
            clock = AnalogClock(applicationContext)
            handler.post(drawRunner)
        }
    }
}