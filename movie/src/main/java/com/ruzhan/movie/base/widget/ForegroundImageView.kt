package com.ruzhan.movie.base.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import com.ruzhan.common.R

open class ForegroundImageView : AppCompatImageView {

    private var foreground: Drawable? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ForegroundView)

        val d = a.getDrawable(R.styleable.ForegroundView_android_foreground)
        if (d != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setForeground(d)
            }
        }
        a.recycle()
        outlineProvider = ViewOutlineProvider.BOUNDS
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        foreground?.setBounds(0, 0, w, h)
    }

    override fun hasOverlappingRendering(): Boolean {
        return false
    }

    override fun verifyDrawable(who: Drawable): Boolean {
        return super.verifyDrawable(who) || who === foreground
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        foreground?.jumpToCurrentState()
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        foreground?.let { foreground ->
            if (foreground.isStateful) {
                foreground.state = drawableState
            }
        }
    }

    override fun getForeground(): Drawable? {
        return foreground
    }

    override fun setForeground(drawable: Drawable) {
        foreground?.let { foreground ->
            if (foreground !== drawable) {
                foreground.callback = null
                unscheduleDrawable(foreground)
                setForeground(drawable)
                foreground.setBounds(0, 0, width, height)
                setWillNotDraw(false)
                foreground.callback = this
                if (foreground.isStateful) {
                    foreground.state = drawableState
                }
                invalidate()
            }
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        foreground?.draw(canvas)
    }

    override fun drawableHotspotChanged(x: Float, y: Float) {
        super.drawableHotspotChanged(x, y)
        foreground?.setHotspot(x, y)
    }
}
