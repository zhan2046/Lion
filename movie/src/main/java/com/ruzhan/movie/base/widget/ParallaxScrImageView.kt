package com.ruzhan.movie.base.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

import androidx.annotation.FloatRange
import com.ruzhan.movie.R

import com.ruzhan.movie.utils.AnimUtils
import com.ruzhan.movie.utils.ColorUtils

@Suppress("NAME_SHADOWING")
class ParallaxScrImageView : ForegroundImageView {
    private var scrimPaint: Paint? = null
    private var imageOffset: Int = 0
    private var minOffset: Int = 0
    private val defaultClipBounds = Rect()
    private var scrimAlpha = 0f
    private var maxScrimAlpha = 1f
    private var scrimColor = Color.TRANSPARENT
    private var parallaxFactor = -0.5f
    var isPinned = false
        set(isPinned) {
            if (this.isPinned != isPinned) {
                field = isPinned
                refreshDrawableState()
                if (isPinned && isImmediatePin) {
                    jumpDrawablesToCurrentState()
                }
            }
        }
    var isImmediatePin = false

    var offset: Int
        get() = translationY.toInt()
        set(offset) {
            var offset = offset
            offset = minOffset.coerceAtLeast(offset)
            if (offset.toFloat() != translationY) {
                translationY = offset.toFloat()
                imageOffset = (offset * parallaxFactor).toInt()
                defaultClipBounds.set(0, -offset, width, height)
                clipBounds = defaultClipBounds
                setScrimAlpha(((-offset).toFloat() / minimumHeight * maxScrimAlpha)
                        .coerceAtMost(maxScrimAlpha))
                postInvalidateOnAnimation()
            }
            isPinned = offset == minOffset
        }

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
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.ParallaxScrimageView)
        if (a.hasValue(R.styleable.ParallaxScrimageView_scrimColor)) {
            scrimColor = a.getColor(R.styleable.ParallaxScrimageView_scrimColor, scrimColor)
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_scrimAlpha)) {
            scrimAlpha = a.getFloat(R.styleable.ParallaxScrimageView_scrimAlpha, scrimAlpha)
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_maxScrimAlpha)) {
            maxScrimAlpha = a.getFloat(R.styleable.ParallaxScrimageView_maxScrimAlpha,
                    maxScrimAlpha)
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_parallaxFactor)) {
            parallaxFactor = a.getFloat(R.styleable.ParallaxScrimageView_parallaxFactor,
                    parallaxFactor)
        }
        a.recycle()

        scrimPaint = Paint()
        scrimPaint!!.color = ColorUtils.modifyAlpha(scrimColor, scrimAlpha)
    }

    private fun setScrimAlpha(@FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        if (scrimAlpha != alpha) {
            scrimAlpha = alpha
            scrimPaint!!.color = ColorUtils.modifyAlpha(scrimColor, scrimAlpha)
            postInvalidateOnAnimation()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (h > minimumHeight) {
            minOffset = minimumHeight - h
        }
    }

    @SuppressLint("CanvasSize")
    override fun onDraw(canvas: Canvas) {
        if (imageOffset != 0) {
            val saveCount = canvas.save()
            canvas.translate(0f, imageOffset.toFloat())
            super.onDraw(canvas)
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), scrimPaint!!)
            canvas.restoreToCount(saveCount)
        } else {
            super.onDraw(canvas)
            canvas.drawRect(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat(), scrimPaint!!)
        }
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (this.isPinned) {
            View.mergeDrawableStates(drawableState, STATE_PINNED)
        }
        return drawableState
    }

    companion object {

        private val STATE_PINNED = intArrayOf(R.attr.state_pinned)

        val OFFSET = AnimUtils.createIntProperty(
                object : AnimUtils.IntProp<ParallaxScrImageView>("offset") {
            override fun set(`object`: ParallaxScrImageView, value: Int) {
                `object`.offset = value
            }

            override fun get(`object`: ParallaxScrImageView): Int {
                return `object`.offset
            }
        })
    }
}
